package com.yatop.lambda.tools.sql

import org.apache.spark.sql.catalyst.analysis.{Analyzer, EliminateSubqueryAliases, FunctionRegistry}
import org.apache.spark.sql.catalyst.catalog.{InMemoryCatalog, SessionCatalog}
import org.apache.spark.sql.catalyst.expressions.AttributeReference
import org.apache.spark.sql.catalyst.parser.CatalystSqlParser
import org.apache.spark.sql.catalyst.plans.logical.{LocalRelation, LogicalPlan}
import org.apache.spark.sql.internal.SQLConf
import org.apache.spark.sql.types._

import scala.collection.mutable.ArrayBuffer


class ParseProjection() {

  //parsePlan
  private val parser = CatalystSqlParser

  def parsePlan(sqlStmt: String): LogicalPlan = {
    parser.parsePlan(sqlStmt)
  }

  def analyze(catalog: SessionCatalog, unresolvedPlan: LogicalPlan): LogicalPlan = {

    val analyzer = new Analyzer(catalog, ParseHelper.sqlConf) {
      /*override val extendedResolutionRules = EliminateSubqueryAliases :: Nil*/
    }

    analyzer.execute(unresolvedPlan)
  }
}

object ParseHelper {
  private val nonDecimalNameToType = {
    Seq(NullType, DateType, TimestampType, BinaryType, IntegerType, BooleanType, LongType,
      DoubleType, FloatType, ShortType, ByteType, StringType, CalendarIntervalType)
      .map(t => t.typeName -> t).toMap
  }

  /** Given the string representation of a type, return its DataType */
  private def nameToType(name: String): DataType = {
    val FIXED_DECIMAL = """decimal\(\s*(\d+)\s*,\s*(\-?\d+)\s*\)""".r
    name match {
      case "decimal" => DecimalType.USER_DEFAULT
      case FIXED_DECIMAL(precision, scale) => DecimalType(precision.toInt, scale.toInt)
      case other => nonDecimalNameToType(other)
    }
  }

/*
  for spark 2.1.x
  val catalystConf = new CatalystConf {
    def caseSensitiveAnalysis: Boolean = false
    def orderByOrdinal: Boolean = true
    def groupByOrdinal: Boolean = true
    def optimizerMaxIterations: Int = 100
    def optimizerInSetConversionThreshold: Int = 10
    def maxCaseBranchesForCodegen: Int = 20
    def tableRelationCacheSize: Int = 1000
    def runSQLonFile: Boolean = true
    def crossJoinEnabled: Boolean = true
    def cboEnabled: Boolean = true
    def warehousePath: String = "/user/hive/warehouse"
    def sessionLocalTimeZone: String = java.util.TimeZone.getDefault.getID
  }*/

  val sqlConf = new SQLConf {
    override def caseSensitiveAnalysis: Boolean = false
    override def orderByOrdinal: Boolean = true
    override def groupByOrdinal: Boolean = true
    override def optimizerMaxIterations: Int = 100
    override def optimizerInSetConversionThreshold: Int = 10
    override def tableRelationCacheSize: Int = 1000
    override def runSQLonFile: Boolean = true
    override def crossJoinEnabled: Boolean = true
    override def cboEnabled: Boolean = true
    override def warehousePath: String = "/user/hive/warehouse"
    override def sessionLocalTimeZone: String = java.util.TimeZone.getDefault.getID
  }

/*
  for spark 2.1.x
  def makeSessionCatalog(): SessionCatalog = {
    new SessionCatalog(new InMemoryCatalog, FunctionRegistry.builtin, catalystConf)
  }
*/

  def makeSessionCatalog(): SessionCatalog = {
    new SessionCatalog(new InMemoryCatalog, FunctionRegistry.builtin, sqlConf)
  }

  def makeAttributeArray(): ArrayBuffer[AttributeReference] = {
    new ArrayBuffer[AttributeReference]()
  }

  // null, date, timestamp, binary, integer, boolean, long, double, float,
  // short, byte, string, calendarinterval, decimal(n, m)
  def addAttributeReference(fields: ArrayBuffer[AttributeReference], fieldName: String, dataType: String): Unit = {
    fields += AttributeReference(fieldName, nameToType(dataType))()
  }

  def registerTemporaryTable(catalog: SessionCatalog, tableName: String, fields: ArrayBuffer[AttributeReference]): Unit = {
    catalog.createTempView(tableName, LocalRelation(fields), overrideIfExists = true)
  }
}

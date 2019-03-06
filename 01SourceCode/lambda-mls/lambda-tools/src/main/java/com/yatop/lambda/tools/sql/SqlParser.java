package com.yatop.lambda.tools.sql;

import org.apache.spark.sql.catalyst.catalog.SessionCatalog;
import org.apache.spark.sql.catalyst.expressions.AttributeReference;
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.collection.mutable.ArrayBuffer;

/**
 * Hello world!
 *
 */
public class SqlParser
{

    public static LogicalPlan parse(String sqlStmt) {

        ParseProjection pp = new ParseProjection();
        LogicalPlan unresolvedPlan = pp.parsePlan(sqlStmt);
        return unresolvedPlan;
    }

    public static SessionCatalog makeSessionCatalog() {
        return ParseHelper.makeSessionCatalog();
    }

    public static LogicalPlan analyze(SessionCatalog catalog, LogicalPlan unresolvedPlan) {
        ParseProjection pp = new ParseProjection();
        LogicalPlan resolvedPlan = pp.analyze(catalog, unresolvedPlan);
        return resolvedPlan;
    }

    public static void main(String[] args) {

        SessionCatalog catalog = ParseHelper.makeSessionCatalog();

        //register t1 temporary table
        ArrayBuffer<AttributeReference> t1_fields = ParseHelper.makeAttributeArray();
        ParseHelper.addAttributeReference(t1_fields, "name", "string");
        ParseHelper.addAttributeReference(t1_fields, "age", "short");
        ParseHelper.addAttributeReference(t1_fields, "gender", "string");
        ParseHelper.addAttributeReference(t1_fields, "country", "string");
        ParseHelper.addAttributeReference(t1_fields, "ssn", "string");
        ParseHelper.registerTemporaryTable(catalog, "t1", t1_fields);

        //register t2 temporary table
        ArrayBuffer<AttributeReference> t2_fields = ParseHelper.makeAttributeArray();
        ParseHelper.addAttributeReference(t2_fields, "ssn", "string");
        ParseHelper.addAttributeReference(t2_fields, "account", "short");
        ParseHelper.addAttributeReference(t2_fields, "bank", "string");
        ParseHelper.addAttributeReference(t2_fields, "balance", "decimal(10, 4)");
        ParseHelper.registerTemporaryTable(catalog, "t2", t2_fields);

        //parse and analyze sql statment
        ParseProjection pp = new ParseProjection();
        //LogicalPlan unresolvedPlan = pp.parsePlan("select t1.*, t2.* from t1, t2 where t1.ssn = t2.ssn");
        LogicalPlan unresolvedPlan = pp.parsePlan("select first.* from t1 as first, t1 as second where first.ssn = second.ssn");

        //LogicalPlan unresolvedPlan = pp.parsePlan("SELECT first.* FROM t1 as first left join t1 as second on first
        // .ssn = second.ssn");
        LogicalPlan resolvedPlan = pp.analyze(catalog, unresolvedPlan);
        StructType st = resolvedPlan.schema();

        //print output fields
        for(int i = 0; i < st.length(); i++) {
            StructField sf = st.fields()[i];
            StringBuilder sb = new StringBuilder();
            sb.append("[" + i + "]").append("\t")
                    .append(sf.name()).append("\t")
                    .append(sf.dataType().typeName()).append("\n");
            System.out.println(sb.toString());
        }
    }
}

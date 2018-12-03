/**
 *    Copyright 2006-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.plugins;

import org.apache.commons.beanutils.PropertyUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.OutputUtilities;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.PropertyRegistry;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import static org.mybatis.generator.internal.util.JavaBeansUtil.getGetterMethodName;
import static org.mybatis.generator.internal.util.JavaBeansUtil.getSetterMethodName;
import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * nothing for introduce, LOL
 *
 * @author lidd
 *
 */
public class LambdaEnhancedPlugin extends PluginAdapter {

    //private boolean useEqualsHashCodeFromRoot;

/*    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        useEqualsHashCodeFromRoot = isTrue(properties.getProperty("useEqualsHashCodeFromRoot"));
    }*/

    /**
     * This plugin is always valid - no properties are required
     */
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {
        List<IntrospectedColumn> columns;
        if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
            columns = introspectedTable.getNonBLOBColumns();
        } else {
            columns = introspectedTable.getAllColumns();
        }

        generateLambdaCopyProperties(topLevelClass, columns, introspectedTable);
        generateLambdaToJSON(topLevelClass, columns, introspectedTable);

        return true;
    }

/*    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        generateLambdaCopyProperties(topLevelClass, introspectedTable.getPrimaryKeyColumns(),
                introspectedTable);
        generateLambdaToJSON(topLevelClass, introspectedTable
                .getPrimaryKeyColumns(), introspectedTable);

        return true;
    }*/

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        generateLambdaCopyProperties(topLevelClass, introspectedTable.getAllColumns(),
                introspectedTable);
        generateLambdaToJSON(topLevelClass, introspectedTable.getAllColumns(),
                introspectedTable);

        return true;
    }

    /**
     *
     * @param topLevelClass
     *            the class to which the method will be added
     * @param introspectedColumns
     *            column definitions of this class and any superclass of this
     *            class
     * @param introspectedTable
     *            the table corresponding to this class
     */
    protected void generateLambdaCopyProperties(TopLevelClass topLevelClass,
                                      List<IntrospectedColumn> introspectedColumns,
                                      IntrospectedTable introspectedTable) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("copyProperties");
        method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "that"));
/*        if (introspectedTable.isJava5Targeted()) {
            method.addAnnotation("@Override"); //$NON-NLS-1$
        }*/

        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);

        method.addBodyLine("if (this == that || that == null || this.getClass() != that.getClass() ) {"); //$NON-NLS-1$
        method.addBodyLine("return;"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$

        StringBuilder sb = new StringBuilder();
        sb.append(topLevelClass.getType().getShortName());
        sb.append(" other = ("); //$NON-NLS-1$
        sb.append(topLevelClass.getType().getShortName());
        sb.append(") that;"); //$NON-NLS-1$
        method.addBodyLine(sb.toString());

        /*if (useEqualsHashCodeFromRoot && topLevelClass.getSuperClass() != null) {
            method.addBodyLine("if (!super.equals(other)) {"); //$NON-NLS-1$
            method.addBodyLine("return false;"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
        }*/

        Iterator<IntrospectedColumn> iter = introspectedColumns.iterator();
        while (iter.hasNext()) {
            IntrospectedColumn introspectedColumn = iter.next();
            IntrospectedColumn introspectedColumnColour = new IntrospectedColumn();
            try {
                PropertyUtils.copyProperties(introspectedColumnColour, introspectedColumn);
                introspectedColumnColour.setActualColumnName(introspectedColumnColour.getActualColumnName() + ":Coloured");
                introspectedColumnColour.setFullyQualifiedJavaType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
                introspectedColumnColour.setIdentity(false);
                introspectedColumnColour.setJavaProperty(introspectedColumnColour.getJavaProperty() + "Coloured");
                introspectedColumnColour.setProperties(new Properties());
                for(Iterator<Object> iterator = introspectedColumn.getProperties().keySet().iterator(); iterator.hasNext();){
                    Object key = iterator.next();
                    introspectedColumnColour.getProperties().put(key, introspectedColumn.getProperties().get(key));
                }
                introspectedColumnColour.getProperties().put(PropertyRegistry.MODEL_GENERATOR_TRIM_STRINGS, "false");

            } catch (Throwable e) {
                System.err.println("PropertyUtils.copyProperties Exception!!!");
                System.exit(-1);
            }

            String getterMethod = getGetterMethodName(introspectedColumn.getJavaProperty(), introspectedColumn.getFullyQualifiedJavaType());
            String setterMethod = getSetterMethodName(introspectedColumn.getJavaProperty());
            String getterMethodColoured = getGetterMethodName(introspectedColumnColour.getJavaProperty(), introspectedColumnColour.getFullyQualifiedJavaType());

            sb.setLength(0);
            sb.append("if(other.").append(getterMethodColoured).append("() )");
            sb.append(" {this.").append(setterMethod).append("(").append("other.").append(getterMethod).append("() );}");
            method.addBodyLine(sb.toString());
        }

        method.addBodyLine("return;");
        topLevelClass.addMethod(method);
    }

    /**
     *
     * @param topLevelClass
     *            the class to which the method will be added
     * @param introspectedColumns
     *            column definitions of this class and any superclass of this
     *            class
     * @param introspectedTable
     *            the table corresponding to this class
     */
    protected void generateLambdaToJSON(TopLevelClass topLevelClass,
                                     List<IntrospectedColumn> introspectedColumns,
                                     IntrospectedTable introspectedTable) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("toJSON");
        method.setReturnType(new FullyQualifiedJavaType("com.alibaba.fastjson.JSONObject"));
        topLevelClass.addImportedType(FullyQualifiedJavaType.getNewHashMapInstance());
        topLevelClass.addImportedType("com.alibaba.fastjson.JSON");
        topLevelClass.addImportedType("com.alibaba.fastjson.JSONObject");
/*        if (introspectedTable.isJava5Targeted()) {
            method.addAnnotation("@Override"); //$NON-NLS-1$
        }*/

        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        method.addBodyLine("HashMap<String, Object> hashMap = new HashMap();");

        StringBuilder sb = new StringBuilder();
        Iterator<IntrospectedColumn> iter = introspectedColumns.iterator();
        while (iter.hasNext()) {
            IntrospectedColumn introspectedColumn = iter.next();
            String fieldName = introspectedColumn.getJavaProperty();
            sb.setLength(0);
            sb.append("if(this.").append(fieldName).append("Coloured)");
            sb.append(" {hashMap.put(\"").append(fieldName).append("\", ").append("this.").append(fieldName).append(");}");
            method.addBodyLine(sb.toString());
        }

        method.addBodyLine("return (JSONObject) JSON.toJSON(hashMap);"); //$NON-NLS-1$
        topLevelClass.addMethod(method);
    }
}
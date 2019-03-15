package com.yatop.lambda.workflow.core.framework.module;

import com.yatop.lambda.workflow.core.context.ExecutionTaskContext;
import com.yatop.lambda.workflow.core.context.WorkflowContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.Node;
import com.yatop.lambda.workflow.core.richmodel.workflow.node.NodeSchema;

import java.util.TreeMap;
import java.util.TreeSet;

public interface IModuleClazz {
    //方法失败或异常抛出Exception，Module类实现该接口，适当封装一些中间abstract组件类以便复用

    //校验参数逻辑，例如：数据表读取组件需要校验对应的数据表是否正常
    //key:CmptChar, warningMessage
    TreeMap<CmptChar, String> validateParameters(WorkflowContext workflowContext, Node node);

    //生成摘要内容
    //String generateSummary(Node node);

    //////////////////////////////////////////////////////

    //探测节点输出
    void exploreOutputAndResource(Node node);

    //准备节点输出
    void prepareOutputAndResource(WorkflowContext workflowContext, Node node);

    //完成节点输出
    void completeOutputAndResource(WorkflowContext workflowContext, Node node);

    //清除节点输出
    void clearOutputAndResource(WorkflowContext workflowContext, Node node);

    //删除节点输出
    void deleteOutputAndResource(WorkflowContext workflowContext, Node node);

    //恢复节点输出
    void recoverOutputAndResource(WorkflowContext workflowContext, Node node);

    //////////////////////////////////////////////////////

    //本地运行，组件无需提交集群时，引擎将调用该方法，例如：算法组件的输出内容由本地进行计算
    //出错时，在方法内部对task调用setOccuredWarning进行warning message做设置
    void execute(ExecutionTaskContext context);

    //////////////////////////////////////////////////////

    //是否支持动态分析数据输出端口schema
    //返回false，不支持
    //返回true，支持
    boolean supportAnalyzeSchema();

    //影响重新分析schema的参数集合
    //返回特征集合
    TreeSet<CmptChar> reanalyzeSchemaParameterSet();
    /* {
        static final TreeSet<String> parameterSet = new TreeSet<String>() {{
            add(componentConfig.getCharacteristic("char-id-A"));
            add(componentConfig.getCharacteristic("char-id-B"));
            add(componentConfig.getCharacteristic("char-id-C"));
        }};
        return parameterSet;
    };*/

    //分析数据输出端口schema
    //key:OutputPort-CmptChar, NodeSchema
    TreeMap<CmptChar, NodeSchema> analyzeSchema(WorkflowContext workflowContext, Node node, TreeMap<CmptChar, NodeSchema> upstreamSchemas);
}

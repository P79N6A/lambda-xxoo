package com.yatop.lambda.workflow.core.module;

import org.springframework.beans.factory.InitializingBean;

/*

CharType类，负责特征层面的事件捕获，承担特征值发生创建（对象创建）、删除（对象删除）、查询（对象展开）、更新（对象更新）时的自定义处理，以及特征值正确性和合法性的常规校验
Module类，负责节点层面的事件捕获，承担节点发生创建、删除、查询、参数更新、任务运行时的逻辑校验和自定义处理，以及节点输出端口schema分析

CharType类&Module类节点事件流处理说明：
（1）Create Node Begin --> CharType.validateValue --> CharType.onCreateValue --> ${Engine Insert Node & Port & Schema & Parameter} --> Module.onCreateNode --> ${Engine Accept Change} --> Create Node End

（2）Delete Node Begin --> ${Engine Fetch Node Content} --> CharType.onQueryValue --> Module.onDeleteNode --> ${Engine Merge Change} --> CharType.onDeleteValue -->
	 ${Engine Delete Node & Port & Schema & Parameter & Link & Global Parameter} --> Engine Push(Node Delete Queue) --> ${Engine Loop(Downstream Node Schema Clean<Empty Schema>)} --> Delete Node End

Support Canvas Node & Snapshot Node
（3）Query Node Begin --> ${Engine Fetch Node Content} --> ${Engine Global Parameter Override(From Scheduler Execution)} --> CharType.onQueryValue --> Module.onQueryNode --> ${Engine Accept Change} --> Query Node End

（4）Update Parameter Begin --> CharType.validateValue --> ${Engine Fetch Node Content} --> CharType.onQueryValue --> CharType.onUpdateValue --> Module.onUpdateParameter --> ${Engine Accept Change} -->
	 ${Engine Loop(Cur & Downstream Node Schema Analyze)} --> Update Parameter End

（5）Inbound Link Begin --> ${Engine Loop(Cur & Downstream Node Schema Analyze)} --> Inbound Link End

（6）Outbound Link Begin --> ${Engine Nothing To Do} --> Outbound Link End

（7）Update Script Begin --> ${Engine Fetch Node Content & Script Context} --> CharType.onQueryValue --> CharType.onUpdateValue --> Module.onUpdateParameter --> ${Engine Accept Change} -->
	 ${Engine Loop(Cur & Downstream Node Schema Analyze)} --> Update Script End

Support Canvas Node & Snapshot Node
（8）Execute Task Begin --> ${Engine Fetch Task Context} --> ${Engine Query Node} --> CharType.onQueryValue<Execution, Optimzation Execution, Input> --> ${Engine Complete Task Context(Output)} -->
	 Module.onTaskExecution --> CharType.onCreateValue<Output> -->
	 ${Engine Complete Task Context(Output)} --> ${Engine Submit Task} --> ${Engine Monitor Task Return} --> CharType.onUpdateValue<Output> --> ${Engine Accept Return(Task|Node)} -->
	 Execute Task End

Support Canvas Node & Snapshot Node
（9）Execute Job Begin --> ${Engine Fetch Job Context} --> ${Engine Analyze Effective Job Content} --> ${Engine Analyze Job Path} --> ${Engine Analyze Header Task} --> ${Engine Loop(Execute Task<By Path>)} -->
	 ${Engine Accept Finish(None|Flow|Scheduler)} --> Execute Job End

（10）Create Global Parameter Begin --> ${Engine Check Allow Global} --> CharType.validateValue --> CharType.onCreateValue --> ${Engine Insert Global Parameter} --> Create Global Parameter End

（11）Delete Global Parameter Begin --> ${Engine Fetch Global Parameter} --> CharType.onQueryValue --> CharType.onDeleteValue --> ${Engine Delete Global Parameter} --> Delete Global Parameter End

（12）Query Global Parameter Begin --> ${Engine Fetch Global Parameter} --> CharType.onQueryValue --> Query Global Parameter End

（13）Update Global Parameter Begin --> ${Engine Fetch Global Parameter} --> CharType.validateValue --> CharType.onQueryValue --> CharType.onUpdateValue --> ${Engine Update Global Parameter} -- Update Global Parameter End

*/



//组件基类（在组件参数特征类型捕获事件通过基础上，对组件的特定业务逻辑做进一步校验判断，Module类不捕获执行调优参数事件，仅CharType类捕获执行调优参数事件）

public interface IModule extends InitializingBean {
    //出现严重错误会导致逻辑崩溃抛出moduleException，组件类实现该接口，适当封装一些中间abstract组件类以便复用

    ////////////////////////////////////组件bean注册//////////////////////////////////////////
/*    @Override
    public void afterPropertiesSet() throws Exception {

    }*/

    //////////////////////////////节点参数校验事件相关//////////////////////////////////

    //是否捕获参数校验事件
    //返回false，否
    //返回true，是
    //boolean catchCheckParameter();

    //校验参数处理，例如：数据表读取组件需要校验对应的数据表是否正常，存在情况下，设置节点状态为ready，否则为not ready
    //返回更新部分的node-content，NULL代表无更新（仅限节点信息）
    //NodeContentDto onCheckParameter(NodeContentDto<node, parameter, inputPorts, outputPorts>, updateParameterList);

    ///////////////////////////////////任务执行事件相关/////////////////////////////////////////

    //是否捕获任务执行事件
    //返回false，否
    //返回true，是
    boolean catchTaskExecution();

    //任务执行事件处理，例如：读数据表将输出内容"OUT@DataTable-t1<M>"特征值置为"CCP@TableName"特征值对应数据表的ID值
    //返回更新部分的task-context信息，NULL代表无更新
    //TaskContextDto onTaskExecution(TaskContextDto<task, component, execution, optimize_execution, input, output, parameter>);


    ////////////////////////////////////运行动态模拟相关////////////////////////////////////////

    //是否支持动态分析数据输出端口schema
    //返回false，不支持
    //返回true，支持
    boolean supportAnalyzeSchema();

    //触发分析数据输出端口schema的特征代码集合
    //返回特征代码集合，NULL代表无触发特征
/*    paremeterCodeSet analyzeSchemaTriggerParameters() {
        static final HashSet<parameterCode> triggerParameters = new HashSet<String>() {{
            add("xxx");
            add("yyy");
        }};
        resturn triggerParameters;
    };*/

    //分析数据输出端口schema
    //返回更新部分的数据输出端schema列表，NULL代表无更新
    //OutportSchemaDtoList analyzeSchema(NodeContentDto<node, parameter, inputPorts, outputPorts>);
}

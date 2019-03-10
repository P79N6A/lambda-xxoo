package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;

public interface ICharTypeClazz {
    //方法失败或异常抛出Exception，CharType类实现该接口，适当封装一些中间abstract组件类以便复用

    //创建节点特征值内容
    void createCharValue(CharValueContext context);

    //删除节点特征值内容
    void deleteCharValue(CharValueContext context);

    //恢复节点特征值内容
    void recoverCharValue(CharValueContext context);

    //清除节点特征值内容（输出特征用）
    void clearCharValue(CharValueContext context);

    //完成节点特征值内容（输出特征用）
    void completeCharValue(CharValueContext context);

    //更新节点特征值内容
    void updateCharValue(CharValueContext context);

    //查询节点特征值内容
    void queryCharValue(CharValue charValue);


    //校验节点特征值内容
    //返回false，不通过
    //返回true，通过
    boolean validateCharValue(CharValue charValue);


    //转换节点特征值内容，用于填写json:value值内容
    Object toJsonValue(CharValue charValue);

    //解析节点特征值内容，用于对json-value值内容解析（输出特征用）
    void parseJsonValue(CharValue charValue, Object obj);

    //判断特征值内容是否为空
    boolean isEmptyCharValue(CharValue charValue);
}

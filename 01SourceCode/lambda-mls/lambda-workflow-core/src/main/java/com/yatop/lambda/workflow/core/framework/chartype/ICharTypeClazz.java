package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import com.yatop.lambda.workflow.core.richmodel.workflow.charvalue.CharValue;
import org.springframework.beans.factory.InitializingBean;

public interface ICharTypeClazz /*extends InitializingBean*/ {
    //方法失败或异常抛出Exception，CharType类实现该接口，适当封装一些中间abstract组件类以便复用

    //创建节点特征值内容
    void createCharValue(CharValueContext context);

    //删除节点特征值内容
    void deleteCharValue(CharValueContext context);

    //恢复节点特征值内容
    void recoverCharValue(CharValueContext context);

    //清除节点特征值内容
    void clearCharValue(CharValueContext context);

    //更新节点特征值内容
    void updateCharValue(CharValueContext context);

    //查询节点特征值内容
    void queryCharValue(CharValue charValue);

    //校验节点特征值内容
    //返回false，不通过
    //返回true，通过
    boolean validateCharValue(CharValue charValue);

    //转换节点特征值，用于json对象的特征值内容生成
    Object toJSONValue(CharValue charValue);

    //解析节点特征值，用于json对象的特征值内容解析
    void parseJSONValue(CharValue charValue, Object obj);
}

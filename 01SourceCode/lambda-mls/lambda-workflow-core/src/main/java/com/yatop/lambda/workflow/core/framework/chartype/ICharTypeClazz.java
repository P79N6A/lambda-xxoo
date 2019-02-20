package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import org.springframework.beans.factory.InitializingBean;

public interface ICharTypeClazz extends InitializingBean {
    //方法失败或异常抛出Exception，CharType类实现该接口，适当封装一些中间abstract组件类以便复用

    //创建节点参数特征值内容
    void createParamCharValue(CharValueContext context);

    //删除节点参数特征值内容
    void deleteParamCharValue(CharValueContext context);

    //恢复节点参数特征值内容
    void recoverParamCharValue(CharValueContext context);

    //查询节点参数特征值内容
    void queryParamCharValue(CharValueContext context);

    //更新节点参数特征值内容
    void updateParamCharValue(CharValueContext context);

    //校验节点参数特征值内容
    //返回false，不通过
    //返回true，通过
    boolean validateParamCharValue(CharValueContext context);

    ////////////////////////////////////////////////////////////////////////////

    //探测节点输出特征值内容
    void exploreOutputCharValue(CharValueContext context);

    //准备节点输出特征值内容
    void prepareOutputCharValue(CharValueContext context);

    //完成节点输出特征值内容
    void completeOutputCharValue(CharValueContext context);

    //清理节点输出特征值内容
    void clearOutputCharValue(CharValueContext context);

    //删除节点输出特征值内容
    void deleteOutputCharValue(CharValueContext context);

    //恢复节点输出特征值内容
    void recoverOutputCharValue(CharValueContext context);
}

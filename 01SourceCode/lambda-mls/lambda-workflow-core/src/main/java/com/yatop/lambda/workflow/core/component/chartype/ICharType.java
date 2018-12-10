package com.yatop.lambda.workflow.core.component.chartype;

import org.springframework.beans.factory.InitializingBean;

//组件基类（在组件参数特征类型捕获事件通过基础上，对组件的特定业务逻辑做进一步校验判断，Module类不捕获执行调优参数事件，仅CharType类捕获执行调优参数事件）

public interface ICharType extends InitializingBean {
    //方法失败或异常抛出moduleException，组件类实现该接口，适当封装一些中间abstract组件类以便复用

    ////////////////////////////////////组件bean注册//////////////////////////////////////////
/*    @Override
    public void afterPropertiesSet() throws Exception {

    }*/

    //////////////////////////////节点增删查和参数更改事件相关//////////////////////////////////

    //是否捕获特征值新增事件
    //返回false，否
    //返回true，是
    boolean catchCreateValue();

    //发生特征值新增时（创建对象，设置对象内容）
    //void onCreateValue(CharValueContentDto<char, charValue>);

    //是否捕获特征值删除事件
    //返回false，否
    //返回true，是
    boolean catchDeleteValue();

    //发生特征值删除时（删除对象）
    //void onDeleteValue(CharValueContentDto<char, charValue>);

    //是否捕获特征值恢复事件
    //返回false，否
    //返回true，是
    boolean catchRecoverValue();

    //发生特征值恢复时（恢复对象）
    //void onRecoverValue(CharValueContentDto<char, charValue>);

    //是否捕获特征值查询事件
    //返回false，否
    //返回true，是
    boolean catchQueryValue();

    //发生特征值查询时（展开对象，设置对象内容）
    //void onQueryValue(CharValueContentDto<char, charValue>);

    //是否捕获特征值更改事件
    //返回false，否
    //返回true，是
    boolean catchUpdateValue();

    //发生特征值更改时（更新对象，设置对象内容，updateCharValue传入对象修改内容）
    //void onUpdateValue(CharValueContentDto<char, charValue>, updateCharValue);

    //必须，校验特征值正确性和合法性
    //返回false，不通过
    //返回true，通过
    //boolean validateValue(CharValueContentDto<char, charValue>);
}

package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.core.enums.LambdaExceptionEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public abstract class CharTypeClazzBaseClazz implements ICharTypeClazz {

    public static Logger logger = LoggerFactory.getLogger(CharTypeClazzBaseClazz.class);

    //<class-path, bean-object>
    private static final HashMap<String, ICharTypeClazz> CLAZZ_BEANS = new HashMap<String, ICharTypeClazz>();

    public static ICharTypeClazz getClazzBean(String clazzPath) {
        ICharTypeClazz clazzBean = CollectionUtil.get(CLAZZ_BEANS, clazzPath);
        if(DataUtil.isNull(clazzBean)) {

            try {
                Class.forName(clazzPath).newInstance();
            } catch (Throwable e) {
                throw new LambdaException(LambdaExceptionEnum.F_WORKFLOW_DEFAULT_ERROR, "Initialize Char-Type-Clazz bean failed.", "工作流组件配置错误，请联系管理员", e);
            }

            clazzBean = CollectionUtil.get(CLAZZ_BEANS, clazzPath);
        }

        return clazzBean;
    }

    private static void putClazzBean(String clazzPath, ICharTypeClazz charTypeBean) {
        CollectionUtil.put(CLAZZ_BEANS, clazzPath, charTypeBean);
    }

    public CharTypeClazzBaseClazz() {
        CharTypeClazzBaseClazz.putClazzBean(this.getClass().getName(), this);
    }
}

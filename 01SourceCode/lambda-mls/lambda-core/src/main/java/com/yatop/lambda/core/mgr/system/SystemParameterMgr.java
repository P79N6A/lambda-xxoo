package com.yatop.lambda.core.mgr.system;

import com.yatop.lambda.base.model.SysParameter;
import com.yatop.lambda.base.model.SysParameterExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemParameterMgr extends BaseMgr {

    public List<SysParameter> queryAll() {
        SysParameterExample example = new SysParameterExample();
        example.createCriteria().andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
        return sysParameterMapper.selectByExample(example);
    }
}

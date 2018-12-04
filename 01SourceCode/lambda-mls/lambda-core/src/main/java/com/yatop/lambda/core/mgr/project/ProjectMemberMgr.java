package com.yatop.lambda.core.mgr.project;

import com.yatop.lambda.base.model.PrProjectMember;
import com.yatop.lambda.base.model.PrProjectMemberExample;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.ProjectOwnerEnum;
import com.yatop.lambda.core.exception.LambdaException;
import com.yatop.lambda.core.mgr.base.BaseMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.core.utils.SystemTimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProjectMemberMgr extends BaseMgr {

    /*
     *
     *   插入项目成员记录（项目ID、是否为所有者、用户名、描述）
     *   返回插入记录
     *
     * */
    public PrProjectMember insertProjectMember(PrProjectMember prMember, String operId) {
        if( DataUtil.isNull(prMember) ||
                !prMember.isProjectIdColoured() ||
                !prMember.isIsOwnerColoured() ||
                !prMember.isMemberUserColoured() ||
                DataUtil.isEmpty(operId) ) {
            throw new LambdaException("Insert project member failed -- invalid insert data.", "无效插入内容");
        }

        if(prMember.getIsOwner() == ProjectOwnerEnum.OWNER.getTag()) {
            boolean isConflict;
            try {
                isConflict = existsProjectOwner(prMember.getProjectId(), prMember.getMemberUser());
            } catch (Throwable e) {
                throw new LambdaException("Insert project member failed -- check exists project owner failed.", "检查已存在项目失败", e);
            }
            if (isConflict) {
                throw new LambdaException("Insert project member failed -- project owner existed.", "项目所有者已存在");
            }
        }

        PrProjectMember insertMember = new PrProjectMember();
        try {
            Date dtCurrentTime = SystemTimeUtil.getCurrentTime();
            BeanUtils.copyProperties(prMember, insertMember);
            insertMember.setStatus(DataStatusEnum.NORMAL.getStatus());
            insertMember.setLastUpdateTime(dtCurrentTime);
            insertMember.setLastUpdateOper(operId);
            insertMember.setCreateTime(dtCurrentTime);
            insertMember.setCreateOper(operId);

            prProjectMemberMapper.insertSelective(insertMember);
        } catch (Throwable e) {
            throw new LambdaException("Insert project member failed.", "新增项目成员失败", e);
        }

        return insertMember;
    }

    /*
     *
     *   更改项目所有者
     *   返回更新数量
     *
     * */
    public int changeProjectOwner(Long projectId, String srcOwner, String dstOwner, String operId)  {
        if(DataUtil.isNull(projectId) ||
                DataUtil.isEmpty(srcOwner) ||
                DataUtil.isEmpty(dstOwner) ||
                DataUtil.isEmpty(operId)){
            throw new LambdaException("Change project Owner failed -- invalid change data.", "无效更改内容");
        }

        List<PrProjectMember> resultList;
        try {
            resultList = queryProjectMemberByProjectId(projectId, new ArrayList<String>(Arrays.asList(srcOwner, dstOwner)));
        } catch (Throwable e) {
            throw new LambdaException("Change project member failed -- query project member.", "查询项目成员失败", e);
        }

        if(DataUtil.isEmpty(resultList) || resultList.size() < 2)
            throw new LambdaException("Change project member failed -- project member missing", "转出或转入成员记录缺失");

        PrProjectMember srcProjectMember;
        PrProjectMember dstProjectMember;
        int srcProjectIdex = 1;
        if(resultList.get(0).getMemberUser() == srcOwner) {
            srcProjectIdex = 0;
        }
        srcProjectMember = resultList.get(srcProjectIdex);
        dstProjectMember = resultList.get(1 - srcProjectIdex);

        if(srcProjectMember.getIsOwner() != ProjectOwnerEnum.OWNER.getTag())
            throw new LambdaException("Change project member failed -- transfer party not project owner", "转出方不是项目所有者");

        PrProjectMember updateRecord = new PrProjectMember();
        PrProjectMemberExample example = new PrProjectMemberExample();
        Date dtCurrentTime = SystemTimeUtil.getCurrentTime();

        updateRecord.setIsOwner(ProjectOwnerEnum.NOT_OWNER.getTag());
        updateRecord.setLastUpdateTime(dtCurrentTime);
        updateRecord.setLastUpdateOper(operId);
        example.createCriteria().andProjectIdEqualTo(projectId).andMemberUserEqualTo(srcOwner);
        prProjectMemberMapper.updateByExampleSelective(updateRecord, example);

        updateRecord.clear();
        example.clear();
        updateRecord.setIsOwner(ProjectOwnerEnum.OWNER.getTag());
        updateRecord.setLastUpdateTime(dtCurrentTime);
        updateRecord.setLastUpdateOper(operId);
        example.createCriteria().andProjectIdEqualTo(projectId).andMemberUserEqualTo(dstOwner);
        prProjectMemberMapper.updateByExampleSelective(updateRecord, example);
        return 0;
    }

    /*
     *
     *   查询项目成员（按项目ID, 成员用户）
     *   1.项目所有成员
     *   2.项目下对应成员
     *   返回结果集
     *
     * */
    public List<PrProjectMember> queryProjectMemberByProjectId(Long projectId, List<String> memberUsers) {
        if(DataUtil.isNull(projectId)){
            throw new LambdaException("Query project member failed -- invalid query condition.", "无效查询条件");
        }

        try {
            PrProjectMemberExample example = new  PrProjectMemberExample();
            PrProjectMemberExample.Criteria cond = example.createCriteria().andProjectIdEqualTo(projectId);
            if(DataUtil.isNotEmpty(memberUsers))
                cond.andMemberUserIn(memberUsers);
            cond.andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());

            List<PrProjectMember> resultList = prProjectMemberMapper.selectByExample(example);
            return resultList;
        } catch (Throwable e) {
            throw new LambdaException("Query project info failed.", "查询项目信息失败", e);
        }
    }

    /*
     *
     *   检查项目所有者是否已存在
     *   返回是否已存在
     *
     * */
    public boolean existsProjectOwner(Long projectId, String memberUser)  {
        if(DataUtil.isNull(projectId) || DataUtil.isEmpty(memberUser))
            return false;

        try {
            Long existCount;
            PrProjectMemberExample example = new PrProjectMemberExample();
            example.createCriteria().andProjectIdEqualTo(projectId).andMemberUserEqualTo(memberUser).andStatusEqualTo(DataStatusEnum.NORMAL.getStatus());
            existCount = prProjectMemberMapper.countByExample(example);
            if(existCount > 0)
                return true;

            return false;
        } catch (Throwable e) {
            throw new LambdaException("Check project exists failed.", "检查已存在项目失败", e);
        }
    }
}

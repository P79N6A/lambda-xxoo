package com.yatop.lambda.base.mapper;

import com.yatop.lambda.base.model.WfSnapshot;
import com.yatop.lambda.base.model.WfSnapshotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WfSnapshotMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    long countByExample(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int deleteByExample(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int deleteByPrimaryKey(Long snapshotId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int insert(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int insertSelective(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    List<WfSnapshot> selectByExampleWithBLOBs(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    List<WfSnapshot> selectByExample(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    WfSnapshot selectByPrimaryKey(Long snapshotId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByExample(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByPrimaryKeySelective(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Wed Dec 05 11:19:48 CST 2018
     */
    int updateByPrimaryKey(WfSnapshot record);
}
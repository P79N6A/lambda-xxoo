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
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    long countByExample(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int deleteByExample(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int deleteByPrimaryKey(Long snapshotId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int insert(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int insertSelective(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    List<WfSnapshot> selectByExampleWithBLOBs(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    List<WfSnapshot> selectByExample(WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    WfSnapshot selectByPrimaryKey(Long snapshotId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int updateByExampleSelective(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int updateByExample(@Param("record") WfSnapshot record, @Param("example") WfSnapshotExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int updateByPrimaryKeySelective(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(WfSnapshot record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Sat Jan 19 16:03:29 CST 2019
     */
    int updateByPrimaryKey(WfSnapshot record);
}
package com.yatop.lambda.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfSnapshotExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public WfSnapshotExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSnapshotIdIsNull() {
            addCriterion("SNAPSHOT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdIsNotNull() {
            addCriterion("SNAPSHOT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdEqualTo(Long value) {
            addCriterion("SNAPSHOT_ID =", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotEqualTo(Long value) {
            addCriterion("SNAPSHOT_ID <>", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdGreaterThan(Long value) {
            addCriterion("SNAPSHOT_ID >", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SNAPSHOT_ID >=", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdLessThan(Long value) {
            addCriterion("SNAPSHOT_ID <", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdLessThanOrEqualTo(Long value) {
            addCriterion("SNAPSHOT_ID <=", value, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdIn(List<Long> values) {
            addCriterion("SNAPSHOT_ID in", values, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotIn(List<Long> values) {
            addCriterion("SNAPSHOT_ID not in", values, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdBetween(Long value1, Long value2) {
            addCriterion("SNAPSHOT_ID between", value1, value2, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotIdNotBetween(Long value1, Long value2) {
            addCriterion("SNAPSHOT_ID not between", value1, value2, "snapshotId");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameIsNull() {
            addCriterion("SNAPSHOT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameIsNotNull() {
            addCriterion("SNAPSHOT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameEqualTo(String value) {
            addCriterion("SNAPSHOT_NAME =", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameNotEqualTo(String value) {
            addCriterion("SNAPSHOT_NAME <>", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameGreaterThan(String value) {
            addCriterion("SNAPSHOT_NAME >", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameGreaterThanOrEqualTo(String value) {
            addCriterion("SNAPSHOT_NAME >=", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameLessThan(String value) {
            addCriterion("SNAPSHOT_NAME <", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameLessThanOrEqualTo(String value) {
            addCriterion("SNAPSHOT_NAME <=", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameLike(String value) {
            addCriterion("SNAPSHOT_NAME like", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameNotLike(String value) {
            addCriterion("SNAPSHOT_NAME not like", value, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameIn(List<String> values) {
            addCriterion("SNAPSHOT_NAME in", values, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameNotIn(List<String> values) {
            addCriterion("SNAPSHOT_NAME not in", values, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameBetween(String value1, String value2) {
            addCriterion("SNAPSHOT_NAME between", value1, value2, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameNotBetween(String value1, String value2) {
            addCriterion("SNAPSHOT_NAME not between", value1, value2, "snapshotName");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeIsNull() {
            addCriterion("SNAPSHOT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeIsNotNull() {
            addCriterion("SNAPSHOT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeEqualTo(Integer value) {
            addCriterion("SNAPSHOT_TYPE =", value, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeNotEqualTo(Integer value) {
            addCriterion("SNAPSHOT_TYPE <>", value, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeGreaterThan(Integer value) {
            addCriterion("SNAPSHOT_TYPE >", value, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SNAPSHOT_TYPE >=", value, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeLessThan(Integer value) {
            addCriterion("SNAPSHOT_TYPE <", value, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SNAPSHOT_TYPE <=", value, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeIn(List<Integer> values) {
            addCriterion("SNAPSHOT_TYPE in", values, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeNotIn(List<Integer> values) {
            addCriterion("SNAPSHOT_TYPE not in", values, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeBetween(Integer value1, Integer value2) {
            addCriterion("SNAPSHOT_TYPE between", value1, value2, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andSnapshotTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SNAPSHOT_TYPE not between", value1, value2, "snapshotType");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIsNull() {
            addCriterion("OWNER_PROJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIsNotNull() {
            addCriterion("OWNER_PROJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID =", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID <>", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdGreaterThan(Long value) {
            addCriterion("OWNER_PROJECT_ID >", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID >=", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdLessThan(Long value) {
            addCriterion("OWNER_PROJECT_ID <", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_PROJECT_ID <=", value, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdIn(List<Long> values) {
            addCriterion("OWNER_PROJECT_ID in", values, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotIn(List<Long> values) {
            addCriterion("OWNER_PROJECT_ID not in", values, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_PROJECT_ID between", value1, value2, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_PROJECT_ID not between", value1, value2, "ownerProjectId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdIsNull() {
            addCriterion("OWNER_FLOW_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdIsNotNull() {
            addCriterion("OWNER_FLOW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdEqualTo(Long value) {
            addCriterion("OWNER_FLOW_ID =", value, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdNotEqualTo(Long value) {
            addCriterion("OWNER_FLOW_ID <>", value, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdGreaterThan(Long value) {
            addCriterion("OWNER_FLOW_ID >", value, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_FLOW_ID >=", value, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdLessThan(Long value) {
            addCriterion("OWNER_FLOW_ID <", value, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_FLOW_ID <=", value, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdIn(List<Long> values) {
            addCriterion("OWNER_FLOW_ID in", values, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdNotIn(List<Long> values) {
            addCriterion("OWNER_FLOW_ID not in", values, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_FLOW_ID between", value1, value2, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andOwnerFlowIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_FLOW_ID not between", value1, value2, "ownerFlowId");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionIsNull() {
            addCriterion("SNAPSHOT_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionIsNotNull() {
            addCriterion("SNAPSHOT_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionEqualTo(Long value) {
            addCriterion("SNAPSHOT_VERSION =", value, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionNotEqualTo(Long value) {
            addCriterion("SNAPSHOT_VERSION <>", value, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionGreaterThan(Long value) {
            addCriterion("SNAPSHOT_VERSION >", value, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("SNAPSHOT_VERSION >=", value, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionLessThan(Long value) {
            addCriterion("SNAPSHOT_VERSION <", value, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionLessThanOrEqualTo(Long value) {
            addCriterion("SNAPSHOT_VERSION <=", value, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionIn(List<Long> values) {
            addCriterion("SNAPSHOT_VERSION in", values, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionNotIn(List<Long> values) {
            addCriterion("SNAPSHOT_VERSION not in", values, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionBetween(Long value1, Long value2) {
            addCriterion("SNAPSHOT_VERSION between", value1, value2, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotVersionNotBetween(Long value1, Long value2) {
            addCriterion("SNAPSHOT_VERSION not between", value1, value2, "snapshotVersion");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateIsNull() {
            addCriterion("SNAPSHOT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateIsNotNull() {
            addCriterion("SNAPSHOT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateEqualTo(Integer value) {
            addCriterion("SNAPSHOT_STATE =", value, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateNotEqualTo(Integer value) {
            addCriterion("SNAPSHOT_STATE <>", value, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateGreaterThan(Integer value) {
            addCriterion("SNAPSHOT_STATE >", value, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SNAPSHOT_STATE >=", value, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateLessThan(Integer value) {
            addCriterion("SNAPSHOT_STATE <", value, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateLessThanOrEqualTo(Integer value) {
            addCriterion("SNAPSHOT_STATE <=", value, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateIn(List<Integer> values) {
            addCriterion("SNAPSHOT_STATE in", values, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateNotIn(List<Integer> values) {
            addCriterion("SNAPSHOT_STATE not in", values, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateBetween(Integer value1, Integer value2) {
            addCriterion("SNAPSHOT_STATE between", value1, value2, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andSnapshotStateNotBetween(Integer value1, Integer value2) {
            addCriterion("SNAPSHOT_STATE not between", value1, value2, "snapshotState");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("LAST_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("LAST_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("LAST_UPDATE_TIME >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("LAST_UPDATE_TIME <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperIsNull() {
            addCriterion("LAST_UPDATE_OPER is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperIsNotNull() {
            addCriterion("LAST_UPDATE_OPER is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER =", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER <>", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperGreaterThan(String value) {
            addCriterion("LAST_UPDATE_OPER >", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER >=", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLessThan(String value) {
            addCriterion("LAST_UPDATE_OPER <", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLessThanOrEqualTo(String value) {
            addCriterion("LAST_UPDATE_OPER <=", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLike(String value) {
            addCriterion("LAST_UPDATE_OPER like", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotLike(String value) {
            addCriterion("LAST_UPDATE_OPER not like", value, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperIn(List<String> values) {
            addCriterion("LAST_UPDATE_OPER in", values, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotIn(List<String> values) {
            addCriterion("LAST_UPDATE_OPER not in", values, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_OPER between", value1, value2, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperNotBetween(String value1, String value2) {
            addCriterion("LAST_UPDATE_OPER not between", value1, value2, "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperIsNull() {
            addCriterion("CREATE_OPER is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIsNotNull() {
            addCriterion("CREATE_OPER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperEqualTo(String value) {
            addCriterion("CREATE_OPER =", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotEqualTo(String value) {
            addCriterion("CREATE_OPER <>", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperGreaterThan(String value) {
            addCriterion("CREATE_OPER >", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER >=", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLessThan(String value) {
            addCriterion("CREATE_OPER <", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER <=", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLike(String value) {
            addCriterion("CREATE_OPER like", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotLike(String value) {
            addCriterion("CREATE_OPER not like", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperIn(List<String> values) {
            addCriterion("CREATE_OPER in", values, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotIn(List<String> values) {
            addCriterion("CREATE_OPER not in", values, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperBetween(String value1, String value2) {
            addCriterion("CREATE_OPER between", value1, value2, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotBetween(String value1, String value2) {
            addCriterion("CREATE_OPER not between", value1, value2, "createOper");
            return (Criteria) this;
        }

        public Criteria andSnapshotNameLikeInsensitive(String value) {
            addCriterion("upper(SNAPSHOT_NAME) like", value.toUpperCase(), "snapshotName");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(DESCRIPTION) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andLastUpdateOperLikeInsensitive(String value) {
            addCriterion("upper(LAST_UPDATE_OPER) like", value.toUpperCase(), "lastUpdateOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLikeInsensitive(String value) {
            addCriterion("upper(CREATE_OPER) like", value.toUpperCase(), "createOper");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wf_snapshot
     *
     * @mbg.generated do_not_delete_during_merge Fri Feb 01 23:43:10 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wf_snapshot
     *
     * @mbg.generated Fri Feb 01 23:43:10 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
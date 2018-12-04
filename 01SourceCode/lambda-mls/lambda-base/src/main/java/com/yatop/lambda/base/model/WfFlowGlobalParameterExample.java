package com.yatop.lambda.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfFlowGlobalParameterExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public WfFlowGlobalParameterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
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
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
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

        public Criteria andGlobalParamIdIsNull() {
            addCriterion("GLOBAL_PARAM_ID is null");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdIsNotNull() {
            addCriterion("GLOBAL_PARAM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdEqualTo(Long value) {
            addCriterion("GLOBAL_PARAM_ID =", value, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdNotEqualTo(Long value) {
            addCriterion("GLOBAL_PARAM_ID <>", value, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdGreaterThan(Long value) {
            addCriterion("GLOBAL_PARAM_ID >", value, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("GLOBAL_PARAM_ID >=", value, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdLessThan(Long value) {
            addCriterion("GLOBAL_PARAM_ID <", value, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdLessThanOrEqualTo(Long value) {
            addCriterion("GLOBAL_PARAM_ID <=", value, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdIn(List<Long> values) {
            addCriterion("GLOBAL_PARAM_ID in", values, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdNotIn(List<Long> values) {
            addCriterion("GLOBAL_PARAM_ID not in", values, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdBetween(Long value1, Long value2) {
            addCriterion("GLOBAL_PARAM_ID between", value1, value2, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamIdNotBetween(Long value1, Long value2) {
            addCriterion("GLOBAL_PARAM_ID not between", value1, value2, "globalParamId");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameIsNull() {
            addCriterion("GLOBAL_PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameIsNotNull() {
            addCriterion("GLOBAL_PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameEqualTo(String value) {
            addCriterion("GLOBAL_PARAM_NAME =", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameNotEqualTo(String value) {
            addCriterion("GLOBAL_PARAM_NAME <>", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameGreaterThan(String value) {
            addCriterion("GLOBAL_PARAM_NAME >", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("GLOBAL_PARAM_NAME >=", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameLessThan(String value) {
            addCriterion("GLOBAL_PARAM_NAME <", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameLessThanOrEqualTo(String value) {
            addCriterion("GLOBAL_PARAM_NAME <=", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameLike(String value) {
            addCriterion("GLOBAL_PARAM_NAME like", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameNotLike(String value) {
            addCriterion("GLOBAL_PARAM_NAME not like", value, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameIn(List<String> values) {
            addCriterion("GLOBAL_PARAM_NAME in", values, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameNotIn(List<String> values) {
            addCriterion("GLOBAL_PARAM_NAME not in", values, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameBetween(String value1, String value2) {
            addCriterion("GLOBAL_PARAM_NAME between", value1, value2, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andGlobalParamNameNotBetween(String value1, String value2) {
            addCriterion("GLOBAL_PARAM_NAME not between", value1, value2, "globalParamName");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdIsNull() {
            addCriterion("REL_FLOW_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdIsNotNull() {
            addCriterion("REL_FLOW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdEqualTo(Long value) {
            addCriterion("REL_FLOW_ID =", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdNotEqualTo(Long value) {
            addCriterion("REL_FLOW_ID <>", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdGreaterThan(Long value) {
            addCriterion("REL_FLOW_ID >", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_FLOW_ID >=", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdLessThan(Long value) {
            addCriterion("REL_FLOW_ID <", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_FLOW_ID <=", value, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdIn(List<Long> values) {
            addCriterion("REL_FLOW_ID in", values, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdNotIn(List<Long> values) {
            addCriterion("REL_FLOW_ID not in", values, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdBetween(Long value1, Long value2) {
            addCriterion("REL_FLOW_ID between", value1, value2, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelFlowIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_FLOW_ID not between", value1, value2, "relFlowId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdIsNull() {
            addCriterion("REL_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdIsNotNull() {
            addCriterion("REL_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdEqualTo(Long value) {
            addCriterion("REL_NODE_ID =", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdNotEqualTo(Long value) {
            addCriterion("REL_NODE_ID <>", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdGreaterThan(Long value) {
            addCriterion("REL_NODE_ID >", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_NODE_ID >=", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdLessThan(Long value) {
            addCriterion("REL_NODE_ID <", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_NODE_ID <=", value, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdIn(List<Long> values) {
            addCriterion("REL_NODE_ID in", values, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdNotIn(List<Long> values) {
            addCriterion("REL_NODE_ID not in", values, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdBetween(Long value1, Long value2) {
            addCriterion("REL_NODE_ID between", value1, value2, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelNodeIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_NODE_ID not between", value1, value2, "relNodeId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdIsNull() {
            addCriterion("REL_CHAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelCharIdIsNotNull() {
            addCriterion("REL_CHAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelCharIdEqualTo(Long value) {
            addCriterion("REL_CHAR_ID =", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdNotEqualTo(Long value) {
            addCriterion("REL_CHAR_ID <>", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdGreaterThan(Long value) {
            addCriterion("REL_CHAR_ID >", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_CHAR_ID >=", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdLessThan(Long value) {
            addCriterion("REL_CHAR_ID <", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_CHAR_ID <=", value, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdIn(List<Long> values) {
            addCriterion("REL_CHAR_ID in", values, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdNotIn(List<Long> values) {
            addCriterion("REL_CHAR_ID not in", values, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdBetween(Long value1, Long value2) {
            addCriterion("REL_CHAR_ID between", value1, value2, "relCharId");
            return (Criteria) this;
        }

        public Criteria andRelCharIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_CHAR_ID not between", value1, value2, "relCharId");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("DEFAULT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("DEFAULT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("DEFAULT_VALUE =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("DEFAULT_VALUE <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("DEFAULT_VALUE >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULT_VALUE >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("DEFAULT_VALUE <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("DEFAULT_VALUE <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("DEFAULT_VALUE like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("DEFAULT_VALUE not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("DEFAULT_VALUE in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("DEFAULT_VALUE not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("DEFAULT_VALUE between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("DEFAULT_VALUE not between", value1, value2, "defaultValue");
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

        public Criteria andGlobalParamNameLikeInsensitive(String value) {
            addCriterion("upper(GLOBAL_PARAM_NAME) like", value.toUpperCase(), "globalParamName");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLikeInsensitive(String value) {
            addCriterion("upper(DEFAULT_VALUE) like", value.toUpperCase(), "defaultValue");
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
     * This class corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated do_not_delete_during_merge Wed Dec 05 02:52:56 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wf_flow_global_parameter
     *
     * @mbg.generated Wed Dec 05 02:52:56 CST 2018
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
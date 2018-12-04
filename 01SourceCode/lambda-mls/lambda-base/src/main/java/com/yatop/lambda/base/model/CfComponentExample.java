package com.yatop.lambda.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfComponentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public CfComponentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
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
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
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

        public Criteria andCmptIdIsNull() {
            addCriterion("CMPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCmptIdIsNotNull() {
            addCriterion("CMPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCmptIdEqualTo(String value) {
            addCriterion("CMPT_ID =", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdNotEqualTo(String value) {
            addCriterion("CMPT_ID <>", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdGreaterThan(String value) {
            addCriterion("CMPT_ID >", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdGreaterThanOrEqualTo(String value) {
            addCriterion("CMPT_ID >=", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdLessThan(String value) {
            addCriterion("CMPT_ID <", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdLessThanOrEqualTo(String value) {
            addCriterion("CMPT_ID <=", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdLike(String value) {
            addCriterion("CMPT_ID like", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdNotLike(String value) {
            addCriterion("CMPT_ID not like", value, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdIn(List<String> values) {
            addCriterion("CMPT_ID in", values, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdNotIn(List<String> values) {
            addCriterion("CMPT_ID not in", values, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdBetween(String value1, String value2) {
            addCriterion("CMPT_ID between", value1, value2, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptIdNotBetween(String value1, String value2) {
            addCriterion("CMPT_ID not between", value1, value2, "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptCodeIsNull() {
            addCriterion("CMPT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCmptCodeIsNotNull() {
            addCriterion("CMPT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCmptCodeEqualTo(String value) {
            addCriterion("CMPT_CODE =", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeNotEqualTo(String value) {
            addCriterion("CMPT_CODE <>", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeGreaterThan(String value) {
            addCriterion("CMPT_CODE >", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CMPT_CODE >=", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeLessThan(String value) {
            addCriterion("CMPT_CODE <", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeLessThanOrEqualTo(String value) {
            addCriterion("CMPT_CODE <=", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeLike(String value) {
            addCriterion("CMPT_CODE like", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeNotLike(String value) {
            addCriterion("CMPT_CODE not like", value, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeIn(List<String> values) {
            addCriterion("CMPT_CODE in", values, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeNotIn(List<String> values) {
            addCriterion("CMPT_CODE not in", values, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeBetween(String value1, String value2) {
            addCriterion("CMPT_CODE between", value1, value2, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptCodeNotBetween(String value1, String value2) {
            addCriterion("CMPT_CODE not between", value1, value2, "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptNameIsNull() {
            addCriterion("CMPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCmptNameIsNotNull() {
            addCriterion("CMPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCmptNameEqualTo(String value) {
            addCriterion("CMPT_NAME =", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameNotEqualTo(String value) {
            addCriterion("CMPT_NAME <>", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameGreaterThan(String value) {
            addCriterion("CMPT_NAME >", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameGreaterThanOrEqualTo(String value) {
            addCriterion("CMPT_NAME >=", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameLessThan(String value) {
            addCriterion("CMPT_NAME <", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameLessThanOrEqualTo(String value) {
            addCriterion("CMPT_NAME <=", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameLike(String value) {
            addCriterion("CMPT_NAME like", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameNotLike(String value) {
            addCriterion("CMPT_NAME not like", value, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameIn(List<String> values) {
            addCriterion("CMPT_NAME in", values, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameNotIn(List<String> values) {
            addCriterion("CMPT_NAME not in", values, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameBetween(String value1, String value2) {
            addCriterion("CMPT_NAME between", value1, value2, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptNameNotBetween(String value1, String value2) {
            addCriterion("CMPT_NAME not between", value1, value2, "cmptName");
            return (Criteria) this;
        }

        public Criteria andCmptTypeIsNull() {
            addCriterion("CMPT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCmptTypeIsNotNull() {
            addCriterion("CMPT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCmptTypeEqualTo(Integer value) {
            addCriterion("CMPT_TYPE =", value, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeNotEqualTo(Integer value) {
            addCriterion("CMPT_TYPE <>", value, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeGreaterThan(Integer value) {
            addCriterion("CMPT_TYPE >", value, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CMPT_TYPE >=", value, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeLessThan(Integer value) {
            addCriterion("CMPT_TYPE <", value, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeLessThanOrEqualTo(Integer value) {
            addCriterion("CMPT_TYPE <=", value, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeIn(List<Integer> values) {
            addCriterion("CMPT_TYPE in", values, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeNotIn(List<Integer> values) {
            addCriterion("CMPT_TYPE not in", values, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeBetween(Integer value1, Integer value2) {
            addCriterion("CMPT_TYPE between", value1, value2, "cmptType");
            return (Criteria) this;
        }

        public Criteria andCmptTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CMPT_TYPE not between", value1, value2, "cmptType");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdIsNull() {
            addCriterion("REL_ALGORITHM_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdIsNotNull() {
            addCriterion("REL_ALGORITHM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdEqualTo(Long value) {
            addCriterion("REL_ALGORITHM_ID =", value, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdNotEqualTo(Long value) {
            addCriterion("REL_ALGORITHM_ID <>", value, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdGreaterThan(Long value) {
            addCriterion("REL_ALGORITHM_ID >", value, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_ALGORITHM_ID >=", value, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdLessThan(Long value) {
            addCriterion("REL_ALGORITHM_ID <", value, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_ALGORITHM_ID <=", value, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdIn(List<Long> values) {
            addCriterion("REL_ALGORITHM_ID in", values, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdNotIn(List<Long> values) {
            addCriterion("REL_ALGORITHM_ID not in", values, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdBetween(Long value1, Long value2) {
            addCriterion("REL_ALGORITHM_ID between", value1, value2, "relAlgorithmId");
            return (Criteria) this;
        }

        public Criteria andRelAlgorithmIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_ALGORITHM_ID not between", value1, value2, "relAlgorithmId");
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

        public Criteria andCmptIdLikeInsensitive(String value) {
            addCriterion("upper(CMPT_ID) like", value.toUpperCase(), "cmptId");
            return (Criteria) this;
        }

        public Criteria andCmptCodeLikeInsensitive(String value) {
            addCriterion("upper(CMPT_CODE) like", value.toUpperCase(), "cmptCode");
            return (Criteria) this;
        }

        public Criteria andCmptNameLikeInsensitive(String value) {
            addCriterion("upper(CMPT_NAME) like", value.toUpperCase(), "cmptName");
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
     * This class corresponds to the database table cf_component
     *
     * @mbg.generated do_not_delete_during_merge Tue Dec 04 13:25:54 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cf_component
     *
     * @mbg.generated Tue Dec 04 13:25:54 CST 2018
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
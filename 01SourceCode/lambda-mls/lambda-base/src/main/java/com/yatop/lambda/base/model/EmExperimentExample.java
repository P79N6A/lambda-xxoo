package com.yatop.lambda.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmExperimentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public EmExperimentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
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
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
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

        public Criteria andExperimentIdIsNull() {
            addCriterion("EXPERIMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andExperimentIdIsNotNull() {
            addCriterion("EXPERIMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentIdEqualTo(Long value) {
            addCriterion("EXPERIMENT_ID =", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotEqualTo(Long value) {
            addCriterion("EXPERIMENT_ID <>", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdGreaterThan(Long value) {
            addCriterion("EXPERIMENT_ID >", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("EXPERIMENT_ID >=", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdLessThan(Long value) {
            addCriterion("EXPERIMENT_ID <", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdLessThanOrEqualTo(Long value) {
            addCriterion("EXPERIMENT_ID <=", value, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdIn(List<Long> values) {
            addCriterion("EXPERIMENT_ID in", values, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotIn(List<Long> values) {
            addCriterion("EXPERIMENT_ID not in", values, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdBetween(Long value1, Long value2) {
            addCriterion("EXPERIMENT_ID between", value1, value2, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentIdNotBetween(Long value1, Long value2) {
            addCriterion("EXPERIMENT_ID not between", value1, value2, "experimentId");
            return (Criteria) this;
        }

        public Criteria andExperimentNameIsNull() {
            addCriterion("EXPERIMENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExperimentNameIsNotNull() {
            addCriterion("EXPERIMENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentNameEqualTo(String value) {
            addCriterion("EXPERIMENT_NAME =", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotEqualTo(String value) {
            addCriterion("EXPERIMENT_NAME <>", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameGreaterThan(String value) {
            addCriterion("EXPERIMENT_NAME >", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXPERIMENT_NAME >=", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameLessThan(String value) {
            addCriterion("EXPERIMENT_NAME <", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameLessThanOrEqualTo(String value) {
            addCriterion("EXPERIMENT_NAME <=", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameLike(String value) {
            addCriterion("EXPERIMENT_NAME like", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotLike(String value) {
            addCriterion("EXPERIMENT_NAME not like", value, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameIn(List<String> values) {
            addCriterion("EXPERIMENT_NAME in", values, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotIn(List<String> values) {
            addCriterion("EXPERIMENT_NAME not in", values, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameBetween(String value1, String value2) {
            addCriterion("EXPERIMENT_NAME between", value1, value2, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentNameNotBetween(String value1, String value2) {
            addCriterion("EXPERIMENT_NAME not between", value1, value2, "experimentName");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeIsNull() {
            addCriterion("EXPERIMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeIsNotNull() {
            addCriterion("EXPERIMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeEqualTo(Integer value) {
            addCriterion("EXPERIMENT_TYPE =", value, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeNotEqualTo(Integer value) {
            addCriterion("EXPERIMENT_TYPE <>", value, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeGreaterThan(Integer value) {
            addCriterion("EXPERIMENT_TYPE >", value, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPERIMENT_TYPE >=", value, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeLessThan(Integer value) {
            addCriterion("EXPERIMENT_TYPE <", value, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("EXPERIMENT_TYPE <=", value, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeIn(List<Integer> values) {
            addCriterion("EXPERIMENT_TYPE in", values, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeNotIn(List<Integer> values) {
            addCriterion("EXPERIMENT_TYPE not in", values, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeBetween(Integer value1, Integer value2) {
            addCriterion("EXPERIMENT_TYPE between", value1, value2, "experimentType");
            return (Criteria) this;
        }

        public Criteria andExperimentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPERIMENT_TYPE not between", value1, value2, "experimentType");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdIsNull() {
            addCriterion("MAIN_EXPERIMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdIsNotNull() {
            addCriterion("MAIN_EXPERIMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdEqualTo(Long value) {
            addCriterion("MAIN_EXPERIMENT_ID =", value, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdNotEqualTo(Long value) {
            addCriterion("MAIN_EXPERIMENT_ID <>", value, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdGreaterThan(Long value) {
            addCriterion("MAIN_EXPERIMENT_ID >", value, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MAIN_EXPERIMENT_ID >=", value, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdLessThan(Long value) {
            addCriterion("MAIN_EXPERIMENT_ID <", value, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdLessThanOrEqualTo(Long value) {
            addCriterion("MAIN_EXPERIMENT_ID <=", value, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdIn(List<Long> values) {
            addCriterion("MAIN_EXPERIMENT_ID in", values, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdNotIn(List<Long> values) {
            addCriterion("MAIN_EXPERIMENT_ID not in", values, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdBetween(Long value1, Long value2) {
            addCriterion("MAIN_EXPERIMENT_ID between", value1, value2, "mainExperimentId");
            return (Criteria) this;
        }

        public Criteria andMainExperimentIdNotBetween(Long value1, Long value2) {
            addCriterion("MAIN_EXPERIMENT_ID not between", value1, value2, "mainExperimentId");
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

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
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

        public Criteria andExperimentNameLikeInsensitive(String value) {
            addCriterion("upper(EXPERIMENT_NAME) like", value.toUpperCase(), "experimentName");
            return (Criteria) this;
        }

        public Criteria andSummaryLikeInsensitive(String value) {
            addCriterion("upper(SUMMARY) like", value.toUpperCase(), "summary");
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
     * This class corresponds to the database table em_experiment
     *
     * @mbg.generated do_not_delete_during_merge Sun Jan 06 01:14:12 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table em_experiment
     *
     * @mbg.generated Sun Jan 06 01:14:12 CST 2019
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
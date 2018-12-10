package com.yatop.lambda.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfCmptCharTypeWildExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public CfCmptCharTypeWildExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
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
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
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

        public Criteria andWildCharTypeIdIsNull() {
            addCriterion("WILD_CHAR_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdIsNotNull() {
            addCriterion("WILD_CHAR_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdEqualTo(Integer value) {
            addCriterion("WILD_CHAR_TYPE_ID =", value, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdNotEqualTo(Integer value) {
            addCriterion("WILD_CHAR_TYPE_ID <>", value, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdGreaterThan(Integer value) {
            addCriterion("WILD_CHAR_TYPE_ID >", value, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WILD_CHAR_TYPE_ID >=", value, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdLessThan(Integer value) {
            addCriterion("WILD_CHAR_TYPE_ID <", value, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("WILD_CHAR_TYPE_ID <=", value, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdIn(List<Integer> values) {
            addCriterion("WILD_CHAR_TYPE_ID in", values, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdNotIn(List<Integer> values) {
            addCriterion("WILD_CHAR_TYPE_ID not in", values, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("WILD_CHAR_TYPE_ID between", value1, value2, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andWildCharTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WILD_CHAR_TYPE_ID not between", value1, value2, "wildCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdIsNull() {
            addCriterion("UNIT_CHAR_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdIsNotNull() {
            addCriterion("UNIT_CHAR_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdEqualTo(Integer value) {
            addCriterion("UNIT_CHAR_TYPE_ID =", value, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdNotEqualTo(Integer value) {
            addCriterion("UNIT_CHAR_TYPE_ID <>", value, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdGreaterThan(Integer value) {
            addCriterion("UNIT_CHAR_TYPE_ID >", value, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNIT_CHAR_TYPE_ID >=", value, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdLessThan(Integer value) {
            addCriterion("UNIT_CHAR_TYPE_ID <", value, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("UNIT_CHAR_TYPE_ID <=", value, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdIn(List<Integer> values) {
            addCriterion("UNIT_CHAR_TYPE_ID in", values, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdNotIn(List<Integer> values) {
            addCriterion("UNIT_CHAR_TYPE_ID not in", values, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_CHAR_TYPE_ID between", value1, value2, "unitCharTypeId");
            return (Criteria) this;
        }

        public Criteria andUnitCharTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_CHAR_TYPE_ID not between", value1, value2, "unitCharTypeId");
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
     * This class corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 10 12:31:47 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cf_cmpt_char_type_wild
     *
     * @mbg.generated Mon Dec 10 12:31:47 CST 2018
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
package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfCmptCharExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CfCmptCharExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

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

        public Criteria andCharIdIsNull() {
            addCriterion("CHAR_ID is null");
            return (Criteria) this;
        }

        public Criteria andCharIdIsNotNull() {
            addCriterion("CHAR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCharIdEqualTo(String value) {
            addCriterion("CHAR_ID =", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdNotEqualTo(String value) {
            addCriterion("CHAR_ID <>", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdGreaterThan(String value) {
            addCriterion("CHAR_ID >", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHAR_ID >=", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdLessThan(String value) {
            addCriterion("CHAR_ID <", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdLessThanOrEqualTo(String value) {
            addCriterion("CHAR_ID <=", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdLike(String value) {
            addCriterion("CHAR_ID like", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdNotLike(String value) {
            addCriterion("CHAR_ID not like", value, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdIn(List<String> values) {
            addCriterion("CHAR_ID in", values, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdNotIn(List<String> values) {
            addCriterion("CHAR_ID not in", values, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdBetween(String value1, String value2) {
            addCriterion("CHAR_ID between", value1, value2, "charId");
            return (Criteria) this;
        }

        public Criteria andCharIdNotBetween(String value1, String value2) {
            addCriterion("CHAR_ID not between", value1, value2, "charId");
            return (Criteria) this;
        }

        public Criteria andCharCodeIsNull() {
            addCriterion("CHAR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCharCodeIsNotNull() {
            addCriterion("CHAR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCharCodeEqualTo(String value) {
            addCriterion("CHAR_CODE =", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeNotEqualTo(String value) {
            addCriterion("CHAR_CODE <>", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeGreaterThan(String value) {
            addCriterion("CHAR_CODE >", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHAR_CODE >=", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeLessThan(String value) {
            addCriterion("CHAR_CODE <", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeLessThanOrEqualTo(String value) {
            addCriterion("CHAR_CODE <=", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeLike(String value) {
            addCriterion("CHAR_CODE like", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeNotLike(String value) {
            addCriterion("CHAR_CODE not like", value, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeIn(List<String> values) {
            addCriterion("CHAR_CODE in", values, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeNotIn(List<String> values) {
            addCriterion("CHAR_CODE not in", values, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeBetween(String value1, String value2) {
            addCriterion("CHAR_CODE between", value1, value2, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharCodeNotBetween(String value1, String value2) {
            addCriterion("CHAR_CODE not between", value1, value2, "charCode");
            return (Criteria) this;
        }

        public Criteria andCharNameIsNull() {
            addCriterion("CHAR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCharNameIsNotNull() {
            addCriterion("CHAR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCharNameEqualTo(String value) {
            addCriterion("CHAR_NAME =", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameNotEqualTo(String value) {
            addCriterion("CHAR_NAME <>", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameGreaterThan(String value) {
            addCriterion("CHAR_NAME >", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHAR_NAME >=", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameLessThan(String value) {
            addCriterion("CHAR_NAME <", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameLessThanOrEqualTo(String value) {
            addCriterion("CHAR_NAME <=", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameLike(String value) {
            addCriterion("CHAR_NAME like", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameNotLike(String value) {
            addCriterion("CHAR_NAME not like", value, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameIn(List<String> values) {
            addCriterion("CHAR_NAME in", values, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameNotIn(List<String> values) {
            addCriterion("CHAR_NAME not in", values, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameBetween(String value1, String value2) {
            addCriterion("CHAR_NAME between", value1, value2, "charName");
            return (Criteria) this;
        }

        public Criteria andCharNameNotBetween(String value1, String value2) {
            addCriterion("CHAR_NAME not between", value1, value2, "charName");
            return (Criteria) this;
        }

        public Criteria andCharAliasIsNull() {
            addCriterion("CHAR_ALIAS is null");
            return (Criteria) this;
        }

        public Criteria andCharAliasIsNotNull() {
            addCriterion("CHAR_ALIAS is not null");
            return (Criteria) this;
        }

        public Criteria andCharAliasEqualTo(String value) {
            addCriterion("CHAR_ALIAS =", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasNotEqualTo(String value) {
            addCriterion("CHAR_ALIAS <>", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasGreaterThan(String value) {
            addCriterion("CHAR_ALIAS >", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasGreaterThanOrEqualTo(String value) {
            addCriterion("CHAR_ALIAS >=", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasLessThan(String value) {
            addCriterion("CHAR_ALIAS <", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasLessThanOrEqualTo(String value) {
            addCriterion("CHAR_ALIAS <=", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasLike(String value) {
            addCriterion("CHAR_ALIAS like", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasNotLike(String value) {
            addCriterion("CHAR_ALIAS not like", value, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasIn(List<String> values) {
            addCriterion("CHAR_ALIAS in", values, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasNotIn(List<String> values) {
            addCriterion("CHAR_ALIAS not in", values, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasBetween(String value1, String value2) {
            addCriterion("CHAR_ALIAS between", value1, value2, "charAlias");
            return (Criteria) this;
        }

        public Criteria andCharAliasNotBetween(String value1, String value2) {
            addCriterion("CHAR_ALIAS not between", value1, value2, "charAlias");
            return (Criteria) this;
        }

        public Criteria andSpecTypeIsNull() {
            addCriterion("SPEC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSpecTypeIsNotNull() {
            addCriterion("SPEC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSpecTypeEqualTo(Integer value) {
            addCriterion("SPEC_TYPE =", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeNotEqualTo(Integer value) {
            addCriterion("SPEC_TYPE <>", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeGreaterThan(Integer value) {
            addCriterion("SPEC_TYPE >", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SPEC_TYPE >=", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeLessThan(Integer value) {
            addCriterion("SPEC_TYPE <", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SPEC_TYPE <=", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeIn(List<Integer> values) {
            addCriterion("SPEC_TYPE in", values, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeNotIn(List<Integer> values) {
            addCriterion("SPEC_TYPE not in", values, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeBetween(Integer value1, Integer value2) {
            addCriterion("SPEC_TYPE between", value1, value2, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SPEC_TYPE not between", value1, value2, "specType");
            return (Criteria) this;
        }

        public Criteria andCharTypeIsNull() {
            addCriterion("CHAR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCharTypeIsNotNull() {
            addCriterion("CHAR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCharTypeEqualTo(Integer value) {
            addCriterion("CHAR_TYPE =", value, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeNotEqualTo(Integer value) {
            addCriterion("CHAR_TYPE <>", value, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeGreaterThan(Integer value) {
            addCriterion("CHAR_TYPE >", value, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHAR_TYPE >=", value, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeLessThan(Integer value) {
            addCriterion("CHAR_TYPE <", value, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeLessThanOrEqualTo(Integer value) {
            addCriterion("CHAR_TYPE <=", value, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeIn(List<Integer> values) {
            addCriterion("CHAR_TYPE in", values, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeNotIn(List<Integer> values) {
            addCriterion("CHAR_TYPE not in", values, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeBetween(Integer value1, Integer value2) {
            addCriterion("CHAR_TYPE between", value1, value2, "charType");
            return (Criteria) this;
        }

        public Criteria andCharTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CHAR_TYPE not between", value1, value2, "charType");
            return (Criteria) this;
        }

        public Criteria andValueSrcIsNull() {
            addCriterion("VALUE_SRC is null");
            return (Criteria) this;
        }

        public Criteria andValueSrcIsNotNull() {
            addCriterion("VALUE_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andValueSrcEqualTo(Integer value) {
            addCriterion("VALUE_SRC =", value, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcNotEqualTo(Integer value) {
            addCriterion("VALUE_SRC <>", value, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcGreaterThan(Integer value) {
            addCriterion("VALUE_SRC >", value, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcGreaterThanOrEqualTo(Integer value) {
            addCriterion("VALUE_SRC >=", value, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcLessThan(Integer value) {
            addCriterion("VALUE_SRC <", value, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcLessThanOrEqualTo(Integer value) {
            addCriterion("VALUE_SRC <=", value, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcIn(List<Integer> values) {
            addCriterion("VALUE_SRC in", values, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcNotIn(List<Integer> values) {
            addCriterion("VALUE_SRC not in", values, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcBetween(Integer value1, Integer value2) {
            addCriterion("VALUE_SRC between", value1, value2, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andValueSrcNotBetween(Integer value1, Integer value2) {
            addCriterion("VALUE_SRC not between", value1, value2, "valueSrc");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalIsNull() {
            addCriterion("ALLOW_GLOBAL is null");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalIsNotNull() {
            addCriterion("ALLOW_GLOBAL is not null");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalEqualTo(Integer value) {
            addCriterion("ALLOW_GLOBAL =", value, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalNotEqualTo(Integer value) {
            addCriterion("ALLOW_GLOBAL <>", value, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalGreaterThan(Integer value) {
            addCriterion("ALLOW_GLOBAL >", value, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALLOW_GLOBAL >=", value, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalLessThan(Integer value) {
            addCriterion("ALLOW_GLOBAL <", value, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalLessThanOrEqualTo(Integer value) {
            addCriterion("ALLOW_GLOBAL <=", value, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalIn(List<Integer> values) {
            addCriterion("ALLOW_GLOBAL in", values, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalNotIn(List<Integer> values) {
            addCriterion("ALLOW_GLOBAL not in", values, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalBetween(Integer value1, Integer value2) {
            addCriterion("ALLOW_GLOBAL between", value1, value2, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andAllowGlobalNotBetween(Integer value1, Integer value2) {
            addCriterion("ALLOW_GLOBAL not between", value1, value2, "allowGlobal");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNull() {
            addCriterion("IS_REQUIRED is null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNotNull() {
            addCriterion("IS_REQUIRED is not null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredEqualTo(Integer value) {
            addCriterion("IS_REQUIRED =", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotEqualTo(Integer value) {
            addCriterion("IS_REQUIRED <>", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThan(Integer value) {
            addCriterion("IS_REQUIRED >", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_REQUIRED >=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThan(Integer value) {
            addCriterion("IS_REQUIRED <", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThanOrEqualTo(Integer value) {
            addCriterion("IS_REQUIRED <=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIn(List<Integer> values) {
            addCriterion("IS_REQUIRED in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotIn(List<Integer> values) {
            addCriterion("IS_REQUIRED not in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredBetween(Integer value1, Integer value2) {
            addCriterion("IS_REQUIRED between", value1, value2, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_REQUIRED not between", value1, value2, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsLimitedIsNull() {
            addCriterion("IS_LIMITED is null");
            return (Criteria) this;
        }

        public Criteria andIsLimitedIsNotNull() {
            addCriterion("IS_LIMITED is not null");
            return (Criteria) this;
        }

        public Criteria andIsLimitedEqualTo(Integer value) {
            addCriterion("IS_LIMITED =", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedNotEqualTo(Integer value) {
            addCriterion("IS_LIMITED <>", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedGreaterThan(Integer value) {
            addCriterion("IS_LIMITED >", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_LIMITED >=", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedLessThan(Integer value) {
            addCriterion("IS_LIMITED <", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedLessThanOrEqualTo(Integer value) {
            addCriterion("IS_LIMITED <=", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedIn(List<Integer> values) {
            addCriterion("IS_LIMITED in", values, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedNotIn(List<Integer> values) {
            addCriterion("IS_LIMITED not in", values, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedBetween(Integer value1, Integer value2) {
            addCriterion("IS_LIMITED between", value1, value2, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_LIMITED not between", value1, value2, "isLimited");
            return (Criteria) this;
        }

        public Criteria andStepSizeIsNull() {
            addCriterion("STEP_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andStepSizeIsNotNull() {
            addCriterion("STEP_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andStepSizeEqualTo(String value) {
            addCriterion("STEP_SIZE =", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeNotEqualTo(String value) {
            addCriterion("STEP_SIZE <>", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeGreaterThan(String value) {
            addCriterion("STEP_SIZE >", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_SIZE >=", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeLessThan(String value) {
            addCriterion("STEP_SIZE <", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeLessThanOrEqualTo(String value) {
            addCriterion("STEP_SIZE <=", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeLike(String value) {
            addCriterion("STEP_SIZE like", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeNotLike(String value) {
            addCriterion("STEP_SIZE not like", value, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeIn(List<String> values) {
            addCriterion("STEP_SIZE in", values, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeNotIn(List<String> values) {
            addCriterion("STEP_SIZE not in", values, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeBetween(String value1, String value2) {
            addCriterion("STEP_SIZE between", value1, value2, "stepSize");
            return (Criteria) this;
        }

        public Criteria andStepSizeNotBetween(String value1, String value2) {
            addCriterion("STEP_SIZE not between", value1, value2, "stepSize");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNull() {
            addCriterion("MIN_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNotNull() {
            addCriterion("MIN_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andMinValueEqualTo(String value) {
            addCriterion("MIN_VALUE =", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotEqualTo(String value) {
            addCriterion("MIN_VALUE <>", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThan(String value) {
            addCriterion("MIN_VALUE >", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThanOrEqualTo(String value) {
            addCriterion("MIN_VALUE >=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThan(String value) {
            addCriterion("MIN_VALUE <", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThanOrEqualTo(String value) {
            addCriterion("MIN_VALUE <=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLike(String value) {
            addCriterion("MIN_VALUE like", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotLike(String value) {
            addCriterion("MIN_VALUE not like", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueIn(List<String> values) {
            addCriterion("MIN_VALUE in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotIn(List<String> values) {
            addCriterion("MIN_VALUE not in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueBetween(String value1, String value2) {
            addCriterion("MIN_VALUE between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotBetween(String value1, String value2) {
            addCriterion("MIN_VALUE not between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNull() {
            addCriterion("MAX_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNotNull() {
            addCriterion("MAX_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxValueEqualTo(String value) {
            addCriterion("MAX_VALUE =", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotEqualTo(String value) {
            addCriterion("MAX_VALUE <>", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThan(String value) {
            addCriterion("MAX_VALUE >", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_VALUE >=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThan(String value) {
            addCriterion("MAX_VALUE <", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThanOrEqualTo(String value) {
            addCriterion("MAX_VALUE <=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLike(String value) {
            addCriterion("MAX_VALUE like", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotLike(String value) {
            addCriterion("MAX_VALUE not like", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIn(List<String> values) {
            addCriterion("MAX_VALUE in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotIn(List<String> values) {
            addCriterion("MAX_VALUE not in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueBetween(String value1, String value2) {
            addCriterion("MAX_VALUE between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotBetween(String value1, String value2) {
            addCriterion("MAX_VALUE not between", value1, value2, "maxValue");
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

        public Criteria andCharIdLikeInsensitive(String value) {
            addCriterion("upper(CHAR_ID) like", value.toUpperCase(), "charId");
            return (Criteria) this;
        }

        public Criteria andCharCodeLikeInsensitive(String value) {
            addCriterion("upper(CHAR_CODE) like", value.toUpperCase(), "charCode");
            return (Criteria) this;
        }

        public Criteria andCharNameLikeInsensitive(String value) {
            addCriterion("upper(CHAR_NAME) like", value.toUpperCase(), "charName");
            return (Criteria) this;
        }

        public Criteria andCharAliasLikeInsensitive(String value) {
            addCriterion("upper(CHAR_ALIAS) like", value.toUpperCase(), "charAlias");
            return (Criteria) this;
        }

        public Criteria andStepSizeLikeInsensitive(String value) {
            addCriterion("upper(STEP_SIZE) like", value.toUpperCase(), "stepSize");
            return (Criteria) this;
        }

        public Criteria andMinValueLikeInsensitive(String value) {
            addCriterion("upper(MIN_VALUE) like", value.toUpperCase(), "minValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLikeInsensitive(String value) {
            addCriterion("upper(MAX_VALUE) like", value.toUpperCase(), "maxValue");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
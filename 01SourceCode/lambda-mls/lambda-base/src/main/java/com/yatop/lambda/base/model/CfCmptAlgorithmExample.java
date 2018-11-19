package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfCmptAlgorithmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CfCmptAlgorithmExample() {
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

        public Criteria andAlgorithmIdIsNull() {
            addCriterion("ALGORITHM_ID is null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdIsNotNull() {
            addCriterion("ALGORITHM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdEqualTo(Long value) {
            addCriterion("ALGORITHM_ID =", value, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdNotEqualTo(Long value) {
            addCriterion("ALGORITHM_ID <>", value, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdGreaterThan(Long value) {
            addCriterion("ALGORITHM_ID >", value, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ALGORITHM_ID >=", value, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdLessThan(Long value) {
            addCriterion("ALGORITHM_ID <", value, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdLessThanOrEqualTo(Long value) {
            addCriterion("ALGORITHM_ID <=", value, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdIn(List<Long> values) {
            addCriterion("ALGORITHM_ID in", values, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdNotIn(List<Long> values) {
            addCriterion("ALGORITHM_ID not in", values, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdBetween(Long value1, Long value2) {
            addCriterion("ALGORITHM_ID between", value1, value2, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmIdNotBetween(Long value1, Long value2) {
            addCriterion("ALGORITHM_ID not between", value1, value2, "algorithmId");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeIsNull() {
            addCriterion("ALGORITHM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeIsNotNull() {
            addCriterion("ALGORITHM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeEqualTo(String value) {
            addCriterion("ALGORITHM_CODE =", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotEqualTo(String value) {
            addCriterion("ALGORITHM_CODE <>", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeGreaterThan(String value) {
            addCriterion("ALGORITHM_CODE >", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ALGORITHM_CODE >=", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeLessThan(String value) {
            addCriterion("ALGORITHM_CODE <", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeLessThanOrEqualTo(String value) {
            addCriterion("ALGORITHM_CODE <=", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeLike(String value) {
            addCriterion("ALGORITHM_CODE like", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotLike(String value) {
            addCriterion("ALGORITHM_CODE not like", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeIn(List<String> values) {
            addCriterion("ALGORITHM_CODE in", values, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotIn(List<String> values) {
            addCriterion("ALGORITHM_CODE not in", values, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeBetween(String value1, String value2) {
            addCriterion("ALGORITHM_CODE between", value1, value2, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotBetween(String value1, String value2) {
            addCriterion("ALGORITHM_CODE not between", value1, value2, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameIsNull() {
            addCriterion("ALGORITHM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameIsNotNull() {
            addCriterion("ALGORITHM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameEqualTo(String value) {
            addCriterion("ALGORITHM_NAME =", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameNotEqualTo(String value) {
            addCriterion("ALGORITHM_NAME <>", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameGreaterThan(String value) {
            addCriterion("ALGORITHM_NAME >", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameGreaterThanOrEqualTo(String value) {
            addCriterion("ALGORITHM_NAME >=", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameLessThan(String value) {
            addCriterion("ALGORITHM_NAME <", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameLessThanOrEqualTo(String value) {
            addCriterion("ALGORITHM_NAME <=", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameLike(String value) {
            addCriterion("ALGORITHM_NAME like", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameNotLike(String value) {
            addCriterion("ALGORITHM_NAME not like", value, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameIn(List<String> values) {
            addCriterion("ALGORITHM_NAME in", values, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameNotIn(List<String> values) {
            addCriterion("ALGORITHM_NAME not in", values, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameBetween(String value1, String value2) {
            addCriterion("ALGORITHM_NAME between", value1, value2, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameNotBetween(String value1, String value2) {
            addCriterion("ALGORITHM_NAME not between", value1, value2, "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeIsNull() {
            addCriterion("ALGORITHM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeIsNotNull() {
            addCriterion("ALGORITHM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeEqualTo(Integer value) {
            addCriterion("ALGORITHM_TYPE =", value, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeNotEqualTo(Integer value) {
            addCriterion("ALGORITHM_TYPE <>", value, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeGreaterThan(Integer value) {
            addCriterion("ALGORITHM_TYPE >", value, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALGORITHM_TYPE >=", value, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeLessThan(Integer value) {
            addCriterion("ALGORITHM_TYPE <", value, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ALGORITHM_TYPE <=", value, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeIn(List<Integer> values) {
            addCriterion("ALGORITHM_TYPE in", values, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeNotIn(List<Integer> values) {
            addCriterion("ALGORITHM_TYPE not in", values, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeBetween(Integer value1, Integer value2) {
            addCriterion("ALGORITHM_TYPE between", value1, value2, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ALGORITHM_TYPE not between", value1, value2, "algorithmType");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsIsNull() {
            addCriterion("ALGORITHM_LABELS is null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsIsNotNull() {
            addCriterion("ALGORITHM_LABELS is not null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsEqualTo(String value) {
            addCriterion("ALGORITHM_LABELS =", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsNotEqualTo(String value) {
            addCriterion("ALGORITHM_LABELS <>", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsGreaterThan(String value) {
            addCriterion("ALGORITHM_LABELS >", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsGreaterThanOrEqualTo(String value) {
            addCriterion("ALGORITHM_LABELS >=", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsLessThan(String value) {
            addCriterion("ALGORITHM_LABELS <", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsLessThanOrEqualTo(String value) {
            addCriterion("ALGORITHM_LABELS <=", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsLike(String value) {
            addCriterion("ALGORITHM_LABELS like", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsNotLike(String value) {
            addCriterion("ALGORITHM_LABELS not like", value, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsIn(List<String> values) {
            addCriterion("ALGORITHM_LABELS in", values, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsNotIn(List<String> values) {
            addCriterion("ALGORITHM_LABELS not in", values, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsBetween(String value1, String value2) {
            addCriterion("ALGORITHM_LABELS between", value1, value2, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsNotBetween(String value1, String value2) {
            addCriterion("ALGORITHM_LABELS not between", value1, value2, "algorithmLabels");
            return (Criteria) this;
        }

        public Criteria andLearningModeIsNull() {
            addCriterion("LEARNING_MODE is null");
            return (Criteria) this;
        }

        public Criteria andLearningModeIsNotNull() {
            addCriterion("LEARNING_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andLearningModeEqualTo(Integer value) {
            addCriterion("LEARNING_MODE =", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeNotEqualTo(Integer value) {
            addCriterion("LEARNING_MODE <>", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeGreaterThan(Integer value) {
            addCriterion("LEARNING_MODE >", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LEARNING_MODE >=", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeLessThan(Integer value) {
            addCriterion("LEARNING_MODE <", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeLessThanOrEqualTo(Integer value) {
            addCriterion("LEARNING_MODE <=", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeIn(List<Integer> values) {
            addCriterion("LEARNING_MODE in", values, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeNotIn(List<Integer> values) {
            addCriterion("LEARNING_MODE not in", values, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeBetween(Integer value1, Integer value2) {
            addCriterion("LEARNING_MODE between", value1, value2, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeNotBetween(Integer value1, Integer value2) {
            addCriterion("LEARNING_MODE not between", value1, value2, "learningMode");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodIsNull() {
            addCriterion("OPTIMIZE_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodIsNotNull() {
            addCriterion("OPTIMIZE_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodEqualTo(Integer value) {
            addCriterion("OPTIMIZE_METHOD =", value, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodNotEqualTo(Integer value) {
            addCriterion("OPTIMIZE_METHOD <>", value, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodGreaterThan(Integer value) {
            addCriterion("OPTIMIZE_METHOD >", value, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPTIMIZE_METHOD >=", value, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodLessThan(Integer value) {
            addCriterion("OPTIMIZE_METHOD <", value, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodLessThanOrEqualTo(Integer value) {
            addCriterion("OPTIMIZE_METHOD <=", value, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodIn(List<Integer> values) {
            addCriterion("OPTIMIZE_METHOD in", values, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodNotIn(List<Integer> values) {
            addCriterion("OPTIMIZE_METHOD not in", values, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodBetween(Integer value1, Integer value2) {
            addCriterion("OPTIMIZE_METHOD between", value1, value2, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andOptimizeMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("OPTIMIZE_METHOD not between", value1, value2, "optimizeMethod");
            return (Criteria) this;
        }

        public Criteria andIsTunableIsNull() {
            addCriterion("IS_TUNABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsTunableIsNotNull() {
            addCriterion("IS_TUNABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsTunableEqualTo(Integer value) {
            addCriterion("IS_TUNABLE =", value, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableNotEqualTo(Integer value) {
            addCriterion("IS_TUNABLE <>", value, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableGreaterThan(Integer value) {
            addCriterion("IS_TUNABLE >", value, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_TUNABLE >=", value, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableLessThan(Integer value) {
            addCriterion("IS_TUNABLE <", value, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableLessThanOrEqualTo(Integer value) {
            addCriterion("IS_TUNABLE <=", value, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableIn(List<Integer> values) {
            addCriterion("IS_TUNABLE in", values, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableNotIn(List<Integer> values) {
            addCriterion("IS_TUNABLE not in", values, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableBetween(Integer value1, Integer value2) {
            addCriterion("IS_TUNABLE between", value1, value2, "isTunable");
            return (Criteria) this;
        }

        public Criteria andIsTunableNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_TUNABLE not between", value1, value2, "isTunable");
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

        public Criteria andAlgorithmCodeLikeInsensitive(String value) {
            addCriterion("upper(ALGORITHM_CODE) like", value.toUpperCase(), "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmNameLikeInsensitive(String value) {
            addCriterion("upper(ALGORITHM_NAME) like", value.toUpperCase(), "algorithmName");
            return (Criteria) this;
        }

        public Criteria andAlgorithmLabelsLikeInsensitive(String value) {
            addCriterion("upper(ALGORITHM_LABELS) like", value.toUpperCase(), "algorithmLabels");
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
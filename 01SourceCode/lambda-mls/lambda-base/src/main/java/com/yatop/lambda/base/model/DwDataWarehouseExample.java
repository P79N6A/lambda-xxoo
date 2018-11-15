package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DwDataWarehouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DwDataWarehouseExample() {
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

        public Criteria andDwIdIsNull() {
            addCriterion("DW_ID is null");
            return (Criteria) this;
        }

        public Criteria andDwIdIsNotNull() {
            addCriterion("DW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDwIdEqualTo(Long value) {
            addCriterion("DW_ID =", value, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdNotEqualTo(Long value) {
            addCriterion("DW_ID <>", value, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdGreaterThan(Long value) {
            addCriterion("DW_ID >", value, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DW_ID >=", value, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdLessThan(Long value) {
            addCriterion("DW_ID <", value, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdLessThanOrEqualTo(Long value) {
            addCriterion("DW_ID <=", value, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdIn(List<Long> values) {
            addCriterion("DW_ID in", values, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdNotIn(List<Long> values) {
            addCriterion("DW_ID not in", values, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdBetween(Long value1, Long value2) {
            addCriterion("DW_ID between", value1, value2, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwIdNotBetween(Long value1, Long value2) {
            addCriterion("DW_ID not between", value1, value2, "dwId");
            return (Criteria) this;
        }

        public Criteria andDwCodeIsNull() {
            addCriterion("DW_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDwCodeIsNotNull() {
            addCriterion("DW_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDwCodeEqualTo(String value) {
            addCriterion("DW_CODE =", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeNotEqualTo(String value) {
            addCriterion("DW_CODE <>", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeGreaterThan(String value) {
            addCriterion("DW_CODE >", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DW_CODE >=", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeLessThan(String value) {
            addCriterion("DW_CODE <", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeLessThanOrEqualTo(String value) {
            addCriterion("DW_CODE <=", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeLike(String value) {
            addCriterion("DW_CODE like", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeNotLike(String value) {
            addCriterion("DW_CODE not like", value, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeIn(List<String> values) {
            addCriterion("DW_CODE in", values, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeNotIn(List<String> values) {
            addCriterion("DW_CODE not in", values, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeBetween(String value1, String value2) {
            addCriterion("DW_CODE between", value1, value2, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwCodeNotBetween(String value1, String value2) {
            addCriterion("DW_CODE not between", value1, value2, "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwNameIsNull() {
            addCriterion("DW_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDwNameIsNotNull() {
            addCriterion("DW_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDwNameEqualTo(String value) {
            addCriterion("DW_NAME =", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameNotEqualTo(String value) {
            addCriterion("DW_NAME <>", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameGreaterThan(String value) {
            addCriterion("DW_NAME >", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameGreaterThanOrEqualTo(String value) {
            addCriterion("DW_NAME >=", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameLessThan(String value) {
            addCriterion("DW_NAME <", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameLessThanOrEqualTo(String value) {
            addCriterion("DW_NAME <=", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameLike(String value) {
            addCriterion("DW_NAME like", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameNotLike(String value) {
            addCriterion("DW_NAME not like", value, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameIn(List<String> values) {
            addCriterion("DW_NAME in", values, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameNotIn(List<String> values) {
            addCriterion("DW_NAME not in", values, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameBetween(String value1, String value2) {
            addCriterion("DW_NAME between", value1, value2, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwNameNotBetween(String value1, String value2) {
            addCriterion("DW_NAME not between", value1, value2, "dwName");
            return (Criteria) this;
        }

        public Criteria andDwTypeIsNull() {
            addCriterion("DW_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDwTypeIsNotNull() {
            addCriterion("DW_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDwTypeEqualTo(Integer value) {
            addCriterion("DW_TYPE =", value, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeNotEqualTo(Integer value) {
            addCriterion("DW_TYPE <>", value, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeGreaterThan(Integer value) {
            addCriterion("DW_TYPE >", value, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DW_TYPE >=", value, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeLessThan(Integer value) {
            addCriterion("DW_TYPE <", value, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeLessThanOrEqualTo(Integer value) {
            addCriterion("DW_TYPE <=", value, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeIn(List<Integer> values) {
            addCriterion("DW_TYPE in", values, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeNotIn(List<Integer> values) {
            addCriterion("DW_TYPE not in", values, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeBetween(Integer value1, Integer value2) {
            addCriterion("DW_TYPE between", value1, value2, "dwType");
            return (Criteria) this;
        }

        public Criteria andDwTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("DW_TYPE not between", value1, value2, "dwType");
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

        public Criteria andDfsDataDirIsNull() {
            addCriterion("DFS_DATA_DIR is null");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirIsNotNull() {
            addCriterion("DFS_DATA_DIR is not null");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirEqualTo(String value) {
            addCriterion("DFS_DATA_DIR =", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirNotEqualTo(String value) {
            addCriterion("DFS_DATA_DIR <>", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirGreaterThan(String value) {
            addCriterion("DFS_DATA_DIR >", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirGreaterThanOrEqualTo(String value) {
            addCriterion("DFS_DATA_DIR >=", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirLessThan(String value) {
            addCriterion("DFS_DATA_DIR <", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirLessThanOrEqualTo(String value) {
            addCriterion("DFS_DATA_DIR <=", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirLike(String value) {
            addCriterion("DFS_DATA_DIR like", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirNotLike(String value) {
            addCriterion("DFS_DATA_DIR not like", value, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirIn(List<String> values) {
            addCriterion("DFS_DATA_DIR in", values, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirNotIn(List<String> values) {
            addCriterion("DFS_DATA_DIR not in", values, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirBetween(String value1, String value2) {
            addCriterion("DFS_DATA_DIR between", value1, value2, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirNotBetween(String value1, String value2) {
            addCriterion("DFS_DATA_DIR not between", value1, value2, "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirIsNull() {
            addCriterion("LOCAL_DATA_DIR is null");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirIsNotNull() {
            addCriterion("LOCAL_DATA_DIR is not null");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirEqualTo(String value) {
            addCriterion("LOCAL_DATA_DIR =", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirNotEqualTo(String value) {
            addCriterion("LOCAL_DATA_DIR <>", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirGreaterThan(String value) {
            addCriterion("LOCAL_DATA_DIR >", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirGreaterThanOrEqualTo(String value) {
            addCriterion("LOCAL_DATA_DIR >=", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirLessThan(String value) {
            addCriterion("LOCAL_DATA_DIR <", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirLessThanOrEqualTo(String value) {
            addCriterion("LOCAL_DATA_DIR <=", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirLike(String value) {
            addCriterion("LOCAL_DATA_DIR like", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirNotLike(String value) {
            addCriterion("LOCAL_DATA_DIR not like", value, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirIn(List<String> values) {
            addCriterion("LOCAL_DATA_DIR in", values, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirNotIn(List<String> values) {
            addCriterion("LOCAL_DATA_DIR not in", values, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirBetween(String value1, String value2) {
            addCriterion("LOCAL_DATA_DIR between", value1, value2, "localDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirNotBetween(String value1, String value2) {
            addCriterion("LOCAL_DATA_DIR not between", value1, value2, "localDataDir");
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

        public Criteria andDwCodeLikeInsensitive(String value) {
            addCriterion("upper(DW_CODE) like", value.toUpperCase(), "dwCode");
            return (Criteria) this;
        }

        public Criteria andDwNameLikeInsensitive(String value) {
            addCriterion("upper(DW_NAME) like", value.toUpperCase(), "dwName");
            return (Criteria) this;
        }

        public Criteria andDfsDataDirLikeInsensitive(String value) {
            addCriterion("upper(DFS_DATA_DIR) like", value.toUpperCase(), "dfsDataDir");
            return (Criteria) this;
        }

        public Criteria andLocalDataDirLikeInsensitive(String value) {
            addCriterion("upper(LOCAL_DATA_DIR) like", value.toUpperCase(), "localDataDir");
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
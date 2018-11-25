package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WfFlowNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WfFlowNodeExample() {
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

        public Criteria andNodeIdIsNull() {
            addCriterion("NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Long value) {
            addCriterion("NODE_ID =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Long value) {
            addCriterion("NODE_ID <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Long value) {
            addCriterion("NODE_ID >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("NODE_ID >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Long value) {
            addCriterion("NODE_ID <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Long value) {
            addCriterion("NODE_ID <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Long> values) {
            addCriterion("NODE_ID in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Long> values) {
            addCriterion("NODE_ID not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Long value1, Long value2) {
            addCriterion("NODE_ID between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Long value1, Long value2) {
            addCriterion("NODE_ID not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("NODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("NODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("NODE_NAME =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("NODE_NAME <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("NODE_NAME >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_NAME >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("NODE_NAME <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("NODE_NAME <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("NODE_NAME like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("NODE_NAME not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("NODE_NAME in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("NODE_NAME not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("NODE_NAME between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("NODE_NAME not between", value1, value2, "nodeName");
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

        public Criteria andRefModuleIdIsNull() {
            addCriterion("REF_MODULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdIsNotNull() {
            addCriterion("REF_MODULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdEqualTo(Long value) {
            addCriterion("REF_MODULE_ID =", value, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdNotEqualTo(Long value) {
            addCriterion("REF_MODULE_ID <>", value, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdGreaterThan(Long value) {
            addCriterion("REF_MODULE_ID >", value, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REF_MODULE_ID >=", value, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdLessThan(Long value) {
            addCriterion("REF_MODULE_ID <", value, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdLessThanOrEqualTo(Long value) {
            addCriterion("REF_MODULE_ID <=", value, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdIn(List<Long> values) {
            addCriterion("REF_MODULE_ID in", values, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdNotIn(List<Long> values) {
            addCriterion("REF_MODULE_ID not in", values, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdBetween(Long value1, Long value2) {
            addCriterion("REF_MODULE_ID between", value1, value2, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andRefModuleIdNotBetween(Long value1, Long value2) {
            addCriterion("REF_MODULE_ID not between", value1, value2, "refModuleId");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNull() {
            addCriterion("POSITION_X is null");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNotNull() {
            addCriterion("POSITION_X is not null");
            return (Criteria) this;
        }

        public Criteria andPositionXEqualTo(Long value) {
            addCriterion("POSITION_X =", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotEqualTo(Long value) {
            addCriterion("POSITION_X <>", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThan(Long value) {
            addCriterion("POSITION_X >", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThanOrEqualTo(Long value) {
            addCriterion("POSITION_X >=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThan(Long value) {
            addCriterion("POSITION_X <", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThanOrEqualTo(Long value) {
            addCriterion("POSITION_X <=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXIn(List<Long> values) {
            addCriterion("POSITION_X in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotIn(List<Long> values) {
            addCriterion("POSITION_X not in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXBetween(Long value1, Long value2) {
            addCriterion("POSITION_X between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotBetween(Long value1, Long value2) {
            addCriterion("POSITION_X not between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNull() {
            addCriterion("POSITION_Y is null");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNotNull() {
            addCriterion("POSITION_Y is not null");
            return (Criteria) this;
        }

        public Criteria andPositionYEqualTo(Long value) {
            addCriterion("POSITION_Y =", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotEqualTo(Long value) {
            addCriterion("POSITION_Y <>", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThan(Long value) {
            addCriterion("POSITION_Y >", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThanOrEqualTo(Long value) {
            addCriterion("POSITION_Y >=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThan(Long value) {
            addCriterion("POSITION_Y <", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThanOrEqualTo(Long value) {
            addCriterion("POSITION_Y <=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYIn(List<Long> values) {
            addCriterion("POSITION_Y in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotIn(List<Long> values) {
            addCriterion("POSITION_Y not in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYBetween(Long value1, Long value2) {
            addCriterion("POSITION_Y between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotBetween(Long value1, Long value2) {
            addCriterion("POSITION_Y not between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdIsNull() {
            addCriterion("LAST_TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdIsNotNull() {
            addCriterion("LAST_TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdEqualTo(Long value) {
            addCriterion("LAST_TASK_ID =", value, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdNotEqualTo(Long value) {
            addCriterion("LAST_TASK_ID <>", value, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdGreaterThan(Long value) {
            addCriterion("LAST_TASK_ID >", value, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_TASK_ID >=", value, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdLessThan(Long value) {
            addCriterion("LAST_TASK_ID <", value, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("LAST_TASK_ID <=", value, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdIn(List<Long> values) {
            addCriterion("LAST_TASK_ID in", values, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdNotIn(List<Long> values) {
            addCriterion("LAST_TASK_ID not in", values, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdBetween(Long value1, Long value2) {
            addCriterion("LAST_TASK_ID between", value1, value2, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andLastTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("LAST_TASK_ID not between", value1, value2, "lastTaskId");
            return (Criteria) this;
        }

        public Criteria andWarningMsgIsNull() {
            addCriterion("WARNING_MSG is null");
            return (Criteria) this;
        }

        public Criteria andWarningMsgIsNotNull() {
            addCriterion("WARNING_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andWarningMsgEqualTo(String value) {
            addCriterion("WARNING_MSG =", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgNotEqualTo(String value) {
            addCriterion("WARNING_MSG <>", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgGreaterThan(String value) {
            addCriterion("WARNING_MSG >", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgGreaterThanOrEqualTo(String value) {
            addCriterion("WARNING_MSG >=", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgLessThan(String value) {
            addCriterion("WARNING_MSG <", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgLessThanOrEqualTo(String value) {
            addCriterion("WARNING_MSG <=", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgLike(String value) {
            addCriterion("WARNING_MSG like", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgNotLike(String value) {
            addCriterion("WARNING_MSG not like", value, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgIn(List<String> values) {
            addCriterion("WARNING_MSG in", values, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgNotIn(List<String> values) {
            addCriterion("WARNING_MSG not in", values, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgBetween(String value1, String value2) {
            addCriterion("WARNING_MSG between", value1, value2, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andWarningMsgNotBetween(String value1, String value2) {
            addCriterion("WARNING_MSG not between", value1, value2, "warningMsg");
            return (Criteria) this;
        }

        public Criteria andNodeStateIsNull() {
            addCriterion("NODE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andNodeStateIsNotNull() {
            addCriterion("NODE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andNodeStateEqualTo(Integer value) {
            addCriterion("NODE_STATE =", value, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateNotEqualTo(Integer value) {
            addCriterion("NODE_STATE <>", value, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateGreaterThan(Integer value) {
            addCriterion("NODE_STATE >", value, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("NODE_STATE >=", value, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateLessThan(Integer value) {
            addCriterion("NODE_STATE <", value, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateLessThanOrEqualTo(Integer value) {
            addCriterion("NODE_STATE <=", value, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateIn(List<Integer> values) {
            addCriterion("NODE_STATE in", values, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateNotIn(List<Integer> values) {
            addCriterion("NODE_STATE not in", values, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateBetween(Integer value1, Integer value2) {
            addCriterion("NODE_STATE between", value1, value2, "nodeState");
            return (Criteria) this;
        }

        public Criteria andNodeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("NODE_STATE not between", value1, value2, "nodeState");
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

        public Criteria andNodeNameLikeInsensitive(String value) {
            addCriterion("upper(NODE_NAME) like", value.toUpperCase(), "nodeName");
            return (Criteria) this;
        }

        public Criteria andWarningMsgLikeInsensitive(String value) {
            addCriterion("upper(WARNING_MSG) like", value.toUpperCase(), "warningMsg");
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
package com.yatop.lambda.base.model;

import com.yatop.lambda.base.utils.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DwDataTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public DwDataTableExample() {
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

        public Criteria andTableIdIsNull() {
            addCriterion("TABLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNotNull() {
            addCriterion("TABLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTableIdEqualTo(Long value) {
            addCriterion("TABLE_ID =", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotEqualTo(Long value) {
            addCriterion("TABLE_ID <>", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThan(Long value) {
            addCriterion("TABLE_ID >", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TABLE_ID >=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThan(Long value) {
            addCriterion("TABLE_ID <", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThanOrEqualTo(Long value) {
            addCriterion("TABLE_ID <=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdIn(List<Long> values) {
            addCriterion("TABLE_ID in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotIn(List<Long> values) {
            addCriterion("TABLE_ID not in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdBetween(Long value1, Long value2) {
            addCriterion("TABLE_ID between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotBetween(Long value1, Long value2) {
            addCriterion("TABLE_ID not between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("TABLE_NAME =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("TABLE_NAME <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("TABLE_NAME >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("TABLE_NAME <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("TABLE_NAME like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("TABLE_NAME not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("TABLE_NAME in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("TABLE_NAME not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("TABLE_NAME between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("TABLE_NAME not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableTypeIsNull() {
            addCriterion("TABLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTableTypeIsNotNull() {
            addCriterion("TABLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTableTypeEqualTo(Integer value) {
            addCriterion("TABLE_TYPE =", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotEqualTo(Integer value) {
            addCriterion("TABLE_TYPE <>", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeGreaterThan(Integer value) {
            addCriterion("TABLE_TYPE >", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TABLE_TYPE >=", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeLessThan(Integer value) {
            addCriterion("TABLE_TYPE <", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TABLE_TYPE <=", value, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeIn(List<Integer> values) {
            addCriterion("TABLE_TYPE in", values, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotIn(List<Integer> values) {
            addCriterion("TABLE_TYPE not in", values, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_TYPE between", value1, value2, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_TYPE not between", value1, value2, "tableType");
            return (Criteria) this;
        }

        public Criteria andTableSrcIsNull() {
            addCriterion("TABLE_SRC is null");
            return (Criteria) this;
        }

        public Criteria andTableSrcIsNotNull() {
            addCriterion("TABLE_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andTableSrcEqualTo(Integer value) {
            addCriterion("TABLE_SRC =", value, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcNotEqualTo(Integer value) {
            addCriterion("TABLE_SRC <>", value, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcGreaterThan(Integer value) {
            addCriterion("TABLE_SRC >", value, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcGreaterThanOrEqualTo(Integer value) {
            addCriterion("TABLE_SRC >=", value, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcLessThan(Integer value) {
            addCriterion("TABLE_SRC <", value, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcLessThanOrEqualTo(Integer value) {
            addCriterion("TABLE_SRC <=", value, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcIn(List<Integer> values) {
            addCriterion("TABLE_SRC in", values, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcNotIn(List<Integer> values) {
            addCriterion("TABLE_SRC not in", values, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_SRC between", value1, value2, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andTableSrcNotBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_SRC not between", value1, value2, "tableSrc");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdIsNull() {
            addCriterion("OWNER_DW_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdIsNotNull() {
            addCriterion("OWNER_DW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdEqualTo(Long value) {
            addCriterion("OWNER_DW_ID =", value, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdNotEqualTo(Long value) {
            addCriterion("OWNER_DW_ID <>", value, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdGreaterThan(Long value) {
            addCriterion("OWNER_DW_ID >", value, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OWNER_DW_ID >=", value, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdLessThan(Long value) {
            addCriterion("OWNER_DW_ID <", value, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdLessThanOrEqualTo(Long value) {
            addCriterion("OWNER_DW_ID <=", value, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdIn(List<Long> values) {
            addCriterion("OWNER_DW_ID in", values, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdNotIn(List<Long> values) {
            addCriterion("OWNER_DW_ID not in", values, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdBetween(Long value1, Long value2) {
            addCriterion("OWNER_DW_ID between", value1, value2, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andOwnerDwIdNotBetween(Long value1, Long value2) {
            addCriterion("OWNER_DW_ID not between", value1, value2, "ownerDwId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdIsNull() {
            addCriterion("REL_SNAPSHOT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdIsNotNull() {
            addCriterion("REL_SNAPSHOT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID =", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdNotEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID <>", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdGreaterThan(Long value) {
            addCriterion("REL_SNAPSHOT_ID >", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID >=", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdLessThan(Long value) {
            addCriterion("REL_SNAPSHOT_ID <", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdLessThanOrEqualTo(Long value) {
            addCriterion("REL_SNAPSHOT_ID <=", value, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdIn(List<Long> values) {
            addCriterion("REL_SNAPSHOT_ID in", values, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdNotIn(List<Long> values) {
            addCriterion("REL_SNAPSHOT_ID not in", values, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdBetween(Long value1, Long value2) {
            addCriterion("REL_SNAPSHOT_ID between", value1, value2, "relSnapshotId");
            return (Criteria) this;
        }

        public Criteria andRelSnapshotIdNotBetween(Long value1, Long value2) {
            addCriterion("REL_SNAPSHOT_ID not between", value1, value2, "relSnapshotId");
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

        public Criteria andTableColumnsIsNull() {
            addCriterion("TABLE_COLUMNS is null");
            return (Criteria) this;
        }

        public Criteria andTableColumnsIsNotNull() {
            addCriterion("TABLE_COLUMNS is not null");
            return (Criteria) this;
        }

        public Criteria andTableColumnsEqualTo(Long value) {
            addCriterion("TABLE_COLUMNS =", value, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsNotEqualTo(Long value) {
            addCriterion("TABLE_COLUMNS <>", value, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsGreaterThan(Long value) {
            addCriterion("TABLE_COLUMNS >", value, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsGreaterThanOrEqualTo(Long value) {
            addCriterion("TABLE_COLUMNS >=", value, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsLessThan(Long value) {
            addCriterion("TABLE_COLUMNS <", value, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsLessThanOrEqualTo(Long value) {
            addCriterion("TABLE_COLUMNS <=", value, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsIn(List<Long> values) {
            addCriterion("TABLE_COLUMNS in", values, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsNotIn(List<Long> values) {
            addCriterion("TABLE_COLUMNS not in", values, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsBetween(Long value1, Long value2) {
            addCriterion("TABLE_COLUMNS between", value1, value2, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableColumnsNotBetween(Long value1, Long value2) {
            addCriterion("TABLE_COLUMNS not between", value1, value2, "tableColumns");
            return (Criteria) this;
        }

        public Criteria andTableRowsIsNull() {
            addCriterion("TABLE_ROWS is null");
            return (Criteria) this;
        }

        public Criteria andTableRowsIsNotNull() {
            addCriterion("TABLE_ROWS is not null");
            return (Criteria) this;
        }

        public Criteria andTableRowsEqualTo(Long value) {
            addCriterion("TABLE_ROWS =", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsNotEqualTo(Long value) {
            addCriterion("TABLE_ROWS <>", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsGreaterThan(Long value) {
            addCriterion("TABLE_ROWS >", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsGreaterThanOrEqualTo(Long value) {
            addCriterion("TABLE_ROWS >=", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsLessThan(Long value) {
            addCriterion("TABLE_ROWS <", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsLessThanOrEqualTo(Long value) {
            addCriterion("TABLE_ROWS <=", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsIn(List<Long> values) {
            addCriterion("TABLE_ROWS in", values, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsNotIn(List<Long> values) {
            addCriterion("TABLE_ROWS not in", values, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsBetween(Long value1, Long value2) {
            addCriterion("TABLE_ROWS between", value1, value2, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsNotBetween(Long value1, Long value2) {
            addCriterion("TABLE_ROWS not between", value1, value2, "tableRows");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeIsNull() {
            addCriterion("DATA_FILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeIsNotNull() {
            addCriterion("DATA_FILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeEqualTo(Integer value) {
            addCriterion("DATA_FILE_TYPE =", value, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeNotEqualTo(Integer value) {
            addCriterion("DATA_FILE_TYPE <>", value, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeGreaterThan(Integer value) {
            addCriterion("DATA_FILE_TYPE >", value, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DATA_FILE_TYPE >=", value, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeLessThan(Integer value) {
            addCriterion("DATA_FILE_TYPE <", value, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeLessThanOrEqualTo(Integer value) {
            addCriterion("DATA_FILE_TYPE <=", value, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeIn(List<Integer> values) {
            addCriterion("DATA_FILE_TYPE in", values, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeNotIn(List<Integer> values) {
            addCriterion("DATA_FILE_TYPE not in", values, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeBetween(Integer value1, Integer value2) {
            addCriterion("DATA_FILE_TYPE between", value1, value2, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("DATA_FILE_TYPE not between", value1, value2, "dataFileType");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeIsNull() {
            addCriterion("DATA_FILE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeIsNotNull() {
            addCriterion("DATA_FILE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeEqualTo(Long value) {
            addCriterion("DATA_FILE_SIZE =", value, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeNotEqualTo(Long value) {
            addCriterion("DATA_FILE_SIZE <>", value, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeGreaterThan(Long value) {
            addCriterion("DATA_FILE_SIZE >", value, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("DATA_FILE_SIZE >=", value, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeLessThan(Long value) {
            addCriterion("DATA_FILE_SIZE <", value, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("DATA_FILE_SIZE <=", value, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeIn(List<Long> values) {
            addCriterion("DATA_FILE_SIZE in", values, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeNotIn(List<Long> values) {
            addCriterion("DATA_FILE_SIZE not in", values, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeBetween(Long value1, Long value2) {
            addCriterion("DATA_FILE_SIZE between", value1, value2, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("DATA_FILE_SIZE not between", value1, value2, "dataFileSize");
            return (Criteria) this;
        }

        public Criteria andDataFileIsNull() {
            addCriterion("DATA_FILE is null");
            return (Criteria) this;
        }

        public Criteria andDataFileIsNotNull() {
            addCriterion("DATA_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andDataFileEqualTo(String value) {
            addCriterion("DATA_FILE =", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileNotEqualTo(String value) {
            addCriterion("DATA_FILE <>", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileGreaterThan(String value) {
            addCriterion("DATA_FILE >", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_FILE >=", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileLessThan(String value) {
            addCriterion("DATA_FILE <", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileLessThanOrEqualTo(String value) {
            addCriterion("DATA_FILE <=", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileLike(String value) {
            addCriterion("DATA_FILE like", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileNotLike(String value) {
            addCriterion("DATA_FILE not like", value, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileIn(List<String> values) {
            addCriterion("DATA_FILE in", values, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileNotIn(List<String> values) {
            addCriterion("DATA_FILE not in", values, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileBetween(String value1, String value2) {
            addCriterion("DATA_FILE between", value1, value2, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataFileNotBetween(String value1, String value2) {
            addCriterion("DATA_FILE not between", value1, value2, "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileIsNull() {
            addCriterion("DATA_SUMMARY_FILE is null");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileIsNotNull() {
            addCriterion("DATA_SUMMARY_FILE is not null");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileEqualTo(String value) {
            addCriterion("DATA_SUMMARY_FILE =", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileNotEqualTo(String value) {
            addCriterion("DATA_SUMMARY_FILE <>", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileGreaterThan(String value) {
            addCriterion("DATA_SUMMARY_FILE >", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_SUMMARY_FILE >=", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileLessThan(String value) {
            addCriterion("DATA_SUMMARY_FILE <", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileLessThanOrEqualTo(String value) {
            addCriterion("DATA_SUMMARY_FILE <=", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileLike(String value) {
            addCriterion("DATA_SUMMARY_FILE like", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileNotLike(String value) {
            addCriterion("DATA_SUMMARY_FILE not like", value, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileIn(List<String> values) {
            addCriterion("DATA_SUMMARY_FILE in", values, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileNotIn(List<String> values) {
            addCriterion("DATA_SUMMARY_FILE not in", values, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileBetween(String value1, String value2) {
            addCriterion("DATA_SUMMARY_FILE between", value1, value2, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileNotBetween(String value1, String value2) {
            addCriterion("DATA_SUMMARY_FILE not between", value1, value2, "dataSummaryFile");
            return (Criteria) this;
        }

        public Criteria andTableStateIsNull() {
            addCriterion("TABLE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andTableStateIsNotNull() {
            addCriterion("TABLE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andTableStateEqualTo(Integer value) {
            addCriterion("TABLE_STATE =", value, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateNotEqualTo(Integer value) {
            addCriterion("TABLE_STATE <>", value, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateGreaterThan(Integer value) {
            addCriterion("TABLE_STATE >", value, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("TABLE_STATE >=", value, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateLessThan(Integer value) {
            addCriterion("TABLE_STATE <", value, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateLessThanOrEqualTo(Integer value) {
            addCriterion("TABLE_STATE <=", value, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateIn(List<Integer> values) {
            addCriterion("TABLE_STATE in", values, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateNotIn(List<Integer> values) {
            addCriterion("TABLE_STATE not in", values, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_STATE between", value1, value2, "tableState");
            return (Criteria) this;
        }

        public Criteria andTableStateNotBetween(Integer value1, Integer value2) {
            addCriterion("TABLE_STATE not between", value1, value2, "tableState");
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

        public Criteria andTableNameLikeInsensitive(String value) {
            addCriterion("upper(TABLE_NAME) like", value.toUpperCase(), "tableName");
            return (Criteria) this;
        }

        public Criteria andDataFileLikeInsensitive(String value) {
            addCriterion("upper(DATA_FILE) like", value.toUpperCase(), "dataFile");
            return (Criteria) this;
        }

        public Criteria andDataSummaryFileLikeInsensitive(String value) {
            addCriterion("upper(DATA_SUMMARY_FILE) like", value.toUpperCase(), "dataSummaryFile");
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
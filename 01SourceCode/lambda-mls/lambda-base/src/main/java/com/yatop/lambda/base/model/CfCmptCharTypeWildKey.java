package com.yatop.lambda.base.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cf_cmpt_char_type_wild")
public class CfCmptCharTypeWildKey implements Serializable {
    /**
     * 通配特征类型ID
     */
    @Id
    @Column(name = "WILD_CHAR_TYPE_ID")
    private Integer wildCharTypeId;

    /**
     * 单元特征类型ID
     */
    @Id
    @Column(name = "UNIT_CHAR_TYPE_ID")
    private Integer unitCharTypeId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取通配特征类型ID
     *
     * @return WILD_CHAR_TYPE_ID - 通配特征类型ID
     */
    public Integer getWildCharTypeId() {
        return wildCharTypeId;
    }

    /**
     * 设置通配特征类型ID
     *
     * @param wildCharTypeId 通配特征类型ID
     */
    public void setWildCharTypeId(Integer wildCharTypeId) {
        this.wildCharTypeId = wildCharTypeId;
    }

    /**
     * 获取单元特征类型ID
     *
     * @return UNIT_CHAR_TYPE_ID - 单元特征类型ID
     */
    public Integer getUnitCharTypeId() {
        return unitCharTypeId;
    }

    /**
     * 设置单元特征类型ID
     *
     * @param unitCharTypeId 单元特征类型ID
     */
    public void setUnitCharTypeId(Integer unitCharTypeId) {
        this.unitCharTypeId = unitCharTypeId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CfCmptCharTypeWildKey other = (CfCmptCharTypeWildKey) that;
        return (this.getWildCharTypeId() == null ? other.getWildCharTypeId() == null : this.getWildCharTypeId().equals(other.getWildCharTypeId()))
            && (this.getUnitCharTypeId() == null ? other.getUnitCharTypeId() == null : this.getUnitCharTypeId().equals(other.getUnitCharTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWildCharTypeId() == null) ? 0 : getWildCharTypeId().hashCode());
        result = prime * result + ((getUnitCharTypeId() == null) ? 0 : getUnitCharTypeId().hashCode());
        return result;
    }
}
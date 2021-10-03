package com.lq.system.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 积分等级表
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
public class IntegralGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 积分区间开始
     */
    private Integer integralStart;

    /**
     * 积分区间结束
     */
    private Integer integralEnd;

    /**
     * 借款额度
     */
    @NotNull(message = "借款额度不能为空")
    private BigDecimal borrowAmount;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除(1:已删除，0:未删除)
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIntegralStart() {
        return integralStart;
    }

    public void setIntegralStart(Integer integralStart) {
        this.integralStart = integralStart;
    }

    public Integer getIntegralEnd() {
        return integralEnd;
    }

    public void setIntegralEnd(Integer integralEnd) {
        this.integralEnd = integralEnd;
    }

    public BigDecimal getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(BigDecimal borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "IntegralGrade{" +
                "id=" + id +
                ", integralStart=" + integralStart +
                ", integralEnd=" + integralEnd +
                ", borrowAmount=" + borrowAmount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                "}";
    }
}

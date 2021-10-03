package com.lq.system.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 标的出借记录表
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
public class LendItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 投资编号
     */
    private String lendItemNo;

    /**
     * 标的id
     */
    private Long lendId;

    /**
     * 投资用户id
     */
    private Long investUserId;

    /**
     * 投资人名称
     */
    private String investName;

    /**
     * 投资金额
     */
    private BigDecimal investAmount;

    /**
     * 年化利率
     */
    private BigDecimal lendYearRate;

    /**
     * 投资时间
     */
    private Date investTime;

    /**
     * 开始日期
     */
    private Date lendStartDate;

    /**
     * 结束日期
     */
    private Date lendEndDate;

    /**
     * 预期收益
     */
    private BigDecimal expectAmount;

    /**
     * 实际收益
     */
    private BigDecimal realAmount;

    /**
     * 状态（0：默认 1：已支付 2：已还款）
     */
    private Integer status;

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

    public String getLendItemNo() {
        return lendItemNo;
    }

    public void setLendItemNo(String lendItemNo) {
        this.lendItemNo = lendItemNo;
    }

    public Long getLendId() {
        return lendId;
    }

    public void setLendId(Long lendId) {
        this.lendId = lendId;
    }

    public Long getInvestUserId() {
        return investUserId;
    }

    public void setInvestUserId(Long investUserId) {
        this.investUserId = investUserId;
    }

    public String getInvestName() {
        return investName;
    }

    public void setInvestName(String investName) {
        this.investName = investName;
    }

    public BigDecimal getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    public BigDecimal getLendYearRate() {
        return lendYearRate;
    }

    public void setLendYearRate(BigDecimal lendYearRate) {
        this.lendYearRate = lendYearRate;
    }

    public Date getInvestTime() {
        return investTime;
    }

    public void setInvestTime(Date investTime) {
        this.investTime = investTime;
    }

    public Date getLendStartDate() {
        return lendStartDate;
    }

    public void setLendStartDate(Date lendStartDate) {
        this.lendStartDate = lendStartDate;
    }

    public Date getLendEndDate() {
        return lendEndDate;
    }

    public void setLendEndDate(Date lendEndDate) {
        this.lendEndDate = lendEndDate;
    }

    public BigDecimal getExpectAmount() {
        return expectAmount;
    }

    public void setExpectAmount(BigDecimal expectAmount) {
        this.expectAmount = expectAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "LendItem{" +
        "id=" + id +
        ", lendItemNo=" + lendItemNo +
        ", lendId=" + lendId +
        ", investUserId=" + investUserId +
        ", investName=" + investName +
        ", investAmount=" + investAmount +
        ", lendYearRate=" + lendYearRate +
        ", investTime=" + investTime +
        ", lendStartDate=" + lendStartDate +
        ", lendEndDate=" + lendEndDate +
        ", expectAmount=" + expectAmount +
        ", realAmount=" + realAmount +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        "}";
    }
}

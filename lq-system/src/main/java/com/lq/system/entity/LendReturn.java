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
 * 还款记录表
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
public class LendReturn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标的id
     */
    private Long lendId;

    /**
     * 借款信息id
     */
    private Long borrowInfoId;

    /**
     * 还款批次号
     */
    private String returnNo;

    /**
     * 借款人用户id
     */
    private Long userId;

    /**
     * 借款金额
     */
    private BigDecimal amount;

    /**
     * 计息本金额
     */
    private BigDecimal baseAmount;

    /**
     * 当前的期数
     */
    private Integer currentPeriod;

    /**
     * 年化利率
     */
    private BigDecimal lendYearRate;

    /**
     * 还款方式 1-等额本息 2-等额本金 3-每月还息一次还本 4-一次还本
     */
    private Integer returnMethod;

    /**
     * 本金
     */
    private BigDecimal principal;

    /**
     * 利息
     */
    private BigDecimal interest;

    /**
     * 本息
     */
    private BigDecimal total;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 还款时指定的还款日期
     */
    private Date returnDate;

    /**
     * 实际发生的还款时间
     */
    private Date realReturnTime;

    /**
     * 是否逾期
     */
    @TableField("is_overdue")
    private Boolean overdue;

    /**
     * 逾期金额
     */
    private BigDecimal overdueTotal;

    /**
     * 是否最后一次还款
     */
    @TableField("is_last")
    private Boolean last;

    /**
     * 状态（0-未归还 1-已归还）
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

    public Long getLendId() {
        return lendId;
    }

    public void setLendId(Long lendId) {
        this.lendId = lendId;
    }

    public Long getBorrowInfoId() {
        return borrowInfoId;
    }

    public void setBorrowInfoId(Long borrowInfoId) {
        this.borrowInfoId = borrowInfoId;
    }

    public String getReturnNo() {
        return returnNo;
    }

    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public BigDecimal getLendYearRate() {
        return lendYearRate;
    }

    public void setLendYearRate(BigDecimal lendYearRate) {
        this.lendYearRate = lendYearRate;
    }

    public Integer getReturnMethod() {
        return returnMethod;
    }

    public void setReturnMethod(Integer returnMethod) {
        this.returnMethod = returnMethod;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getRealReturnTime() {
        return realReturnTime;
    }

    public void setRealReturnTime(Date realReturnTime) {
        this.realReturnTime = realReturnTime;
    }

    public Boolean getOverdue() {
        return overdue;
    }

    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }

    public BigDecimal getOverdueTotal() {
        return overdueTotal;
    }

    public void setOverdueTotal(BigDecimal overdueTotal) {
        this.overdueTotal = overdueTotal;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
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
        return "LendReturn{" +
        "id=" + id +
        ", lendId=" + lendId +
        ", borrowInfoId=" + borrowInfoId +
        ", returnNo=" + returnNo +
        ", userId=" + userId +
        ", amount=" + amount +
        ", baseAmount=" + baseAmount +
        ", currentPeriod=" + currentPeriod +
        ", lendYearRate=" + lendYearRate +
        ", returnMethod=" + returnMethod +
        ", principal=" + principal +
        ", interest=" + interest +
        ", total=" + total +
        ", fee=" + fee +
        ", returnDate=" + returnDate +
        ", realReturnTime=" + realReturnTime +
        ", overdue=" + overdue +
        ", overdueTotal=" + overdueTotal +
        ", last=" + last +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        "}";
    }
}

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
 * 标的准备表
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
public class Lend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 借款用户id
     */
    private Long userId;

    /**
     * 借款信息id
     */
    private Long borrowInfoId;

    /**
     * 标的编号
     */
    private String lendNo;

    /**
     * 标题
     */
    private String title;

    /**
     * 标的金额
     */
    private BigDecimal amount;

    /**
     * 投资期数
     */
    private Integer period;

    /**
     * 年化利率
     */
    private BigDecimal lendYearRate;

    /**
     * 平台服务费率
     */
    private BigDecimal serviceRate;

    /**
     * 还款方式
     */
    private Integer returnMethod;

    /**
     * 最低投资金额
     */
    private BigDecimal lowestAmount;

    /**
     * 已投金额
     */
    private BigDecimal investAmount;

    /**
     * 投资人数
     */
    private Integer investNum;

    /**
     * 发布日期
     */
    private Date publishDate;

    /**
     * 开始日期
     */
    private Date lendStartDate;

    /**
     * 结束日期
     */
    private Date lendEndDate;

    /**
     * 说明
     */
    private String lendInfo;

    /**
     * 平台预期收益
     */
    private BigDecimal expectAmount;

    /**
     * 实际收益
     */
    private BigDecimal realAmount;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 审核时间
     */
    private Date checkTime;

    /**
     * 审核用户id
     */
    private Long checkAdminId;

    /**
     * 放款时间
     */
    private Date paymentTime;

    /**
     * 放款人id
     */
    private Date paymentAdminId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBorrowInfoId() {
        return borrowInfoId;
    }

    public void setBorrowInfoId(Long borrowInfoId) {
        this.borrowInfoId = borrowInfoId;
    }

    public String getLendNo() {
        return lendNo;
    }

    public void setLendNo(String lendNo) {
        this.lendNo = lendNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getLendYearRate() {
        return lendYearRate;
    }

    public void setLendYearRate(BigDecimal lendYearRate) {
        this.lendYearRate = lendYearRate;
    }

    public BigDecimal getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(BigDecimal serviceRate) {
        this.serviceRate = serviceRate;
    }

    public Integer getReturnMethod() {
        return returnMethod;
    }

    public void setReturnMethod(Integer returnMethod) {
        this.returnMethod = returnMethod;
    }

    public BigDecimal getLowestAmount() {
        return lowestAmount;
    }

    public void setLowestAmount(BigDecimal lowestAmount) {
        this.lowestAmount = lowestAmount;
    }

    public BigDecimal getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }

    public Integer getInvestNum() {
        return investNum;
    }

    public void setInvestNum(Integer investNum) {
        this.investNum = investNum;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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

    public String getLendInfo() {
        return lendInfo;
    }

    public void setLendInfo(String lendInfo) {
        this.lendInfo = lendInfo;
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

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Long getCheckAdminId() {
        return checkAdminId;
    }

    public void setCheckAdminId(Long checkAdminId) {
        this.checkAdminId = checkAdminId;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getPaymentAdminId() {
        return paymentAdminId;
    }

    public void setPaymentAdminId(Date paymentAdminId) {
        this.paymentAdminId = paymentAdminId;
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
        return "Lend{" +
        "id=" + id +
        ", userId=" + userId +
        ", borrowInfoId=" + borrowInfoId +
        ", lendNo=" + lendNo +
        ", title=" + title +
        ", amount=" + amount +
        ", period=" + period +
        ", lendYearRate=" + lendYearRate +
        ", serviceRate=" + serviceRate +
        ", returnMethod=" + returnMethod +
        ", lowestAmount=" + lowestAmount +
        ", investAmount=" + investAmount +
        ", investNum=" + investNum +
        ", publishDate=" + publishDate +
        ", lendStartDate=" + lendStartDate +
        ", lendEndDate=" + lendEndDate +
        ", lendInfo=" + lendInfo +
        ", expectAmount=" + expectAmount +
        ", realAmount=" + realAmount +
        ", status=" + status +
        ", checkTime=" + checkTime +
        ", checkAdminId=" + checkAdminId +
        ", paymentTime=" + paymentTime +
        ", paymentAdminId=" + paymentAdminId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        "}";
    }
}

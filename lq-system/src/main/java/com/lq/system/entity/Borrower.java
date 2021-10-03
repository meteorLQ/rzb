package com.lq.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 借款人
 * </p>
 *
 * @author LQ
 * @since 2021-09-20
 */
public class Borrower implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 性别（1：男 0：女）
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 是否结婚（1：是 0：否）
     */
    @TableField("is_marry")
    private Boolean marry;

    /**
     * 行业
     */
    private Integer industry;

    /**
     * 月收入
     */
    private Integer income;

    /**
     * 还款来源
     */
    private Integer returnSource;

    /**
     * 联系人名称
     */
    private String contactsName;

    /**
     * 联系人手机
     */
    private String contactsMobile;

    /**
     * 联系人关系
     */
    private Integer contactsRelation;

    /**
     * 状态（0：未认证，1：认证中， 2：认证通过， -1：认证失败）
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Boolean getMarry() {
        return marry;
    }

    public void setMarry(Boolean marry) {
        this.marry = marry;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getReturnSource() {
        return returnSource;
    }

    public void setReturnSource(Integer returnSource) {
        this.returnSource = returnSource;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsMobile() {
        return contactsMobile;
    }

    public void setContactsMobile(String contactsMobile) {
        this.contactsMobile = contactsMobile;
    }

    public Integer getContactsRelation() {
        return contactsRelation;
    }

    public void setContactsRelation(Integer contactsRelation) {
        this.contactsRelation = contactsRelation;
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
        return "Borrower{" +
        "id=" + id +
        ", userId=" + userId +
        ", name=" + name +
        ", idCard=" + idCard +
        ", mobile=" + mobile +
        ", sex=" + sex +
        ", age=" + age +
        ", education=" + education +
        ", marry=" + marry +
        ", industry=" + industry +
        ", income=" + income +
        ", returnSource=" + returnSource +
        ", contactsName=" + contactsName +
        ", contactsMobile=" + contactsMobile +
        ", contactsRelation=" + contactsRelation +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", deleted=" + deleted +
        "}";
    }
}

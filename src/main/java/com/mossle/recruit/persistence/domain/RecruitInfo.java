package com.mossle.recruit.persistence.domain;

// Generated by Hibernate Tools
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RecruitInfo .
 * 
 * @author Lingo
 */
@Entity
@Table(name = "RECRUIT_INFO")
public class RecruitInfo implements java.io.Serializable {
    private static final long serialVersionUID = 0L;

    /** null. */
    private Long id;

    /** null. */
    private String name;

    /** null. */
    private String cardType;

    /** null. */
    private String cardValue;

    /** null. */
    private String mobile;

    /** null. */
    private String email;

    /** null. */
    private Date createTime;

    /** null. */
    private String status;

    /** null. */
    private String type;

    /** null. */
    private String tenantId;

    public RecruitInfo() {
    }

    public RecruitInfo(Long id) {
        this.id = id;
    }

    public RecruitInfo(Long id, String name, String cardType, String cardValue,
            String mobile, String email, Date createTime, String status,
            String type, String tenantId) {
        this.id = id;
        this.name = name;
        this.cardType = cardType;
        this.cardValue = cardValue;
        this.mobile = mobile;
        this.email = email;
        this.createTime = createTime;
        this.status = status;
        this.type = type;
        this.tenantId = tenantId;
    }

    /** @return null. */
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            null.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return null. */
    @Column(name = "NAME", length = 200)
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *            null.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** @return null. */
    @Column(name = "CARD_TYPE", length = 50)
    public String getCardType() {
        return this.cardType;
    }

    /**
     * @param cardType
     *            null.
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /** @return null. */
    @Column(name = "CARD_VALUE", length = 50)
    public String getCardValue() {
        return this.cardValue;
    }

    /**
     * @param cardValue
     *            null.
     */
    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    /** @return null. */
    @Column(name = "MOBILE", length = 50)
    public String getMobile() {
        return this.mobile;
    }

    /**
     * @param mobile
     *            null.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /** @return null. */
    @Column(name = "EMAIL", length = 100)
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     *            null.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return null. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 26)
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * @param createTime
     *            null.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** @return null. */
    @Column(name = "STATUS", length = 50)
    public String getStatus() {
        return this.status;
    }

    /**
     * @param status
     *            null.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** @return null. */
    @Column(name = "TYPE", length = 50)
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     *            null.
     */
    public void setType(String type) {
        this.type = type;
    }

    /** @return null. */
    @Column(name = "TENANT_ID", length = 64)
    public String getTenantId() {
        return this.tenantId;
    }

    /**
     * @param tenantId
     *            null.
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}

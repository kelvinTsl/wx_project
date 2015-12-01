package com.kelvin.product.web.model.plat;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kelvin on 15/11/26.
 */
@Entity
@Table(name="t_candidate")
public class Candidate {

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    @Column(name = "candidate_id")
    private int candidate_id;

    @Column(name="candidate_cellphone",nullable = false, length=16)
    private String candidateCellphone;
    @Column(name="candidate_name",nullable = false, length=16)
    private String candidateName;
    @Column(name="candidate_sex",nullable = false, length=16)
    private String candidateSex;
    @Column(name="candidate_age",nullable = true, length=3)
    private Integer candidateAge;
    @Column(name="candidate_password",nullable = false, length=255)
    private String candidatePassword;
    @Column(name="candidate_city",nullable = true, length=16)
    private String candidateCity;
    @Column(name="candidate_address",nullable = false, length=255)
    private String candidateAddress;
    @Column(name="candidate_idnum",nullable = true, length=16)
    private String candidateIdnum;
    @Column(name="candidate_wx_openid",nullable = false, length=32)
    private String candidateWxOpenid;
    @Column(name="candidate_wx_image_url",nullable = true, length=512)
    private String candidateWxImageUrl;
    @Column(name="candidate_wx_nick_name",nullable = true, length=64)
    private String candidateWxNickName;
    @Column(name="create_time",nullable = false, length=16)
    private int createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_time")
    private Date updateTime;

    public Integer getCandidateAge() {
        return candidateAge;
    }

    public void setCandidateAge(Integer candidateAge) {
        this.candidateAge = candidateAge;
    }

    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getCandidateCellphone() {
        return candidateCellphone;
    }

    public void setCandidateCellphone(String candidateCellphone) {
        this.candidateCellphone = candidateCellphone;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateSex() {
        return candidateSex;
    }

    public void setCandidateSex(String candidateSex) {
        this.candidateSex = candidateSex;
    }

    public String getCandidatePassword() {
        return candidatePassword;
    }

    public void setCandidatePassword(String candidatePassword) {
        this.candidatePassword = candidatePassword;
    }

    public String getCandidateCity() {
        return candidateCity;
    }

    public void setCandidateCity(String candidateCity) {
        this.candidateCity = candidateCity;
    }

    public String getCandidateAddress() {
        return candidateAddress;
    }

    public void setCandidateAddress(String candidateAddress) {
        this.candidateAddress = candidateAddress;
    }

    public String getCandidateIdnum() {
        return candidateIdnum;
    }

    public void setCandidateIdnum(String candidateIdnum) {
        this.candidateIdnum = candidateIdnum;
    }

    public String getCandidateWxOpenid() {
        return candidateWxOpenid;
    }

    public void setCandidateWxOpenid(String candidateWxOpenid) {
        this.candidateWxOpenid = candidateWxOpenid;
    }

    public String getCandidateWxImageUrl() {
        return candidateWxImageUrl;
    }

    public void setCandidateWxImageUrl(String candidateWxImageUrl) {
        this.candidateWxImageUrl = candidateWxImageUrl;
    }

    public String getCandidateWxNickName() {
        return candidateWxNickName;
    }

    public void setCandidateWxNickName(String candidateWxNickName) {
        this.candidateWxNickName = candidateWxNickName;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

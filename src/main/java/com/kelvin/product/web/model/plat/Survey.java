package com.kelvin.product.web.model.plat;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kelvin on 15/11/26.
 */
@Entity
@Table(name="t_survey")
public class Survey {

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    @Column(name = "survey_id")
    private int surveyId;

    @ManyToOne (cascade=CascadeType.REFRESH,optional=false)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name="wenjuan_code",nullable = false, length=32)
    private String wenjuanCode;
    @Column(name="wjx_jump_index",nullable = false, length=32)
    private int wjxJumpIndex;
    @Column(name="survey_score",nullable = true, length=16)
    private int surveyScore;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type="text")
    @Column(name="survey_details", nullable=true)
    private String surveyDetails;

    @Column(name="survey_duration",nullable = true, length=16)
    private String surveyDuration;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date createTime;

    @Column(name="status",nullable = true, length=2)
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getWenjuanCode() {
        return wenjuanCode;
    }

    public void setWenjuanCode(String wenjuanCode) {
        this.wenjuanCode = wenjuanCode;
    }

    public int getWjxJumpIndex() {
        return wjxJumpIndex;
    }

    public void setWjxJumpIndex(int wjxJumpIndex) {
        this.wjxJumpIndex = wjxJumpIndex;
    }

    public int getSurveyScore() {
        return surveyScore;
    }

    public void setSurveyScore(int surveyScore) {
        this.surveyScore = surveyScore;
    }

    public String getSurveyDetails() {
        return surveyDetails;
    }

    public void setSurveyDetails(String surveyDetails) {
        this.surveyDetails = surveyDetails;
    }

    public String getSurveyDuration() {
        return surveyDuration;
    }

    public void setSurveyDuration(String surveyDuration) {
        this.surveyDuration = surveyDuration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

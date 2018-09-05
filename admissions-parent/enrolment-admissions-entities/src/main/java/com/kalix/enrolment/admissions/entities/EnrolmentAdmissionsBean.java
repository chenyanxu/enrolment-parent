package com.kalix.enrolment.admissions.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "enrolment_admissions")
@Inheritance(strategy = InheritanceType.JOINED)
public class EnrolmentAdmissionsBean extends PersistentEntity {
    private Integer candidatenum;    // 考生号
    private String name;    // 考生姓名
    private Integer sex;    // 性别
    private String birth;   // 出生年月
    private String School;  //毕业学校
    private String idCards; // 身份证
    private String address; // 邮寄地址
    private String postCode; //邮编
    private String phone   ; //联系电话
    private String addressee; //收件人
    private Integer yxtddm  ; //院校投档代码
    private Integer batchcode; //批次代码
    private Integer kldm    ;   //科类代码
    private Long    score;     //成绩
    private Long    featuresScore; //特征成绩
    private Long    tdScore;     //投档成绩
    private Long    majorScore;  //专业成绩

    public Integer getCandidatenum() {
        return candidatenum;
    }

    public void setCandidatenum(Integer candidatenum) {
        this.candidatenum = candidatenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getIdCards() {
        return idCards;
    }

    public void setIdCards(String idCards) {
        this.idCards = idCards;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public Integer getYxtddm() {
        return yxtddm;
    }

    public void setYxtddm(Integer yxtddm) {
        this.yxtddm = yxtddm;
    }

    public Integer getBatchcode() {
        return batchcode;
    }

    public void setBatchcode(Integer batchcode) {
        this.batchcode = batchcode;
    }

    public Integer getKldm() {
        return kldm;
    }

    public void setKldm(Integer kldm) {
        this.kldm = kldm;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getFeaturesScore() {
        return featuresScore;
    }

    public void setFeaturesScore(Long featuresScore) {
        this.featuresScore = featuresScore;
    }

    public Long getTdScore() {
        return tdScore;
    }

    public void setTdScore(Long tdScore) {
        this.tdScore = tdScore;
    }

    public Long getMajorScore() {
        return majorScore;
    }

    public void setMajorScore(Long majorScore) {
        this.majorScore = majorScore;
    }
}

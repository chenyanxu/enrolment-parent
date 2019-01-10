package com.kalix.middleware.excel.api.model;

import com.kalix.framework.core.api.web.model.BaseDTO;
import com.kalix.middleware.excel.api.annotation.ExcelField;

/**
 * 试卷组合试题规则实体
 *
 * @author: fwb
 * @CreateDate: 2018-10-22
 * @version: 1.0
 */

public class ExamStudentDto extends BaseDTO {
    private String examNumber; //考号
    private String examName; //考生姓名
    private String identificationCard; //身份证
    private String major; //专业
    private String university; // 毕业院校
    private String address; // 联系地址
    private String phone; // 联系电话
    private String province; // 省份
    private String  barCode; // 条形码

    @ExcelField(title = "考号", type=0,align = 1, sort = 10)
    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber;
    }
    @ExcelField(title = "考生姓名", type=0,align = 1, sort = 20)
    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
    @ExcelField(title = "身份证", type=0,align = 1, sort = 30)
    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }
    @ExcelField(title = "专业", type=0,align = 1,dictType = "考生专业", sort = 40)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @ExcelField(title = "毕业院校", type=0,align = 1, sort =50)
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    @ExcelField(title = "联系地址", type=0,align = 1, sort = 60)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @ExcelField(title = "联系电话", type=0,align = 1, sort = 70)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @ExcelField(title = "省份", type=0,align = 1, sort = 80)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    @ExcelField(title = "条形码", type=0,align = 1, sort = 90)
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}

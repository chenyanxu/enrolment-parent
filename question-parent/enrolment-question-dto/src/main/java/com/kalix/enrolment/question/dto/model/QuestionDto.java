package com.kalix.enrolment.question.dto.model;

public class QuestionDto {
    private Long eTId;

    private Long examId;

    private Long questionTypeId;

    private Long questionNum;

    private Long typeScore;

    private Byte typeSort;
    
    public QuestionDto() {
	}

	public Long geteTId() {
        return eTId;
    }

    public void seteTId(Long eTId) {
        this.eTId = eTId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Long getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Long questionNum) {
        this.questionNum = questionNum;
    }

    public Long getTypeScore() {
        return typeScore;
    }

    public void setTypeScore(Long typeScore) {
        this.typeScore = typeScore;
    }

    public Byte getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(Byte typeSort) {
        this.typeSort = typeSort;
    }
}
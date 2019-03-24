package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Answer implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long answerId;
    private long questionId;
    private int code;
    private String label;
    private String next;
    private String value;
    private int minRange;
    private int maxRange;
    private int step;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    protected Answer() {}

    public Answer(
      long questionId,
      int code,
      String label,
      String next,
      String value,
      int minRange,
      int maxRange,
      int step
    )
    {
        this.questionId = questionId;
        this.code = code;
        this.label = label;
        this.next = next;
        this.value = value;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.step = step;
    }

    public Long getAnswerId() {
      return this.answerId;
    }

    public Long getQuestionId() {
      return this.questionId;
    }

    public int getCode() {
      return this.code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getLabel() {
      return this.label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public String getNext() {
      return this.next;
    }

    public void setNext(String next) {
      this.next = next;
    }

    public String getValue() {
      return this.value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public int getMinRange() {
      return this.minRange;
    }

    public void setMinRange(int minRange) {
      this.minRange = minRange;
    }

    public int getMaxRange() {
      return this.maxRange;
    }

    public void setMaxRange(int maxRange) {
      this.maxRange = maxRange;
    }

    public int getStep() {
      return this.step;
    }

    public void setStep(int step) {
      this.step = step;
    }

    public Date getCreatedAt() {
      return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
      return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
    }

}

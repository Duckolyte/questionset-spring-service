package com.example.easynotes.model;

import com.example.easynotes.model.Asset;
import com.example.easynotes.model.Answer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Question implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long questionId;
    private long questionsetId;
    private int code;
    private String label;
    private Boolean usesImage;

    @OneToMany(mappedBy="questionId")
    private Set<Answer> answers;

    @OneToMany(mappedBy="questionId")
    private Set<Asset> assets;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    protected Question() {}

    public Question(
      long questionsetId,
      int code,
      String label,
      Boolean usesImage
    )
    {
        this.questionsetId = questionsetId;
        this.code = code;
        this.label = label;
        this.usesImage = usesImage;
    }

    public Long getQuestionId() {
      return this.questionId;
    }

    public Long getQuestionsetId() {
      return this.questionsetId;
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

    public Boolean getUsesImage() {
      return this.usesImage;
    }

    public void setUsesImage(Boolean usesImage) {
      this.usesImage = usesImage;
    }

    public Set<Answer> getAnswers(){
      return this.answers;
    }

    public void setAnswers(Set<Answer> answers){
      this.answers = answers;
    }

    public Set<Asset> getAssets(){
      return this.assets;
    }

    public void setAssets(Set<Asset> assets){
      this.assets = assets;
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

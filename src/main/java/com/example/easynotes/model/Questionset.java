package com.example.easynotes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questionset {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final long questionsetId = 0;
    private Date createdAt;
    private String createdFrom;

    protected Questionset() {}

    public Questionset(
      Date createdAt,
      String createdFrom
    )
    {
        this.createdAt = createdAt;
        this.createdFrom = createdFrom;
    }

}

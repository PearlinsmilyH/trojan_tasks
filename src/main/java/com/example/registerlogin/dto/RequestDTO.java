package com.example.registerlogin.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class RequestDTO {
    private long id;
    private String requisitionNote;
    private String equipmentType;
    private int shift;
    private boolean fuel;
    private boolean driver;
    private boolean operator;
    //  private int trips;
    private Date durationFrom;
    private Date durationTo;
    private Long projectId;
    private String projectName;
    private Date created;



}
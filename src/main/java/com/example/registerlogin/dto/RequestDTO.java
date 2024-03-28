package com.example.registerlogin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
@Getter
@Setter
@Data
public class RequestDTO {
    private long id;
    @NotNull(message = "RequisitionNote must not be null")
    @NotBlank(message = "RequisitionNote must not be null")
    private String requisitionNote;
    private String equipmentType;
    private int shift;
    private boolean fuel;
    private boolean driver;
    private boolean operator;
    private Date durationFrom;
    private Date durationTo;
    private Long projectId;
    private String projectName;
    private Date created;
}
 
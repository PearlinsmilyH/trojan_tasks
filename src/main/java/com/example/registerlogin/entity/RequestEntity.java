package com.example.registerlogin.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
@Data
@Entity
@Table
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "projectId")
    private Long projectId;
    @Column(name = "requisitionNote")
    private String requisitionNote;
    @Column(name = "equipmentType")
    private String equipmentType;
    @Column(name = "shift")
    private int shift;
    @Column(name = "fuel")
    private boolean fuel;
    @Column(name = "driver")
    private boolean driver;
    @Column(name = "operator")
    private boolean operator;
    @Column(name = "durationFrom")
    private Date durationFrom;
    @Column(name = "durationTo")
    private Date durationTo;
    @Column(name = "created")
    @CreationTimestamp
    private Date created;

    public RequestEntity() {
    }
    public RequestEntity(Long projectId, String requisitionNote, String equipmentType, int shift, boolean fuel, boolean driver, boolean operator, Date durationFrom, Date durationTo, Long projectId1) {
        this.projectId = projectId;
        this.requisitionNote = requisitionNote;
        this.equipmentType = equipmentType;
        this.shift = shift;
        this.fuel = fuel;
        this.driver = driver;
        this.operator = operator;
        this.durationFrom = durationFrom;
        this.durationTo = durationTo;
    }
}
 
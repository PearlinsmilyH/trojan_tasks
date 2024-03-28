package com.example.registerlogin.entity;

import com.example.registerlogin.dto.RequestDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
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

    public RequestEntity(RequestDTO requestDTO) {
        this.requisitionNote = requestDTO.getRequisitionNote();
        this.equipmentType = requestDTO.getEquipmentType();
        this.shift = requestDTO.getShift();
        this.fuel = requestDTO.isFuel();
        this.driver = requestDTO.isDriver();
        this.operator = requestDTO.isOperator();
        this.durationFrom = requestDTO.getDurationFrom();
        this.durationTo = requestDTO.getDurationTo();
        this.projectId = requestDTO.getProjectId();
    }
}
 
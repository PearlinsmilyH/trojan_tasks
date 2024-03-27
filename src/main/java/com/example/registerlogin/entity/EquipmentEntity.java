package com.example.registerlogin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String equipmentName;

    public EquipmentEntity(Long id, String equipmentName) {
        this.id = id;
        this.equipmentName = equipmentName;
    }
    public EquipmentEntity() {
    }
}

package com.example.registerlogin.service;

import com.example.registerlogin.dto.EquipmentDTO;
import com.example.registerlogin.entity.EquipmentEntity;
import com.example.registerlogin.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentImpl implements EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Override
    public ResponseEntity<String> createEquipment(EquipmentDTO equipmentDTO) {
        EquipmentEntity equipmentEntity = new EquipmentEntity(
                equipmentDTO.getId(),equipmentDTO.getEquipmentName());
        equipmentRepository.save(equipmentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Equipment created successfully");
    }
    @Override
    public ResponseEntity<List<?>> getEquipments() {
        List<EquipmentEntity> equipments = equipmentRepository.findAll();
        return ResponseEntity.ok(equipments);
    }
}

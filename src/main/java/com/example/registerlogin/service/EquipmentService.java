package com.example.registerlogin.service;

import com.example.registerlogin.dto.EquipmentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List; // Import List interface
public interface EquipmentService {
    ResponseEntity<?> createEquipment(EquipmentDTO equipmentDTO);
    ResponseEntity<List<?>> getEquipments();
}

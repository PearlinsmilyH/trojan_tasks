package com.example.registerlogin.controller;
import com.example.registerlogin.dto.EquipmentDTO;
import com.example.registerlogin.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping(path = "/create")
    public ResponseEntity<?> createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        return equipmentService.createEquipment(equipmentDTO);
    }
    @GetMapping
    public ResponseEntity<List<?>> getEquipment(){
        return equipmentService.getEquipments();
    }
}


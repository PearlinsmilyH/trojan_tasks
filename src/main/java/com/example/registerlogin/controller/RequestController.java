package com.example.registerlogin.controller;
import com.example.registerlogin.dto.RequestDTO;
import com.example.registerlogin.entity.RequestEntity;
import com.example.registerlogin.repository.RequestRepository;
import com.example.registerlogin.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/request")
public class RequestController {
  @Autowired
  private RequestRepository requestRepository;
  @Autowired
  private RequestService requestService;
  @PostMapping(path = "/create")
  public ResponseEntity<?> createRequest(@RequestBody @Valid RequestDTO requestDTO) throws Exception {
    try {
      if (requestDTO.getProjectId()==0){
        throw new IllegalArgumentException("Project Name is required");
      }
      if (requestDTO.getRequisitionNote().isEmpty()) {
       throw new IllegalArgumentException("Requisition Note is required.");
      }
      if (requestDTO.getEquipmentType().isEmpty()) {
        throw new IllegalArgumentException("Equipment Type is required.");
      }
      if (requestDTO.getDurationFrom() == null || requestDTO.getDurationTo() == null) {
        throw new IllegalArgumentException("Duration is required.");
      }
      requestService.createRequest(requestDTO);
      return ResponseEntity.ok("Request created successfully.");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
//  public RequestEntity createRequest(@RequestBody RequestDTO requestDTO) {
//    return ResponseEntity.ok( requestService.createRequest(requestDTO)).getBody();
//  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getRequestById(@PathVariable Long id) {
    Optional<RequestEntity> requestEntity = requestService.getRequestById(id);
    if (requestEntity.isPresent()) {
      return ResponseEntity.ok(requestEntity.get());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request with ID " + id + " not found");
    }
  }
  @GetMapping
  public ResponseEntity<List<RequestDTO>> getRequests() {
    List<RequestDTO> requestDTOs = requestService.getAllRequests();
    return ResponseEntity.ok().body(requestDTOs);
  }
}


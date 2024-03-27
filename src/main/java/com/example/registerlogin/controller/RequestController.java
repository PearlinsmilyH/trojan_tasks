package com.example.registerlogin.controller;
import com.example.registerlogin.dto.RequestDTO;
import com.example.registerlogin.entity.RequestEntity;
import com.example.registerlogin.repository.RequestRepository;
import com.example.registerlogin.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
  public RequestEntity createRequest(@RequestBody RequestDTO requestDTO) {
    return   requestService.createRequest(requestDTO);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Object> getRequestById(@PathVariable Long id) {
    Optional<RequestEntity> requestEntity = requestService.getRequestById(id);
    return ResponseEntity.ok(requestEntity);
  }

  //  @GetMapping
//  public ResponseEntity<List<RequestEntity>> getRequests() {
//    List<RequestEntity> requests = requestService.getRequest();
//    return ResponseEntity.ok(requests);
//  }
  @GetMapping
  public ResponseEntity<List<RequestDTO>> getRequests() {
    List<RequestDTO> requestDTOs = requestService.getRequestWithProjectName();
    return ResponseEntity.ok().body(requestDTOs);
  }

}
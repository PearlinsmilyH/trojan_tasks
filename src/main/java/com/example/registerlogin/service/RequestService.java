package com.example.registerlogin.service;

import com.example.registerlogin.dto.RequestDTO;
import com.example.registerlogin.entity.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    RequestEntity createRequest(RequestDTO requestDTO) throws Exception;
    Optional<RequestEntity> getRequestById(Long id);

    public List<RequestDTO> getAllRequests();


}
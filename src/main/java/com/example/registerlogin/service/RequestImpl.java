package com.example.registerlogin.service;

import com.example.registerlogin.dto.RequestDTO;
import com.example.registerlogin.entity.ProjectEntity;
import com.example.registerlogin.entity.RequestEntity;
import com.example.registerlogin.repository.ProjectRepository;
import com.example.registerlogin.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public RequestEntity createRequest(RequestDTO requestDTO) {
        RequestEntity request = new RequestEntity(
                requestDTO.getProjectId(),
                requestDTO.getRequisitionNote(),
                requestDTO.getEquipmentType(),
                requestDTO.getShift(),
                requestDTO.isFuel(),
                requestDTO.isDriver(),
                requestDTO.isOperator(),
                requestDTO.getDurationFrom(),
                requestDTO.getDurationTo(),
                requestDTO.getProjectId()
        );
        requestRepository.save(request);
        String s = "success";
        return request;

    }
    @Override
    public Optional<RequestEntity> getRequestById(Long id) {
        return requestRepository.findById(id);
    }
//    @Override
//    public List<RequestEntity> getRequest() {
//        return requestRepository.findAll();
//    }

    public List<RequestDTO> getRequestWithProjectName() {
        List<RequestEntity> requestEntities = requestRepository.findAll();
        return requestEntities.stream()
                .map(requestEntity -> {
                    RequestDTO requestDTO = new RequestDTO();
                    requestDTO.setId(requestEntity.getId());
                    requestDTO.setRequisitionNote(requestEntity.getRequisitionNote());
                    requestDTO.setEquipmentType(requestEntity.getEquipmentType());
                    requestDTO.setShift(requestEntity.getShift());
                    requestDTO.setFuel(requestEntity.isFuel());
                    requestDTO.setDriver(requestEntity.isDriver());
                    requestDTO.setOperator(requestEntity.isOperator());
                    requestDTO.setDurationFrom(requestEntity.getDurationFrom());
                    requestDTO.setDurationTo(requestEntity.getDurationTo());
                    requestDTO.setProjectId(requestEntity.getProjectId());
                    requestDTO.setCreated(requestEntity.getCreated());
                    String projectName = fetchProjectName(requestEntity.getProjectId());
                    requestDTO.setProjectName(projectName);
                    return requestDTO;
                })
                .collect(Collectors.toList());
    }

    private String fetchProjectName(Long projectId) {
        ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        return projectEntity != null ? projectEntity.getProjectName() : null;
    }

}
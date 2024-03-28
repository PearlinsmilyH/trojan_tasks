package com.example.registerlogin.service;

import com.example.registerlogin.dto.RequestDTO;
import com.example.registerlogin.entity.ProjectEntity;
import com.example.registerlogin.entity.RequestEntity;
import com.example.registerlogin.repository.ProjectRepository;
import com.example.registerlogin.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RequestImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public RequestEntity createRequest(RequestDTO requestDTO)throws Exception {
        RequestEntity requestEntity = new RequestEntity(requestDTO);
        return requestRepository.save(requestEntity);
    }
    @Override
    public Optional<RequestEntity> getRequestById(Long id) {
        return requestRepository.findById(id);
    }
    @Override
    public List<RequestDTO> getAllRequests() {
        List<RequestEntity> requests = requestRepository.findAll();
        Set<Long> projectIds = requests.stream()
                .map(RequestEntity::getProjectId)
                .collect(Collectors.toSet());
        //which removes duplicate projectid from requests and store only unigue projectid
        Map<Long, String> projectNamesMap = fetchProjectNames(projectIds);//store as key and value here
        return mapToRequestDTOs(requests, projectNamesMap);
    }
    private Map<Long, String> fetchProjectNames(Set<Long> projectIds) {
        //find all projects with projectid
        List<ProjectEntity> projects = projectRepository.findAllByIdIn(projectIds);
        //convert the projects as map
        return projects.stream()
                .collect(Collectors.toMap(ProjectEntity::getId, ProjectEntity::getProjectName));
    }
    private List<RequestDTO> mapToRequestDTOs(List<RequestEntity> requests, Map<Long, String> projectNamesMap) {
      //  itterate the requests to store the project name
        List<RequestDTO> dtos = new ArrayList<>();
        for (RequestEntity request : requests) {
            RequestDTO dto = new RequestDTO();
            dto.setId(request.getId());
            dto.setRequisitionNote(request.getRequisitionNote());
            dto.setEquipmentType(request.getEquipmentType());
            dto.setShift(request.getShift());
            dto.setFuel(request.isFuel());
            dto.setDriver(request.isDriver());
            dto.setOperator(request.isOperator());
            dto.setDurationFrom(request.getDurationFrom());
            dto.setDurationTo(request.getDurationTo());
            dto.setProjectId(request.getProjectId());
            dto.setProjectName(projectNamesMap.get(request.getProjectId()));//get the projectname from projectnamemap using projectid
            dto.setCreated(request.getCreated());
            dtos.add(dto);
        }
        return dtos;
    }
}

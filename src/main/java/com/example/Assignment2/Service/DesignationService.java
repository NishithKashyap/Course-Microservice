package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.Designation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DesignationService {

    String createDesignation(String designation);
    List<Designation> fetchAllDesignation();
    Optional<Designation> fetchDesignation(int designationId);
    Optional<Designation> updateDesignation(int designationId, String designationRequest);
    void deleteDesignation(int designationId);
}

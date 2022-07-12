package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.Designation;
import com.example.Assignment2.Repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationServiceImplementation implements DesignationService {

    @Autowired
    DesignationRepository designationRepository;

    @Override
    public String createDesignation(String design){
        Designation designation = new Designation();
        designation.setDesignation(design);
        designationRepository.save(designation);
        return "Designation successfully created";
    }

    @Override
    public List<Designation> fetchAllDesignation(){
        return designationRepository.findAll();
    }

    @Override
    public Optional<Designation> fetchDesignation(int designationId){
        return designationRepository.findById(designationId);
    }

    @Override
    public Optional<Designation> updateDesignation(int designationId, String designationRequest){
        Optional<Designation> designation = designationRepository.findById(designationId);
        designation.get().setDesignation(designationRequest);
        designationRepository.save(designation.get());
        return designation;
    }

    @Override
    public void deleteDesignation(int designationId){
        if(designationRepository.getById(designationId).getDesignationId() == designationId) {
            designationRepository.deleteById(designationId);
        }
    }
}

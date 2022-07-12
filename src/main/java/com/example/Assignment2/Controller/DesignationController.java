package com.example.Assignment2.Controller;

import com.example.Assignment2.Entity.Designation;
import com.example.Assignment2.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DesignationController {

    @Autowired
    DesignationService designationService;

    @GetMapping("/designation/all")
    public ResponseEntity<List<Designation>> getAllDesignations() {
        List<Designation> designation = designationService.fetchAllDesignation();
        return new ResponseEntity<>(designation, HttpStatus.OK);
    }

    @GetMapping("/designation/{id}")
    public ResponseEntity<Designation> getDesignationById (@PathVariable("id") int id) {
        Optional<Designation> designation = designationService.fetchDesignation(id);
        return new ResponseEntity(designation, HttpStatus.OK);
    }

    @PostMapping("/designation/create/{designation}")
    public ResponseEntity<String> createDesignation( @PathVariable("designation") String designation) {
        String newDesignation = designationService.createDesignation(designation);
        return new ResponseEntity<>(newDesignation, HttpStatus.CREATED);
    }

    @PutMapping("/designation/{id}/update")
    public ResponseEntity<String> updateDesignation( @PathVariable int id, @RequestBody String designation) {
        Optional<Designation> updatedesignation = designationService.updateDesignation(id, designation);
        return new ResponseEntity(updatedesignation, HttpStatus.OK);
    }

    @DeleteMapping("/designation/{id}/delete")
    public ResponseEntity<?> deleteDesignation(@PathVariable("id") int id) {
        designationService.deleteDesignation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

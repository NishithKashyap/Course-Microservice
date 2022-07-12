package com.example.Assignment2.Controller;

import com.example.Assignment2.Entity.Course;
import com.example.Assignment2.Payload.CourseRequest;
import com.example.Assignment2.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/course/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> course = courseService.fetchAllCourse();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById (@PathVariable("id") int id) {
        Optional<Course> course = courseService.fetchCourse(id);
        return new ResponseEntity(course, HttpStatus.OK);
    }

    @PostMapping("/course/create")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequest course) {
        String newCourse = courseService.createCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @PutMapping("/course/{id}/update")
    public ResponseEntity<String> updateCourse( @PathVariable int id, @RequestBody CourseRequest course) {
        Optional<Course> updateCourse = courseService.updateCourse(id, course);
        return new ResponseEntity(updateCourse, HttpStatus.OK);
    }

    @DeleteMapping("/course/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

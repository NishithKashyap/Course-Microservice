package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.Course;
import com.example.Assignment2.Payload.CourseRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CourseService {

    String createCourse(CourseRequest courseRequest);
    List<Course> fetchAllCourse();
    Optional<Course> fetchCourse(int courseId);
    Optional<Course> updateCourse(int courseId, CourseRequest courseRequest);
    void deleteCourse(int courseId);
}

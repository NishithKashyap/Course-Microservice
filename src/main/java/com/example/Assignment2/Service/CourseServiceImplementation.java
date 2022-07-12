package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.Course;
import com.example.Assignment2.Payload.CourseRequest;
import com.example.Assignment2.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public String createCourse(CourseRequest courseRequest){
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setCourseDuration(courseRequest.getCourseDuration());
        courseRepository.save(course);
        return "Course successfully created";
    }

    @Override
    public List<Course> fetchAllCourse(){
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> fetchCourse(int courseId){
        return courseRepository.findById(courseId);
    }

    @Override
    public Optional<Course> updateCourse(int courseId, CourseRequest courseRequest){
        Optional<Course> course = courseRepository.findById(courseId);
        course.get().setCourseName(courseRequest.getCourseName());
        course.get().setCourseDuration(courseRequest.getCourseDuration());
        courseRepository.save(course.get());
        return course;
    }

    @Override
    public void deleteCourse(int courseId){
        if(courseRepository.getById(courseId).getCourseId() == courseId) {
            courseRepository.deleteById(courseId);
        }
    }
}

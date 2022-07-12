package com.example.Assignment2.Repository;

import com.example.Assignment2.Entity.Course;
import com.example.Assignment2.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByCourse(Optional<Course> course);
}

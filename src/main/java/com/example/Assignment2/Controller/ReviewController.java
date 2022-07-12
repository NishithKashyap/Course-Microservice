package com.example.Assignment2.Controller;

import com.example.Assignment2.Entity.Review;
import com.example.Assignment2.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/course/{id}/review/all")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable("id") int id) {
        List<Review> review = reviewService.fetchAllReview(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById (@PathVariable("id") int id) {
        Optional<Review> review = reviewService.fetchReview(id);
        return new ResponseEntity(review, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/course/{courseId}/review/create")
    public ResponseEntity<String> createReview( @RequestBody String review, @PathVariable("userId") int userId, @PathVariable("courseId") int courseId) {
        String newReview = reviewService.createReview(userId, courseId, review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @PutMapping("/review/{reviewId}/update")
    public ResponseEntity<String> updateReview( @PathVariable("reviewId") int id, @RequestBody String review) {
        Optional<Review> updateReview = reviewService.updateReview(id, review);
        return new ResponseEntity(updateReview, HttpStatus.OK);
    }

    @DeleteMapping("/review/{id}/delete")
    public ResponseEntity<?> deleteReview(@PathVariable("id") int id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

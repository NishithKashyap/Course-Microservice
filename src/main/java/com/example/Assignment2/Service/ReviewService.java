package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.Review;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ReviewService {

    String createReview(int userId, int courseId, String review);
    List<Review> fetchAllReview(int id);
    Optional<Review> fetchReview(int reviewId);
    Optional<Review> updateReview(int reviewId, String reviewRequest);
    void deleteReview(int reviewId);
}

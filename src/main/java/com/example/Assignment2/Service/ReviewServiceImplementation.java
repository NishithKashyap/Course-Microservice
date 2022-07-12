package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.Course;
import com.example.Assignment2.Entity.Review;
import com.example.Assignment2.Repository.CourseRepository;
import com.example.Assignment2.Repository.ReviewRepository;
import com.example.Assignment2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public String createReview(int userId, int courseId, String reviewRequest){
        Review review = new Review();
        if(userRepository.existsById(userId)){
            if(courseRepository.existsById(courseId)){
                review.setUser(userRepository.findById(userId).get());
                review.setCourse(courseRepository.findById(courseId).get());
                review.setReview(reviewRequest);
                reviewRepository.save(review);
                return "Review successfully created";
            }
            else {
                return "Course does not exist. Incorrect Course ID";
            }
        }
        return "User does not exist. Incorrect User ID";
    }

    @Override
    public List<Review> fetchAllReview(int id){
        Optional<Course> course = courseRepository.findById(id);
        return reviewRepository.findByCourse(course);
    }

    @Override
    public Optional<Review> fetchReview(int reviewId){
        return reviewRepository.findById(reviewId);
    }

    @Override
    public Optional<Review> updateReview(int reviewId, String review){
        Optional<Review> review1 = reviewRepository.findById(reviewId);
        review1.get().setReview(review);
        reviewRepository.save(review1.get());
        return review1;
    }

    @Override
    public void deleteReview(int reviewId){
        if(reviewRepository.getById(reviewId).getReviewId() == reviewId) {
            reviewRepository.deleteById(reviewId);
        }
    }
}

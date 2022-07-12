package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.User;
import com.example.Assignment2.Payload.UserRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    String createUser(UserRequest userRequest);
    List<User> fetchAllUser();
    Optional<User> fetchUser(int id);
    Optional<User> updateUser(int id, UserRequest userRequest);
    void deleteUser(int id);
}

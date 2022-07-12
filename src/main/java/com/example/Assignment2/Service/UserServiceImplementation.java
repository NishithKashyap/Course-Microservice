package com.example.Assignment2.Service;

import com.example.Assignment2.Entity.User;
import com.example.Assignment2.Payload.UserRequest;
import com.example.Assignment2.Repository.DesignationRepository;
import com.example.Assignment2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DesignationRepository designationRepository;

    @Override
    public String createUser(UserRequest userRequest)
    {
        if(designationRepository.existsById(userRequest.getDesignationId())) {
            User user = new User();
            user.setUserName(userRequest.getUserName());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setDesignation(designationRepository.getById(userRequest.getDesignationId()));
            user.setPassword(userRequest.getPassword());
            userRepository.save(user);
            return "User successfully created";
        }
        return "Designation does not exist";
    }

    @Override
    public List<User> fetchAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> fetchUser(int id){
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(int id, UserRequest userRequest){
        Optional<User> user = userRepository.findById(id);
        user.get().setUserName(userRequest.getUserName());
        user.get().setFirstName(userRequest.getFirstName());
        user.get().setLastName(userRequest.getLastName());
        user.get().setDesignation(designationRepository.getById(userRequest.getDesignationId()));
        user.get().setPassword(userRequest.getPassword());
        userRepository.save(user.get());
        return user;
    }

    @Override
    public void deleteUser(int id) {
        if(userRepository.getById(id).getId() == id) {
            userRepository.deleteById(id);
        }
    }
}

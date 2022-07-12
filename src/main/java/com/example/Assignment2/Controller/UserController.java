package com.example.Assignment2.Controller;

import com.example.Assignment2.Entity.User;
import com.example.Assignment2.Payload.UserRequest;
import com.example.Assignment2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> user = userService.fetchAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") int id) {
        Optional<User> user = userService.fetchUser(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity<String> createUser( @RequestBody UserRequest user) {
        String newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}/update")
    public ResponseEntity<String> updateUser( @PathVariable int id, @RequestBody UserRequest user) {
        Optional<User> updateUser = userService.updateUser(id, user);
        return new ResponseEntity(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

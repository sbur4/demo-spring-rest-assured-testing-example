package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") long id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
        User user = userService.getByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(User newUser) {
        User user = userService.create(newUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping("/user/{password}/{email}")
    public ResponseEntity<?> updateByEmail(@PathVariable("password") String password, @PathVariable("email") String email) {
        userService.updateByEmail(email, password);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> remove(@PathVariable("email") String email) {
        userService.remove(email);
        return ResponseEntity.ok().build();
    }
}
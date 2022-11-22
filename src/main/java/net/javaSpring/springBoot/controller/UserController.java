package net.javaSpring.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaSpring.springBoot.model.dto.response.ResponseData;
import net.javaSpring.springBoot.model.dto.request.UserDto;
import net.javaSpring.springBoot.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
  
    private ResponseData<Object> responseData;

    @GetMapping
    public ResponseEntity<Object> getUsers() {
      responseData = userService.getAll();
      return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable @Valid long id) {
      responseData = userService.getById(id);
      return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
  
    @PostMapping
    public ResponseEntity<Object> signUp(@RequestBody @Valid UserDto request) {
      responseData = userService.register(request);
      return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
  
    @PostMapping("/login")
    public ResponseEntity<Object> signIn(@RequestBody @Valid UserDto request) {
      responseData = userService.login(request);
      return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    // Update User
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable @Valid long id, @RequestBody UserDto request) {
      responseData = userService.updateUser(id, request);
      return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}

package net.javaSpring.springBoot.service;

import net.javaSpring.springBoot.model.dto.response.ResponseData;
import net.javaSpring.springBoot.model.dto.request.UserDto;

public interface UserService {
    ResponseData<Object> register(UserDto request);

    ResponseData<Object> login(UserDto request);
    
    ResponseData<Object> getAll();

    ResponseData<Object> getById(long id);

    // Update
    ResponseData<Object> updateUser(long id, UserDto request);
}
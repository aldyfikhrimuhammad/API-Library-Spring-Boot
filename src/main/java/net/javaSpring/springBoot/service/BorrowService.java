package net.javaSpring.springBoot.service;

import net.javaSpring.springBoot.model.dto.BorrowDto;
import net.javaSpring.springBoot.model.dto.ResponseData;

public interface BorrowService {

    // Method for add borrow data
    ResponseData<Object> addBorrowData(long id, BorrowDto request);

    // Method for add return data
    ResponseData<Object> addReturnData(long id);
}
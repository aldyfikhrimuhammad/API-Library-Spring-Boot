package net.javaSpring.springBoot.service;

import net.javaSpring.springBoot.exception.custom.CustomNotFound;
import net.javaSpring.springBoot.model.dto.request.BorrowDto;
import net.javaSpring.springBoot.model.dto.response.ResponseData;

public interface BorrowService2 {

    // Method for add borrow data
    ResponseData<Object> addBorrowData(long id, BorrowDto request) throws CustomNotFound, Exception;

    // MEthod for add return data
    ResponseData<Object> addReturnData(long id) throws CustomNotFound;
}

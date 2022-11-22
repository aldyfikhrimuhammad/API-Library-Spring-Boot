package net.javaSpring.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaSpring.springBoot.exception.custom.CustomNotFound;
import net.javaSpring.springBoot.model.dto.BorrowDto;
import net.javaSpring.springBoot.model.dto.ResponseData;
import net.javaSpring.springBoot.service.BorrowService;
import net.javaSpring.springBoot.service.BorrowService2;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    // Construct services and response data
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BorrowService2 borrowService2;
    private ResponseData<Object> responseData;

    // With exception handler
    @PostMapping("/borrow2/{id}")
    public ResponseEntity<Object> borrowException(@PathVariable Long id, @RequestBody BorrowDto request) throws CustomNotFound, Exception {
        responseData = borrowService2.addBorrowData(id, request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    // Without exception handler
    @PostMapping("/{id}")
    public ResponseEntity<Object> borrowBook(@PathVariable Long id, @RequestBody BorrowDto request) {
        responseData = borrowService.addBorrowData(id, request);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }

    // Return book controller
    @PostMapping("/return/{id}")
    public ResponseEntity<Object> returnBook(@PathVariable Long id) {
        responseData = borrowService.addReturnData(id);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}

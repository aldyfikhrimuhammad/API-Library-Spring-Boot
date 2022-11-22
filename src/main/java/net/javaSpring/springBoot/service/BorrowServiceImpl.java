package net.javaSpring.springBoot.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import net.javaSpring.springBoot.model.entity.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.javaSpring.springBoot.model.dto.request.BorrowDto;
import net.javaSpring.springBoot.model.dto.response.ResponseData;
import net.javaSpring.springBoot.model.entity.Book;
import net.javaSpring.springBoot.model.entity.User;
import net.javaSpring.springBoot.repository.BookRepository;
import net.javaSpring.springBoot.repository.BorrowRepository;
import net.javaSpring.springBoot.repository.UserRepository;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    // Construct repository
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    // Attribute
    private static LocalDateTime LocalDateTime = java.time.LocalDateTime.now();
    private Borrow borrow;
    private Book book;
    private User user;
    private ResponseData<Object> responseData;

    // Method for borrow book
    @Override
    public ResponseData<Object> addBorrowData(long id, BorrowDto request) {

        Optional<User> userOpt = userRepository.findById(id);

        // Conditional check
        if (userOpt.isPresent()) {
            // Set user with what userOpt get
            user = userOpt.get();
            // Instance object borrow
            borrow = new Borrow();
            // Search book from repository by title
			book = bookRepository.findByTitle(request.getTitle());
            // Set book and user
            borrow.setBook(book);
            borrow.setUser(user);
            // Save data to borrow repository
            borrowRepository.save(borrow);
            // Response data
            responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Borrowed Succesfully", borrow);
        } else {
            // Response data
            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "user Not Found", null);
        }
        return responseData;
    }

    // Method for return book
    @Override
    public ResponseData<Object> addReturnData(long id) {

        Optional<Borrow> borrowBookOpt = borrowRepository.findById(id);

        // Conditional check
        if (borrowBookOpt.isPresent()) {
            // Set borrow with what borrowOpt get
            borrow = borrowBookOpt.get();
            // Set borrow status to false and return date
            borrow.setBorrowed(false);
            borrow.setReturnedAt(LocalDateTime);
            // Savedata to borrow repository
            borrowRepository.save(borrow);
            // Response data
            responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Returned Succesfully", borrow);
        } else {
            // Resonse data
            responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "Borrow List Not Found", null);
        }
        return responseData;
    }
}
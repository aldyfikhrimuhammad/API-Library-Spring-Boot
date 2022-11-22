package net.javaSpring.springBoot.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.javaSpring.springBoot.exception.custom.CustomNotFound;
import net.javaSpring.springBoot.model.dto.BorrowDto;
import net.javaSpring.springBoot.model.dto.ResponseData;
import net.javaSpring.springBoot.model.entity.Book;
import net.javaSpring.springBoot.model.entity.Borrow;
import net.javaSpring.springBoot.model.entity.User;
import net.javaSpring.springBoot.repository.BookRepository;
import net.javaSpring.springBoot.repository.BorrowRepository;
import net.javaSpring.springBoot.repository.UserRepository;
import net.javaSpring.springBoot.validator.UserValidator;

@Service
@Transactional
public class BorrowServiceImpl2 implements BorrowService2 {

    // Construct repository
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;

    // Attribute
    private Borrow borrow;
    private Book book;
    private User user;
    private UserValidator userValidator;
    private ResponseData<Object> responseData;

    // Method for borrow book
    @Override
    public ResponseData<Object> addBorrowData(long id, BorrowDto request) throws CustomNotFound, Exception {

        Optional<User> userOpt = userRepository.findById(id);

        // Validate user not found
        userValidator.validateUserNotFound(userOpt);
        // Set user with what userOpt get
        user = userOpt.get();
        // Instance object borrow
        borrow = new Borrow();
        // Search book from repository by title
		book = bookRepository.findByTitle(request.getTitle());
        // Set book and user
        borrow.setBook(book);
        borrow.setUser(user);
        // Save to borrow repository
        borrowRepository.save(borrow);
        //Response data
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "borrowed successfully", borrow);
        return responseData;
    }

    @Override
    public ResponseData<Object> addReturnData(long id) throws CustomNotFound {
        return null;
    }
}

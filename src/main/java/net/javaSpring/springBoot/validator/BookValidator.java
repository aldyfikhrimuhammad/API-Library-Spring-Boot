package net.javaSpring.springBoot.validator;

import net.javaSpring.springBoot.exception.custom.CustomNotFound;
import net.javaSpring.springBoot.model.entity.Book;

import java.util.Optional;

public class BookValidator {

    public void validateBookNotFound(Optional<Book> bookFind) throws Exception {
        if (bookFind.isEmpty()) {
            throw new CustomNotFound("Book is not found");
        }
    }

//    public void validateInactiveBook(Book book) throws Exception {
//        if (book.getIsDeleted().equals(true)) {
//            throw new Exception("Book is inactive");
//        }
//    }

}

package net.javaSpring.springBoot.validator;

import java.util.Optional;

import net.javaSpring.springBoot.exception.custom.CustomBadRequest;
import net.javaSpring.springBoot.exception.custom.CustomNotFound;
import net.javaSpring.springBoot.model.entity.Borrow;

public class BorrowValidator {

    // Attribute
    Borrow borrow;

        public void validateBookBorrowed(Optional<Borrow> borrowOpt) throws Exception {
            if (borrowOpt.isPresent()) {
                borrow = borrowOpt.get();
                String message = "Book '" + borrow.getBook().getTitle() + "' borrowed";
                throw new CustomBadRequest(message);
            }
        }

//        public void validateBorrowNotFound(Optional<Borrow> borrowOpt) throws Exception {
//
//            if (borrowOpt.isEmpty()) {
//                throw new CustomNotFound("Borrow List Not Found");
//            }
//        }

}

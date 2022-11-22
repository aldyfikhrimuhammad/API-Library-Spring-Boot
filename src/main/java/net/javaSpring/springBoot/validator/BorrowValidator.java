package net.javaSpring.springBoot.validator;

import java.util.Optional;

import net.javaSpring.springBoot.exception.custom.CustomNotFound;
import net.javaSpring.springBoot.model.entity.Borrow;

public class BorrowValidator {
    public void validateBorrowNotFound(Optional<Borrow> borrowOpt) throws Exception {
        if (borrowOpt.isEmpty()){
            throw new CustomNotFound("Borrow List Not Found");
        }
    }
}

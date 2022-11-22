package net.javaSpring.springBoot.model.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BorrowDto {

    // What will user input
    private String title;
}
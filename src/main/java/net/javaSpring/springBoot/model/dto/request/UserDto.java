package net.javaSpring.springBoot.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8, max = 12, message = "Password must betweeb 8 - 12 characters.")
    private String password;
    private String firstName;
    private String lastName;
    @Size(min = 10, max = 15)
    private String phoneNumber;
}
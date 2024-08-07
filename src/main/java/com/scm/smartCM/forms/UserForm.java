package com.scm.smartCM.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Min 3 characters are required")
    private String name;

    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Min 6 characters are required")
    private String password;

    @NotBlank(message = "Abo n s required")
    private String about;
    
    @NotBlank(message = "Phone number is required")
    @Size(min = 8, max = 12, message = "Invalid Phone Number")
    private String phoneNumber;
}

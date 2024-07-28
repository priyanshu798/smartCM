package com.scm.smartCM.forms;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserForm {
    
    private String name;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;
}

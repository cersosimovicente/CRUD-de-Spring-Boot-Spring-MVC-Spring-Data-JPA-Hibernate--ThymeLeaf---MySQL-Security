package com.cersocode.employee_management_webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

package com.swayansu.springdata.blogapplication.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private int id;

    @NotEmpty
    private String name;

    @Email
    @Size(min = 5, message = "Username must be more than 5 characters")
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Not a strong password")
    private String password;
    private String about;
}

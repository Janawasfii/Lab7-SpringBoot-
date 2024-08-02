package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message="Id should not be empty")
    @Pattern(regexp = "^\\d{5}$")
    private String id;
    @NotEmpty(message="Name should not be empty")
    @Size(min=5,message="Name length should be more than 4")
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
    private String name;
    @NotNull(message="Age should not be null")
    @Positive(message="Age should be a positive number")
    private int age;
    @Email
    @NotEmpty(message="Email should not be empty")
    private String email;
    @NotEmpty(message="Phone number should not be empty")
    @Pattern(regexp = "^(\\+996)\\d{9}$")
    private String phoneNumber;
    @NotEmpty(message="address should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9\\s-]*$", message = "Address must contain only alphanumeric characters, spaces, and hyphens")
    private String address;
    @NotEmpty(message="Subject should not be empty")
    @Size(max=10,message= "Subject length should not be less than 10")
    private String subject;
    @NotEmpty(message="Level should not be empty")
    @Pattern(regexp ="^(Elemntry|Intermmediate|Advanced)$",message="You have only 3 options(Elemntry|Intermmediate|Advanced)")
    private String level;
    @NotNull(message="GPA should not be null")
    @Positive(message="GPA should be a positive number")
    @Max(5)
    private double gpa;
}

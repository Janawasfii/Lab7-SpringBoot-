package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Course {
    @NotEmpty(message="Course name should not be empty")
    @Size(min=6,message="Course name length should be more than 5")
    private String courseName;
    @NotEmpty(message="Course number should not be empty")
    @Pattern(regexp = "^\\d{3}$")
    private String courseNumber;
    @NotEmpty(message = "Course language should not be empty")
    @Pattern(regexp ="^(Arabic|English)$",message="You have only 2 options(Arabic or English)")
    private String courseLanguage;
    @NotEmpty(message = "Course description should not be empty")
    @Size(min=50)
    private String courseDescription;
    @NotNull(message="Course capacity should not be null")
    @Max(value = 6,message="Course capacity cannot be more than 5")
    @Positive(message="Course capacity should be a positive number")
    private int courseCapacity;
    @AssertFalse
    private boolean courseAvailability;
    @PastOrPresent()
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message="Course start date should not be empty")
    private LocalDate courseStartDate;
    @NotNull(message="Course fees should not be empty")
    @Positive(message="Course fee should be a positive number")
    private double courseFees;
}

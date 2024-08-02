package com.example.lab7.Controller;

import com.example.lab7.API.APIResponse;
import com.example.lab7.Model.Course;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")

public class CoursesController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getCourse() {
        return ResponseEntity.status(200).body(courseService.getCourse());
    }
    @PostMapping("/add")
   public ResponseEntity addCourse(@Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }courseService.addCourse(course);
        return ResponseEntity.status(200).body(new APIResponse("Successfully added course"));
    }
    @PutMapping("/update/{courseNumber}")
    public ResponseEntity updateCourse(@PathVariable String courseNumber,@Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = courseService.updateCourse(courseNumber,course);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated course"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Not found"));
    }
    @DeleteMapping("/delete/{courseNo}")
    public ResponseEntity deleteCourse(@PathVariable String courseNo) {
        boolean isDeleted = courseService.deleteCourse(courseNo);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully deleted course"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Not found"));
    }
    @PutMapping("/set/{courseN}")
    public ResponseEntity setAvailabilityCourse(@PathVariable String courseN) {
        return ResponseEntity.status(200).body(courseService.setAvailabilityCourse(courseN));
    }
    @PutMapping("/change/{courseNumbers}")
    public ResponseEntity setCapacity(@PathVariable String courseNumbers) {
        Course course = courseService.setCapacity(courseNumbers);
        if (course == null) {
            return ResponseEntity.status(400).body(new APIResponse("Not found"));
        }
        return ResponseEntity.status(200).body(courseService.setCapacity(courseNumbers));
    }
    @GetMapping("/geting/{language}")
    public ResponseEntity getCourseByLanguage(@PathVariable String language) {
//
        return ResponseEntity.status(200).body(courseService.getCourseByLanguage(language));
    }
    @PutMapping("/changeDate/{courseNumberr}")
    public ResponseEntity changeDateByCourseNumber(@PathVariable String courseNumberr) {
        Course course = courseService.changeDateByCourseNumber(courseNumberr);
        if (course == null) {
            return ResponseEntity.status(400).body(new APIResponse("Not found"));
        }
        return ResponseEntity.status(200).body(courseService.changeDateByCourseNumber(courseNumberr));
    }
    @PutMapping("/discount/{CourseNames}")
    public ResponseEntity discountCourseFeesByCourseName(@PathVariable String CourseNames){
        Course course = courseService.discountCourseFeesByCourseName(CourseNames);
        if (course == null) {
            return ResponseEntity.status(400).body(new APIResponse("Not found"));
        }
        return ResponseEntity.status(200).body(courseService.discountCourseFeesByCourseName(CourseNames));

    }



}

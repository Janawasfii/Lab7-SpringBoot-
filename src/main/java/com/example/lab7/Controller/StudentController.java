package com.example.lab7.Controller;

import com.example.lab7.API.APIResponse;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getStudent() {
        return ResponseEntity.status(200).body(studentService.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudents(student);
        return ResponseEntity.status(200).body(new APIResponse("Successfully added student"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id ,@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        boolean isUpdated = studentService.updateStudent(id, student);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully updated student"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Student not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully deleted student"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Student not found"));

    }
    @GetMapping("/search/{email}")
    public ResponseEntity getStudentByEmail(@PathVariable String email) {
        Student student = studentService.getStudentByEmail(email);
        if(student == null){
            return ResponseEntity.status(400).body(new APIResponse("Student not found"));
        }
        return ResponseEntity.status(200).body(studentService.getStudentByEmail(email));
    }
    @PutMapping("change/{gpa}")
    public ResponseEntity changeLevel(@PathVariable double gpa) {
        boolean isChanged = studentService.changeLevel(gpa);
        if (isChanged) {
            return ResponseEntity.status(200).body(new APIResponse("Successfully changed level"));
        }
        return ResponseEntity.status(400).body(new APIResponse("Student not found"));
    }
    @GetMapping("/gets/{subject}")
    public ResponseEntity getsSubject(@PathVariable String subject) {
        return ResponseEntity.status(200).body(studentService.getsSubject(subject));
    }
    @PutMapping("/set/{phone}")
    public ResponseEntity setAddressByPhone(@PathVariable String phone) {
        Student student =studentService.setAddressByPhone(phone);
       if(student == null){
                    return ResponseEntity.status(400).body(new APIResponse("Not found"));
        }
        return ResponseEntity.status(200).body(new APIResponse("Successfully set address"));
    }










    }




package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static javax.swing.UIManager.get;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<Student>();
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudents(Student student) {
        students.add(student);
    }
    public boolean updateStudent(String id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student getStudentByEmail(String email) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getEmail().equals(email)) {
                return students.get(i);}}
        return null;}

   public Boolean changeLevel(double gpa){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getGpa() == gpa) {
                if (students.get(i).getGpa() >= 5) {
                    students.get(i).setLevel("Advanced");
                }
                else if (students.get(i).getGpa() > 3 && students.get(i).getGpa() <= 4.4) {
                    students.get(i).setLevel("Intermediate");
                } else if (students.get(i).getGpa() <= 3) {
                    students.get(i).setLevel("Elementry");}}
        }
        return true;
    }
    public ArrayList<Student> getsSubject(String subject) {
        ArrayList<Student> student1= new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getSubject().equals(subject)) {
                student1.add(students.get(i));
            }
        }
        return student1;
    }
    public Student setAddressByPhone(String phone) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getPhoneNumber().equals(phone)){
                students.get(i).setPhoneNumber(phone);
                return students.get(i);
            }
        }return null;}



}





package com.example.lab7.Service;

import com.example.lab7.API.APIResponse;
import com.example.lab7.Model.Course;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service

public class CourseService {
    ArrayList<Course> courses = new ArrayList<Course>();

    public ArrayList<Course> getCourse() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean updateCourse(String courseNumber, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseNumber().equals(courseNumber)) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String courseNo) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseNumber().equals(courseNo)) {
                courses.remove(i);
            }
        }
        return true;
    }

    public Course setCapacity(String courseNumbers) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseNumber().equals(courseNumbers)) {
                courses.get(i).setCourseCapacity(2);
            }
            return courses.get(i);
        }
        return null;
    }

    public ArrayList<Course> setAvailabilityCourse(String courseN) {
        ArrayList<Course> course1 = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseN)) {
                if (courses.get(i).getCourseCapacity() < 5) {
                    courses.get(i).setCourseAvailability(true);
                }
            }
            course1.add(courses.get(i));
        }
        return course1;
    }

    public ArrayList<Course> getCourseByLanguage(String language) {
        ArrayList<Course> course1 = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseLanguage().equals(language)) {
                course1.add(courses.get(i));
            }
        }
        return course1;
    }

    public Course changeDateByCourseNumber(String courseNumberr) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseNumber().equals(courseNumberr)) {
                courses.get(i).setCourseStartDate(LocalDate.now());
            }
            return courses.get(i);
        }
        return null;
    }
    public Course discountCourseFeesByCourseName(String courseNames) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseNames)) {
                if (courses.get(i).getCourseFees() >= 500) {
                    courses.get(i).setCourseFees(courses.get(i).getCourseFees() - 100);
                }
            }
            return courses.get(i);
        }
        return null;
    }

}

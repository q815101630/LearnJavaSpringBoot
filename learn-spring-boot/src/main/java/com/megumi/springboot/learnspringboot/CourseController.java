package com.megumi.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "ECE408", "Volod"),
                new Course(2, "ECE409", "Alpha"),
                new Course(4, "CS483", "Alpha"),
                new Course(5, "CS100", "Alpha")

        );
    }

}

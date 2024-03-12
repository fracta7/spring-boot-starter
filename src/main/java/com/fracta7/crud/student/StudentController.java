package com.fracta7.crud.student;

import com.fracta7.crud.student.dto.StudentDto;
import com.fracta7.crud.student.dto.StudentResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(@PathVariable("student-id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> searchStudentByName(@PathVariable("student-name") String query) {
        return studentService.searchStudentByName(query);
    }

    @DeleteMapping("/students/{student-id}")
    public void deleteStudentById(@PathVariable("student-id") Long id) {
        studentService.deleteStudentById(id);
    }
}

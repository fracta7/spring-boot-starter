package com.fracta7.crud.presentation;

import com.fracta7.crud.data.dto.mapper.Mappers;
import com.fracta7.crud.data.dto.StudentDto;
import com.fracta7.crud.data.dto.StudentResponseDto;
import com.fracta7.crud.data.repository.StudentRepository;
import com.fracta7.crud.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDto studentDto) {
        var student = Mappers.toStudent(studentDto);
        var savedStudent = studentRepository.save(student);
        return Mappers.toStudentResponseDto(savedStudent);
    }

    @GetMapping("/students/{student-id}")
    public Student getById(@PathVariable("student-id") Long studentId) {
        return studentRepository.getReferenceById(studentId);
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> searchByName(@PathVariable("student-name") String query) {
        return studentRepository.findAllByFirstNameContaining(query);
    }

    @DeleteMapping("/students/{student-id}")
    public void delete(@PathVariable("student-id") Long id) {
        studentRepository.deleteById(id);
    }
}

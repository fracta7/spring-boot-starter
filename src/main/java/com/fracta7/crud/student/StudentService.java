package com.fracta7.crud.student;

import com.fracta7.crud.student.dto.StudentDto;
import com.fracta7.crud.student.dto.StudentMapper;
import com.fracta7.crud.student.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public StudentResponseDto getStudentById(Long studentId) {
        return studentMapper.toStudentResponseDto(studentRepository.getReferenceById(studentId));
    }

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public List<StudentResponseDto> searchStudentByName(String query) {
        return studentRepository.findAllByFirstNameContaining(query).stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}

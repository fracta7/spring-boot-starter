package com.fracta7.crud.data.dto.mapper;

import com.fracta7.crud.data.dto.SchoolDto;
import com.fracta7.crud.data.dto.StudentDto;
import com.fracta7.crud.data.dto.StudentResponseDto;
import com.fracta7.crud.model.School;
import com.fracta7.crud.model.Student;

public class Mappers {
    public static Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    public static StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static School toSchool(SchoolDto dto) {
        return new School(dto.name());
    }

    public static SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }
}

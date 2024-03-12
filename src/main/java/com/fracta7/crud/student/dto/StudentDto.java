package com.fracta7.crud.student.dto;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Long schoolId
){}

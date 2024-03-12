package com.fracta7.crud.data.dto;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Long schoolId
){}

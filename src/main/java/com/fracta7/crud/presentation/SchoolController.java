package com.fracta7.crud.presentation;

import com.fracta7.crud.data.dto.mapper.Mappers;
import com.fracta7.crud.data.dto.SchoolDto;
import com.fracta7.crud.data.repository.SchoolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto schoolDto) {
        var school = Mappers.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    @GetMapping("/schools")
    public List<SchoolDto> getAll() {
        return schoolRepository.findAll()
                .stream()
                .map(Mappers::toSchoolDto)
                .collect(Collectors.toList());
    }
}

package com.fracta7.crud.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.createSchool(schoolDto);
    }

    @GetMapping("/schools")
    public List<SchoolDto> getAll() {
        return schoolService.getAllSchools();
    }

    @DeleteMapping("/schools/{school_id}")
    public void deleteSchoolById(@PathVariable("school_id") Long schoolId){
        schoolService.deleteSchoolById(schoolId);
    }
}

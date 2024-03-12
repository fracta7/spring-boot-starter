package com.fracta7.crud.data.repository;

import com.fracta7.crud.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}

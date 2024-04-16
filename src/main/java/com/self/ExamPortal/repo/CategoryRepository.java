package com.self.ExamPortal.repo;

import com.self.ExamPortal.models.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

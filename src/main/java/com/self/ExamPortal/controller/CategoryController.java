package com.self.ExamPortal.controller;

import com.self.ExamPortal.models.exam.Category;
import com.self.ExamPortal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category newCategory = this.categoryService.addCategory(category);
        return ResponseEntity.ok(newCategory);
    }

    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category updatedCategory = this.categoryService.updateCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @GetMapping("/")
    public ResponseEntity<Set<Category>> getCategories() {
        Set<Category> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Category category = this.categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
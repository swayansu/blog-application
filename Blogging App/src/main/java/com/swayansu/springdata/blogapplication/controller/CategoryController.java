package com.swayansu.springdata.blogapplication.controller;

import com.swayansu.springdata.blogapplication.payloads.ApiResponse;
import com.swayansu.springdata.blogapplication.payloads.CategoryDto;
import com.swayansu.springdata.blogapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(this.categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateUser(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(this.categoryService.updateCategory(id, categoryDto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<>(this.categoryService.readCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id){
        return new ResponseEntity<>(this.categoryService.readCategoryById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id){
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok(new ApiResponse("Category Deleted Succesfully", true));
    }

}

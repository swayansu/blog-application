package com.swayansu.springdata.blogapplication.services;

import com.swayansu.springdata.blogapplication.entities.Category;
import com.swayansu.springdata.blogapplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);

    public List<CategoryDto> readCategory();

    public CategoryDto readCategoryById(Integer id);

    public CategoryDto updateCategory(Integer id, CategoryDto category);

    public void deleteCategory(Integer id);
}

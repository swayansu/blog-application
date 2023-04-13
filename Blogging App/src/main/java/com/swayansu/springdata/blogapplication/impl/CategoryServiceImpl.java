package com.swayansu.springdata.blogapplication.impl;

import com.swayansu.springdata.blogapplication.entities.Category;
import com.swayansu.springdata.blogapplication.exceptions.ResourceNotFoundException;
import com.swayansu.springdata.blogapplication.payloads.CategoryDto;
import com.swayansu.springdata.blogapplication.repositories.CategoryRepo;
import com.swayansu.springdata.blogapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return this.modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> readCategory() {
        List<Category> categoryDtoList = this.categoryRepo.findAll();

        return categoryDtoList.stream().map(category ->
                        this.modelMapper.map(category, CategoryDto.class))
                        .collect(Collectors.toList()
                );
    }

    @Override
    public CategoryDto readCategoryById(Integer id) {
        Category category = categoryRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Category_id", id)
        );
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(Integer id, CategoryDto category) {
        Category category1 = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Category_id", id));
        category1.setCategoryId(category.getCategoryId());
        category1.setCategoryTitle(category.getCategoryTitle());
        category1.setCategoryDescription(category.getCategoryDescription());

        return this.modelMapper.map(categoryRepo.save(category1), CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepo.delete(this.categoryRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Category_id", id)
        ));
    }
}

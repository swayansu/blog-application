package com.swayansu.springdata.blogapplication.repositories;

import com.swayansu.springdata.blogapplication.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}

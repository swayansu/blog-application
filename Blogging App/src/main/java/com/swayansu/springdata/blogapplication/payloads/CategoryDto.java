package com.swayansu.springdata.blogapplication.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
}

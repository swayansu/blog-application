package com.swayansu.springdata.blogapplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Table(name = "Categories_table")
public class Category {

    @Id
    @Column(name = "category_id")
    @SequenceGenerator(
            name = "category_sequence",
            allocationSize = 1,
            sequenceName = "category_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    private Integer categoryId;

    @Column(name = "title")
    private String categoryTitle;

    @Column(name =  "description")
    private String categoryDescription;

}

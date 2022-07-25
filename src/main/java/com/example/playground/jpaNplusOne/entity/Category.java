package com.example.playground.jpaNplusOne.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private List<Product> products = new ArrayList<>();

    @Builder
    public Category(String name, List<Product> products) {
        this.name = name;
        if (products != null){
            this.products = products;
        }
    }

    public void addProduct(Product product){
        this.products.add(product);
        product.updateCategory(this);
    }

}

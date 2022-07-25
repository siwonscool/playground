package com.example.playground.jpaNplusOne.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name="FK_PRODUCT_CATEGORY"))
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_STORE"))
    private Store store;

    @Builder
    public Product(String name, Category category, Store store) {
        this.name = name;
        this.category = category;
        this.store = store;
    }

    public void updateCategory(Category category) {
        this.category = category;
    }
}

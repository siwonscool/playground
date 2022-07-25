package com.example.playground.jpaNplusOne;

import static org.junit.Assert.*;

import com.example.playground.jpaNplusOne.entity.Category;
import com.example.playground.jpaNplusOne.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @After
    public void cleanAll(){
        categoryRepository.deleteAll();
    }

    @Before
    public void setup(){

        List<Category> categories = new ArrayList<>();
        System.out.println("=============초기세팅 시작=============");
        for (int i = 0; i < 10; i++) {
            Category category = Category.builder()
                .name("한식"+i)
                .build();
            category.addProduct(Product.builder()
                    .name("김치찌개"+i)
                .build());
            categories.add(category);
        }

        categoryRepository.saveAll(categories);
        System.out.println("=============초기세팅 끝=============");
    }

    @Test
    public void Category여러개를_조회하면_Product가_N1_쿼리가발생한다() throws Exception {
        //given
        List<String> productNames = categoryService.findAllProductNames();

        //then
        assertThat(productNames.size()).isEqualTo(10);
    }

}
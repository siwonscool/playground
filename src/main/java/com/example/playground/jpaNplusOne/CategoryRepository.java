package com.example.playground.jpaNplusOne;

import com.example.playground.jpaNplusOne.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c join fetch c.products")
    List<Category> findAllJoinFetch();
}

package com.example.playground.jpaNplusOne;

import com.example.playground.jpaNplusOne.entity.Category;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<String> findAllProductNames(){
        //return extractProductNames(categoryRepository.findAll());
        return extractProductNames(categoryRepository.findAllJoinFetch());
    }

    private List<String> extractProductNames(List<Category> categories) {
        log.info("=========상품이름 추출============");
        return categories.stream()
            .map(it -> it.getProducts().get(0).getName())
            .collect(Collectors.toList());
    }
}


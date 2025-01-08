package com.dev.stacks.config;

import com.dev.stacks.model.Category;
import com.dev.stacks.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        String[] predefinedCategories = {"Food", "Travel", "Entertainment", "Transport", "Utilities", "Education", "Health"};

        for(String categoryName: predefinedCategories) {
            if(categoryRepository.findByName(categoryName) == null) {
                Category category = new Category();
                category.setName(categoryName);
                categoryRepository.save(category);
            }
        }
    }
}

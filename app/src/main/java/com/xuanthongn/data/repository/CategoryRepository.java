package com.xuanthongn.data.repository;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.CategoryDao;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.entity.Category;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryRepository implements ICategoryRepository {
    private AppDatabase appDatabase;
    private final CategoryDao categoryDao;
    private final ModelMapper modelMapper;


    public CategoryRepository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
        categoryDao = appDatabase.categoryDao();
        modelMapper = new ModelMapper();
    }
    public CategoryRepository(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
        modelMapper = new ModelMapper();
    }
    @Override
    public CategoryDto findById(int id) {
        return null;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryDao.getAll();
        return categoryList.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());    }

    @Override
    public CategoryDto insert(CategoryDto input) {
        Category category = new Category(input.getName());
        categoryDao.insertAll(category);
        return input;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void delete(CategoryDto categoryDto) {

    }
    public int getCategoryIdByName(String categoryName) {
        Category category = categoryDao.getCategoryByName(categoryName);
        if (category != null) {
            return category.getCategoryId();
        } else {
            return 0; // Trả về 0 nếu không tìm thấy category tương ứng
        }
    }
}


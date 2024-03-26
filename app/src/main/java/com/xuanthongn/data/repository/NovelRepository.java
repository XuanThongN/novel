package com.xuanthongn.data.repository;

import androidx.lifecycle.LiveData;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.model.novel.NovelCreateDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;


import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class NovelRepository implements INovelRepository {
    private AppDatabase appDatabase;
    private final NovelDao novelDao;
    private final ModelMapper modelMapper;

    public NovelRepository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
        novelDao = appDatabase.novelDao();
        modelMapper = new ModelMapper();
    }

    @Override
    public NovelRecommendDto findById(int id) {
        return null;
    }

    @Override
    public List<NovelRecommendDto> findAll() {
        List<Novel> novels = novelDao.getAll();
        return novels.stream().map(x -> new NovelRecommendDto(x.novelId, x.name, x.imageUrl, null)).collect(Collectors.toList());
    }

    @Override
    public List<NovelRecommendDto> getNovelsWithCategory() {
        List<NovelWithCategory> novels = novelDao.getNovelsWithCategory();
        return novels.stream()
                .map(x -> new NovelRecommendDto(x.novel.novelId, x.novel.name, x.novel.imageUrl,x.category.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public NovelRecommendDto insert(NovelRecommendDto input) {
        Novel novel = new Novel(input.getName(),input.getImageUrl(),0);
        novelDao.insertAll(novel);
        return input;
    }


    public NovelCreateDto insertNovel(NovelCreateDto input) {
        Novel novel = new Novel(input.getName(),input.getImageUrl(),input.getCategory_id());
        novelDao.insertAll(novel);
        return input;

    }
    public LiveData<List<NovelWithCategory>> getAllNovelsWithCategories() {
        return novelDao.getAllNovelsWithCategories();
    }


    @Override
    public NovelRecommendDto update(NovelRecommendDto novelDto) {
        return null;
    }

    @Override
    public void delete(NovelRecommendDto novelDto) {
    }

    @Override
    public NovelRecommendDto findByName(String name) {
        return null;
    }
}


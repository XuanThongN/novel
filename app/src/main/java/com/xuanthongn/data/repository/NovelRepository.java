package com.xuanthongn.data.repository;

import androidx.lifecycle.LiveData;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.model.novel.NovelCreateDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.novel.NovelRecommendDto;


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
    public NovelDto findById(int id) {
        return null;
    }

    @Override
    public List<NovelDto> findAll() {
        List<Novel> novels = novelDao.getAll();
        return novels.stream().map(x -> new NovelDto(x.novelId, x.name, x.imageUrl, null)).collect(Collectors.toList());
    }

    @Override
    public List<NovelRecommendDto> getNovelsWithCategory() {
        List<NovelWithCategory> novels = novelDao.getNovelsWithCategory();
        return novels.stream()
                .map(x -> new NovelRecommendDto(x.novel.novelId, x.novel.name, x.novel.imageUrl,x.category.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<NovelRecommendDto> getNovelNewestImageUrls() {
        List<Novel> novels = novelDao.getNewestNovel();
        return novels.stream().map(x -> new NovelRecommendDto(x.novelId, x.imageUrl,x.name)).collect(Collectors.toList());
    }

    @Override
    public NovelDto insert(NovelDto input) {
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
    public NovelDto update(NovelDto novelDto) {
        return null;
    }

    @Override
    public void delete(NovelDto novelDto) {
    }

    @Override
    public List<NovelDto> findByName(String search) {
        List<NovelWithCategory> list = novelDao.searchNovelWithCategory(search);
        return list.stream().map( x ->
                new NovelDto(x.novel.novelId,x.novel.name,x.novel.imageUrl,x.category.name)
                ).collect(Collectors.toList());




}
}


package com.xuanthongn.data.repository;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.data.entity.Category;
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
    public NovelDto findById(int id) {
        return null;
    }

    @Override
    public List<NovelDto> findAll() {
        List<Novel> novels = novelDao.getAll();
        return novels.stream().map(x -> new NovelDto(x.novelId, x.name, x.imageUrl, null)).collect(Collectors.toList());
    }

    @Override
    public List<NovelDto> getNovelsWithCategory() {
        List<NovelWithCategory> novels = novelDao.getNovelsWithCategory();
        return novels.stream()
                .map(x -> new NovelDto(x.novel.novelId, x.novel.name, x.novel.imageUrl,null))
                .collect(Collectors.toList());
    }

    @Override
    public NovelDto insert(NovelDto input) {
        Novel novel = new Novel(input.getName(),input.getImageUrl(),0);
        novelDao.insertAll(novel);
        return input;
    }


    @Override
    public NovelDto update(NovelDto novelDto) {
        return null;
    }

    @Override
    public void delete(NovelDto novelDto) {
    }

    @Override
    public NovelDto findByName(String name) {
        return null;
    }
}


package com.xuanthongn.data.repository;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.data.entity.Novel;


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
        return null;
    }

    @Override
    public NovelDto insert(NovelDto novelDto) {
        Novel novel = modelMapper.map(novelDto, Novel.class);
        novelDao.insertAll(novel);
        return novelDto;
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


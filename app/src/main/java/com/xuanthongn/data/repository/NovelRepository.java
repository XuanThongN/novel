package com.xuanthongn.data.repository;

import androidx.lifecycle.LiveData;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.entity.User;
import com.xuanthongn.data.entity.relationship.NovelNameAndImageUrl;
import com.xuanthongn.data.model.novel.NovelCreateDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.user.UserDto;


import org.modelmapper.ModelMapper;

import java.util.ArrayList;
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
        NovelWithCategory novelWithCategory = novelDao.findNovelWithCategoryById(id);
        if (novelWithCategory != null && novelWithCategory.novel != null && novelWithCategory.category != null) {
            // Tạo đối tượng NovelDto và set các thuộc tính từ dữ liệu của Novel và Category
            NovelDto novelRecommendDto = new NovelDto();
            novelRecommendDto.setId(novelWithCategory.novel.novelId);
            novelRecommendDto.setName(novelWithCategory.novel.name);
            novelRecommendDto.setAuthor(novelWithCategory.novel.author);
            novelRecommendDto.setDescription(novelWithCategory.novel.description);
            novelRecommendDto.setImageUrl(novelWithCategory.novel.imageUrl);
            novelRecommendDto.setCategoryName(novelWithCategory.category.name);

            return novelRecommendDto;
        } else {
            return null;
        }
    }

    @Override
    public List<NovelDto> findAll() {
        List<Novel> novels = novelDao.getAll();
        return novels.stream().map(x -> new NovelDto(x.novelId, x.name, x.imageUrl, x.description, null)).collect(Collectors.toList());
    }

    @Override
    public List<NovelRecommendDto> getNovelsWithCategory() {
        List<NovelWithCategory> novels = novelDao.getNovelsWithCategory();
        return novels.stream()
                .map(x -> new NovelRecommendDto(x.novel.novelId, x.novel.name, x.novel.description, x.novel.imageUrl, x.category.getName(), x.category.getCategoryId(), 0))
                .collect(Collectors.toList());
    }

    @Override
    public List<NovelRecommendDto> getNovelNewestImageUrls() {
        List<Novel> novels = novelDao.getNewestNovel();
        return novels.stream().map(x -> new NovelRecommendDto(x.novelId, x.imageUrl, x.name)).collect(Collectors.toList());
    }

    @Override
    public NovelDto getByNameAndImageUrl(String name) {
        NovelNameAndImageUrl novel = novelDao.getByNameAndImageUrl(name);
        if (novel == null) {
            return null;
        }
        return modelMapper.map(novel, NovelDto.class);
    }

    @Override
    public NovelDto insert(NovelDto input) {
        Novel novel = new Novel(input.getName(), input.getImageUrl(), 0);
        novelDao.insertAll(novel);
        return input;
    }


    public NovelCreateDto insertNovel(NovelCreateDto input) {
        Novel novel = new Novel(input.getName(), input.getDescription(), input.getImageUrl(), input.getCategory_id());
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
        return list.stream().map(x ->
                new NovelDto(x.novel.novelId, x.novel.name, x.novel.imageUrl, x.category.name)
        ).collect(Collectors.toList());
    }

    @Override
    public List<NovelWithCategory> getNovelsWithCategoryAndDescription() {
        return novelDao.getNovelWithCategory();
    }

    @Override
    public List<NovelRecommendDto> findLatestNovelsByCategory(int categoryId) {

        List<NovelWithCategory> novels = novelDao.findLatestNovelsByCategory(categoryId);
        return novels.stream()
                .map(x -> new NovelRecommendDto(x.novel.novelId, x.novel.name, x.novel.description, x.novel.imageUrl, x.category.getName(), x.category.getCategoryId(),0))
                .collect(Collectors.toList());
    }

}


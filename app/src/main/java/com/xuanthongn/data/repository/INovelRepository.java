package com.xuanthongn.data.repository;

import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.user.UserDto;

import java.util.List;

public interface INovelRepository extends IBaseRepository<NovelDto> {
    List<NovelDto>  findByName(String name);
    List<NovelRecommendDto> getNovelsWithCategory();
    List<NovelRecommendDto> getNovelNewestImageUrls();
    NovelDto getByNameAndImageUrl(String name);
    List<NovelWithCategory> getNovelsWithCategoryAndDescription();
    List<NovelDto> findLatestNovelsByCategory(int categoryId);

}

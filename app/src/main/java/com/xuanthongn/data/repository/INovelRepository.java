package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;

public interface INovelRepository extends IBaseRepository<NovelRecommendDto> {
    List<NovelRecommendDto> getNovelsWithCategory();
    NovelRecommendDto findByName(String name);
    List<NovelRecommendDto> getNovelNewestImageUrls();
}

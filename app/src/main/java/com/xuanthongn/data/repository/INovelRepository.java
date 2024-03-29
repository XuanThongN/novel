package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;

import java.util.List;

public interface INovelRepository extends IBaseRepository<NovelDto> {
    List<NovelDto>  findByName(String name);
    List<NovelRecommendDto> getNovelsWithCategory();
    List<NovelRecommendDto> getNovelNewestImageUrls();
}

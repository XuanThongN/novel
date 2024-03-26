package com.xuanthongn.data.repository;

import com.xuanthongn.data.dto.NovelDto;

import java.util.List;

public interface INovelRepository extends IBaseRepository<NovelDto> {
    List<NovelDto> getNovelsWithCategory();
    NovelDto findByName(String name);
}

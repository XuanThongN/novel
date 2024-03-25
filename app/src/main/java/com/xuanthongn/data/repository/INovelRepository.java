package com.xuanthongn.data.repository;

import com.xuanthongn.data.dto.NovelDto;

public interface INovelRepository extends IBaseRepository<NovelDto> {
    NovelDto findByName(String name);
}

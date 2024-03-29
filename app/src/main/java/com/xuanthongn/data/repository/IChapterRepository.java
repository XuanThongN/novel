package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.chapter.ChapterDto;

import java.util.List;

public interface IChapterRepository extends IBaseRepository<ChapterDto>{
    ChapterDto getChapterByNovelID(int novel_id);
    List<ChapterDto> getAllChaptersByNovelId(int novel_id);
    List<ChapterDto> getAllChaptersByNovelNew(int novel_id);

}

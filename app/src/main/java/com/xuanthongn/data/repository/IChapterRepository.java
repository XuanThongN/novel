package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.chapter.ChapterDto;

import java.util.List;

public interface IChapterRepository extends IBaseRepository<ChapterDto>{
    List<ChapterDto>  getChapterByNovelID(int novel_id);
    List<ChapterDto> getAllChaptersByNovelId(int novel_id);
    List<ChapterDto> getNewestChaptersByNovelId(int novel_id);
    int countChaptersByNovelId(int novelId);


}

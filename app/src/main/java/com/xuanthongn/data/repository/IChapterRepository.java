package com.xuanthongn.data.repository;

import com.xuanthongn.data.model.chapter.ChapterDto;

public interface IChapterRepository extends IBaseRepository<ChapterDto>{
    ChapterDto getChapterByNovelID(int novel_id);

}

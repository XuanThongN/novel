package com.xuanthongn.data.repository;


import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.ChapterDao;
import com.xuanthongn.data.entity.Category;
import com.xuanthongn.data.entity.Chapter;
import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.relationship.ChapterWithNovel;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;


import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ChapterRepository implements IChapterRepository {
    private AppDatabase appDatabase;
    private final ChapterDao chapterDao;
    private final ModelMapper modelMapper;
    public ChapterRepository(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
        chapterDao = appDatabase.chapterDao();
        modelMapper = new ModelMapper();
    }

    @Override
    public ChapterDto findById(int id) {
        return null;
    }

    @Override
    public List<ChapterDto> findAll() {
        return null;
    }


    @Override
    public ChapterDto insert(ChapterDto input) {
        Chapter chapter = new Chapter(input.getChapterId(), input.getName(),input.getContent(), input.getNovel_id());
        chapterDao.insertAll(chapter);
        return input;
    }

    @Override
    public ChapterDto update(ChapterDto chapterDto) {
        return null;
    }

    @Override
    public void delete(ChapterDto chapterDto) {

    }


    @Override
    public List<ChapterDto> getChapterByNovelID(int novel_id) {
        List<Chapter> chapters = chapterDao.getChaptersByNovelID(novel_id);
        List<ChapterDto> chapterDtos = new ArrayList<>();
        for (Chapter chapter : chapters) {
            chapterDtos.add(new ChapterDto(chapter.chapterId, chapter.name, chapter.content, chapter.novel_id));
        }
        return chapterDtos;
    }


    @Override
    public List<ChapterDto> getAllChaptersByNovelId(int novel_id) {
        List<ChapterWithNovel> chaptersWithNovel = chapterDao.getNovelWithChapters(novel_id);
        List<ChapterDto> chapterDtos = new ArrayList<>();
        for (ChapterWithNovel item : chaptersWithNovel) {
            ChapterDto chapterDto = new ChapterDto();
            chapterDto.setName(item.chapter.name);
            chapterDto.setContent(item.chapter.content);
            chapterDtos.add(chapterDto);
        }
        return chapterDtos;
    }

    @Override
    public List<ChapterDto> getNewestChaptersByNovelId(int novel_id) {
        List<ChapterWithNovel> chaptersWithNovel = chapterDao.getNovelWithChaptersNew(novel_id);
        List<ChapterDto> chapterDtos = new ArrayList<>();
        for (ChapterWithNovel item : chaptersWithNovel) {
            ChapterDto chapterDto = new ChapterDto();
            chapterDto.setName(item.chapter.name);
            chapterDto.setContent(item.chapter.content);
            chapterDtos.add(chapterDto);
        }
        return chapterDtos;
    }

    @Override
    public int countChaptersByNovelId(int novelId) {
        return chapterDao.countChaptersByNovelId(novelId);
    }


}

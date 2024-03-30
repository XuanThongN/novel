package com.xuanthongn.ui.presenter;


import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.data.repository.ChapterRepository;
import com.xuanthongn.ui.constract.IDetailChapterConstract;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.util.Constants;

import java.util.List;

public class ChapterDetailPresenter implements IDetailChapterConstract.IPresenter {
    private IDetailChapterConstract.IView mView;
    private AppDatabase db;
    ChapterRepository chapterRepository;
    private Context context;

    public ChapterDetailPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        chapterRepository = new ChapterRepository(db);
    }


    @Override
    public void setView(IDetailChapterConstract.IView view) {
        mView = view;
    }

    @Override
    public void getDetailChapter(int novel_id) {
        List<ChapterDto> chapterDto = chapterRepository.getChapterByNovelID(novel_id);
        mView.showContent(chapterDto);
    }

}


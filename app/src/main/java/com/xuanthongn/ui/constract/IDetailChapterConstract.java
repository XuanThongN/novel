package com.xuanthongn.ui.constract;

import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;

import java.util.List;

public interface IDetailChapterConstract {
    interface IView {
        void showContent(List<ChapterDto> chapterDtos);
        void displayError(String message);
    }

    interface IPresenter {
        void setView(IView view);
        void getDetailChapter(int novel_id);

    }
}

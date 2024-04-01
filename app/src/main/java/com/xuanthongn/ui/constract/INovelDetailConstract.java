package com.xuanthongn.ui.constract;

import com.xuanthongn.data.entity.relationship.NovelWithCategory;
import com.xuanthongn.data.model.Chapter;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;

import java.util.List;

public interface INovelDetailConstract {
    interface IView {
        void displayError(String errorMessage);

        void showLatestNovels(List<NovelRecommendDto> novels);

        void showChapters(List<ChapterDto> chapters);

        void showChaptersNew(List<ChapterDto> chapters);

        void showTotalChapterCount(int count);

        void showComments(List<CommentsResponseModel> result);
        void addCommentToList(CommentsResponseModel result);
    }

    interface IPresenter {
        void setView(IView view);

        void getLatestNovelsByCategory(int categoryId);

        void getAllChaptersByNovelId(int novelId);

        void getAllChaptersByNovelNew(int novelId);

        void getTotalChapterCount(int novelId);

        void getAllComments(int novelId);
        void postComment(int novelId, String content, int userId);

    }
}

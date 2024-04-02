package com.xuanthongn.ui.presenter;


import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.response_model.comment.CommentRequestModel;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;
import com.xuanthongn.data.model.response_model.novel.NovelResponse;
import com.xuanthongn.data.model.response_model.user.ChapterResponseModel;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.data.repository.ChapterRepository;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.util.ChapterTask;
import com.xuanthongn.util.CommentTask;
import com.xuanthongn.util.Constants;
import com.xuanthongn.util.NetworkUtils;
import com.xuanthongn.util.NovelTask;

import java.util.List;
import java.util.stream.Collectors;

public class NovelDetailPresenter implements INovelDetailConstract.IPresenter {
    private INovelDetailConstract.IView mView;

    CategoryRepository mCategoryRepository;
    AppDatabase db;
    NovelRepository mNovelRepository;
    ChapterRepository mChapterResponsitory;


    private Context context;
    private CommentTask commentTask;
    private ChapterTask chapterTask;
    private NovelTask novelTask;

    public NovelDetailPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        mCategoryRepository = new CategoryRepository(db);
        mNovelRepository = new NovelRepository(db);
        mChapterResponsitory = new ChapterRepository(db);
        commentTask = new CommentTask();
        chapterTask = new ChapterTask();
        novelTask = new NovelTask();
    }

    @Override
    public void setView(INovelDetailConstract.IView view) {
        mView = view;
    }

    @Override
    public void getLatestNovelsByCategory(int novelId, int categoryId) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            novelTask.getRelativeNovelsByCategoryId(new Callback<List<NovelResponse>>() {
                @Override
                public void returnResult(List<NovelResponse> result) {
                    if (result != null && result.size() > 0) {
                        List<NovelRecommendDto> novels = result.stream().map(x -> {
                            NovelRecommendDto newNovelDto = new NovelRecommendDto(x.getNovelId(), x.getTitle(), x.getAuthor(), x.getDescription(), x.getImage_url(), x.getCategory().getName());
                            newNovelDto.setCategoryId(x.getCategory().getId());
                            newNovelDto.setChapters_count(x.getChapters_count());
                            return newNovelDto;
                        }).collect(Collectors.toList());
                        mView.showLatestNovels(novels);
                    }
                }

                @Override
                public void returnError(String message) {
                    mView.displayError(message);
                }
            }, novelId, categoryId);
        } else {
            List<NovelRecommendDto> latestNovels = mNovelRepository.findLatestNovelsByCategory(categoryId);
            mView.showLatestNovels(latestNovels);
        }
    }

    @Override
    public void getAllChaptersByNovelId(int novelId) {
//        Kiem tra ket noi mang
        if (NetworkUtils.isNetworkAvailable(context)) {
            chapterTask.getByNovel(new Callback<List<ChapterResponseModel>>() {
                @Override
                public void returnResult(List<ChapterResponseModel> result) {
//                    Chuyển đổi dữ liệu từ ChapterResponseModel sang ChapterDto
                    if (result != null && result.size() > 0) {
                        List<ChapterDto> chapters = result.stream().map(x -> new ChapterDto(x.getChapterId(), x.getTitle(), x.getContent(), x.getNovelId())).collect(Collectors.toList());
                        mView.showChapters(chapters);
                    }
                }

                @Override
                public void returnError(String message) {
                    mView.displayError(message);
                }
            }, novelId);
        } else {
            List<ChapterDto> latestNovels = mChapterResponsitory.getAllChaptersByNovelId(novelId);
            mView.showChapters(latestNovels);
        }

    }

    @Override
    public void getNewestChaptersByNovelId(int novelId) {
        //        Kiem tra ket noi mang
        if (NetworkUtils.isNetworkAvailable(context)) {
            chapterTask.getNewestByNovel(new Callback<List<ChapterResponseModel>>() {
                @Override
                public void returnResult(List<ChapterResponseModel> result) {
//                    Chuyển đổi dữ liệu từ ChapterResponseModel sang ChapterDto
                    if (result != null && result.size() > 0) {
                        List<ChapterDto> chapters = result.stream().map(x -> new ChapterDto(x.getChapterId(), x.getTitle(), x.getContent(), x.getNovelId())).collect(Collectors.toList());
                        mView.showChaptersNew(chapters);
                    }
                }

                @Override
                public void returnError(String message) {
                    mView.displayError(message);

                }
            }, novelId);
        } else {
            List<ChapterDto> latestNovels = mChapterResponsitory.getNewestChaptersByNovelId(novelId);
//        Đổ cács dữ liệu ra view xử lý
            mView.showChaptersNew(latestNovels);
        }
    }

    @Override
    public void getTotalChapterCount(int chapterCount) {
//        int totalChapterCount = mChapterResponsitory.countChaptersByNovelId(novelId);
        mView.showTotalChapterCount(chapterCount);
    }

    @Override
    public void getAllComments(int novelId) {
        commentTask.getCommentsByNovelId(new Callback<List<CommentsResponseModel>>() {
            @Override
            public void returnResult(List<CommentsResponseModel> result) {
                mView.showComments(result);
            }

            @Override
            public void returnError(String message) {
                mView.displayError(message);
            }
        }, novelId);
    }

    @Override
    public void postComment(int novelId, String content, int userId) {
        CommentRequestModel commentRequestModel = new CommentRequestModel(novelId, content, userId);
        commentTask.postComment(new Callback<CommentsResponseModel>() {
            @Override
            public void returnResult(CommentsResponseModel result) {
                mView.addCommentToList(result);
            }

            @Override
            public void returnError(String message) {
                mView.displayError(message);
            }
        }, commentRequestModel);


    }

}

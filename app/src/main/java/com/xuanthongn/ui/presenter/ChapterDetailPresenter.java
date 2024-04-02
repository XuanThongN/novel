package com.xuanthongn.ui.presenter;


import android.content.Context;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.response_model.user.ChapterResponseModel;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.data.repository.ChapterRepository;
import com.xuanthongn.ui.constract.IDetailChapterConstract;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.util.ChapterTask;
import com.xuanthongn.util.Constants;
import com.xuanthongn.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChapterDetailPresenter implements IDetailChapterConstract.IPresenter {
    private IDetailChapterConstract.IView mView;
    private AppDatabase db;
    ChapterRepository chapterRepository;
    private Context context;

    ChapterTask chapterTask;

    public ChapterDetailPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        chapterRepository = new ChapterRepository(db);
        chapterTask = new ChapterTask();
    }


    @Override
    public void setView(IDetailChapterConstract.IView view) {
        mView = view;
    }

    @Override
    public void getDetailChapter(int novel_id) {
        List<ChapterDto> chapters = new ArrayList<>();
//        Kiểm tra kết nối mạng
//        Nếu có mạng thì lấy dữ liệu từ API
        if (NetworkUtils.isNetworkAvailable(context)) {
            chapterTask.getByNovel(new Callback<List<ChapterResponseModel>>() {
                @Override
                public void returnResult(List<ChapterResponseModel> result) {
//                    Chuyển đổi dữ liệu từ ChapterResponseModel sang ChapterDto
                    if (result != null && result.size() > 0) {
                        List<ChapterDto> chapters = result.stream().map(x -> new ChapterDto(x.getChapterId(), x.getTitle(), x.getContent(), x.getNovelId())).collect(Collectors.toList());
                        mView.showContent(chapters);
                    }
                }

                @Override
                public void returnError(String message) {
                    mView.displayError(message);
                }
            }, novel_id);
//            mView.showContent(chapters);
        } else {
//            Nếu không có mạng thì lấy dữ liệu từ database
            chapters = chapterRepository.getChapterByNovelID(novel_id);
            mView.showContent(chapters);
        }
    }


}


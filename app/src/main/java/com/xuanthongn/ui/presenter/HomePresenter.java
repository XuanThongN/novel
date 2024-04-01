package com.xuanthongn.ui.presenter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.ui.constract.IHomeConstract;
import com.xuanthongn.util.Constants;
import com.xuanthongn.util.NovelTask;

import java.util.List;
import java.util.stream.Collectors;

public class HomePresenter implements IHomeConstract.IPresenter {
    private IHomeConstract.IView mView;
    private AppDatabase db;
    NovelRepository novelRepository;
    private Context context;
    private NovelTask novelTask;


    public HomePresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        novelRepository = new NovelRepository(db);
        novelTask = new NovelTask();

    }

    @Override
    public void setView(IHomeConstract.IView view) {
        mView = view;
    }

    @Override
    public void getLoginInfo() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(Constants.KEY_NAME, null);
        mView.setLoginInfo(name);
    }

    @Override
    public boolean getStoredLoginStatus() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getBoolean(Constants.KEY_LOGIN_STATUS, false);

    }

    @Override
    public void getNovelRecommend() {
        //V1. Gọi hàm getNovelsWithCategory() từ NovelRepository lấy data từ room database
//        List<NovelRecommendDto> recommendations = novelRepository.getNovelsWithCategory();
//        mView.setNovelRecommendToView(recommendations);

        //V2. Gọi hàm getNovel() từ NovelTask lấy data từ api
        novelTask.getNovels(new Callback<NovelsResponseModel>() {
            @Override
            public void returnResult(NovelsResponseModel novelResponseModels) {
                List<NovelRecommendDto> recommendations = novelResponseModels.getResults().stream().map(novel -> new NovelRecommendDto(novel.getNovelId(), novel.getImage_url(), novel.getTitle(), novel.getCategory().getName(), novel.getCategory().getId())).collect(Collectors.toList());
                mView.setNovelRecommendToView(recommendations);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }

    @Override
    public void getNovelNewest() {
        novelTask.getNovels(new Callback<NovelsResponseModel>() {
            @Override
            public void returnResult(NovelsResponseModel novelResponseModels) {
                List<NovelRecommendDto> recommendations = novelResponseModels.getResults().stream().map(novel -> new NovelRecommendDto(novel.getNovelId(), novel.getImage_url(), novel.getTitle(), novel.getCategory().getName(), novel.getCategory().getId())).collect(Collectors.toList());
                recommendations.stream().sorted(
                        (n1, n2) -> n2.getId() - n1.getId()).collect(Collectors.toList()).subList(0, 4);
                mView.setNovelNewestToView(recommendations);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }
}


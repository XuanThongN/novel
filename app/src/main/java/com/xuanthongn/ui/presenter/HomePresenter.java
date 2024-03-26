package com.xuanthongn.ui.presenter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.NovelDao;
import com.xuanthongn.data.dao.ProductDao;
import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.data.entity.Novel;
import com.xuanthongn.data.entity.Product;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.data.repository.UserRepository;
import com.xuanthongn.ui.constract.IHomeConstract;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.util.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class HomePresenter implements IHomeConstract.IPresenter {
    private IHomeConstract.IView mView;
    private AppDatabase db;
    NovelRepository novelRepository;
    private Context context;

    public HomePresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        this.context = context;
        novelRepository = new NovelRepository(db);
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
        List<NovelRecommendDto> recommendations = novelRepository.getNovelsWithCategory().stream()
                .map(x -> new NovelRecommendDto(x.getNovelId(), x.getName(), x.getImageUrl(), x.getCategory_id()))
                .collect(Collectors.toList());

        mView.setNovelRecommendToView(recommendations);
    }
}


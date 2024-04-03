package com.xuanthongn.ui.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.api.callback.Callback;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.response_model.novel.NovelsResponseModel;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.ui.constract.ISearchConstract;
import com.xuanthongn.util.Constants;
import com.xuanthongn.util.NetworkUtils;
import com.xuanthongn.util.NovelTask;

import java.util.List;
import java.util.stream.Collectors;

public class SearchNovelPresenter implements ISearchConstract.IPresenter {
    private ISearchConstract.IView mView;
    private AppDatabase db;

    private Context context;
    private NovelRepository novelRepository;
    private NovelTask novelTask;

    public SearchNovelPresenter(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        novelRepository = new NovelRepository(db);
        novelTask = new NovelTask();
    }


    @Override
    public void setView(ISearchConstract.IView view) {
        mView = view;
    }

    @Override
    public void searchNovel(String search) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            novelTask.searchNovels(new Callback<NovelsResponseModel>() {
                @Override
                public void returnResult(NovelsResponseModel novelsResponseModel) {
                    List<NovelDto> novelDtos = novelsResponseModel.getResults().stream().map(novel -> new NovelDto(novel.getNovelId(), novel.getTitle(), novel.getImage_url(), novel.getDescription(), novel.getCategory().getName())).collect(Collectors.toList());
                    // Update UI on the main thread using a Runnable posted to the Handler
                    mView.showResults(novelDtos);
                }

                @Override
                public void returnError(String message) {
                    mView.showError(message);
                }
            }, search);
            // Update UI on the main thread using a Runnable posted to the Handler
            mView.showResults(null);
        } else {

            // Perform the query in background thread
            List<NovelDto> novels = novelRepository.findAll();
            // Update UI on the main thread using a Runnable posted to the Handler
            mView.showResults(novels);
        }
    }
}

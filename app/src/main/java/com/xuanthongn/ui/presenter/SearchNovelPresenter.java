package com.xuanthongn.ui.presenter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.room.Room;

import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.dao.ProductDao;
import com.xuanthongn.data.dto.NovelDto;
import com.xuanthongn.data.entity.Product;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.ui.constract.IHomeConstract;
import com.xuanthongn.ui.constract.ISearchConstract;
import com.xuanthongn.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class SearchNovelPresenter implements ISearchConstract.IPresenter {
    private ISearchConstract.IView mView;
    private AppDatabase db;

    private Context context;
    private NovelRepository novelRepository;
    public SearchNovelPresenter(Context context) {
        this.context = context;
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        novelRepository = new NovelRepository(db);
    }


    @Override
    public void setView(ISearchConstract.IView view) {
        mView = view;
    }

    @Override
    public void searchNovel(String search) {
        // Create a Handler for safe UI updates on the main thread
        final Handler handler = new Handler(Looper.getMainLooper());

        // Launch a new thread for background operations
        new Thread(() -> {
            try {
                // Perform the query in background thread
                List<NovelDto> novels = novelRepository.findAll();

                // Update UI on the main thread using a Runnable posted to the Handler
                handler.post(() -> mView.showResults(novels));
            } catch (Exception e) {
                // Handle potential exceptions during data access
                Log.e("FindAllNovelsError", "Error fetching all novels", e);
            }
        }).start();
    }
}

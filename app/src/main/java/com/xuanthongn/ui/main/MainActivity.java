package com.xuanthongn.ui.main;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xuanthongn.R;
import com.xuanthongn.base.BaseActivity;
import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.category.CategoryDto;
import com.xuanthongn.data.model.novel.NovelCreateDto;
import com.xuanthongn.data.model.CategoryItem;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.data.repository.NovelRepository;
import com.xuanthongn.data.repository.UserRepository;
import com.xuanthongn.ui.constract.IMainConstract;
import com.xuanthongn.ui.fragment.home.AccountFragment;
import com.xuanthongn.ui.fragment.home.AccountLogoutFragment;
import com.xuanthongn.ui.fragment.home.BookmarkFragment;
import com.xuanthongn.ui.fragment.home.HomeFragment;
import com.xuanthongn.ui.presenter.MainPresenter;
import com.xuanthongn.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IMainConstract.IView {
    private RecyclerView mRvHotProduct;
    private IMainConstract.IPresenter mPresenter;
    private List<CategoryItem> categories;
    private GridView categoryGrid;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();
        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);
        // Trong phần thêm dữ liệu:
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
        NovelRepository novelRepository = new NovelRepository(db);

        List<NovelCreateDto> novelList = new ArrayList<>();
        novelList.add(new NovelCreateDto(1,"Truyện về thần thoại Hy Lạp", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",1 ));
        novelList.add(new NovelCreateDto(2,"Truyện về tình yêu", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", 2));
        novelList.add(new NovelCreateDto(3,"Truyện về siêu nhân", "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", 1));

        for (NovelCreateDto novelDto : novelList) {
            novelRepository.insertNovel(novelDto);
        }


        //Insert new user to room database
//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
//        UserRepository userRepository = new UserRepository(db);
//        UserDto user = new UserDto();
//        user.setEmail("admin123");
//        user.setPassword("admin");
//        userRepository.insert(user);


        //Insert new user to room database
//        CategoryRepository categoryRepository = new CategoryRepository(db);
//        List<CategoryDto> novelList = new ArrayList<>();
//        novelList.add(new CategoryDto(1, "Thể loại 1"));
//        novelList.add(new CategoryDto(2, "Thể loại 2"));
//        for (CategoryDto novelDto : novelList) {
//            categoryRepository.insert(novelDto);
//        }


    }

    private void initGUI() {

//        mRvHotProduct = findViewById(R.id.rv_hot_product);
        //Bottom Navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment(); // Replace with HomeFragment.class for older versions
                    break;
                case R.id.navigation_bookmark:
                    selectedFragment = new BookmarkFragment(); // Replace with BookmarksFragment.class for older versions
                    break;
                case R.id.navigation_account:
                    if (mPresenter.getStoredLoginStatus()) {
                        selectedFragment = new AccountFragment();
                    } else {
                        selectedFragment = new AccountLogoutFragment(); // Replace with AccountFragment.class for older versions
                    }
                    break;
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }


}
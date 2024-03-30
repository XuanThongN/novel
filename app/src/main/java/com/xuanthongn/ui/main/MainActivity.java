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
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelCreateDto;
import com.xuanthongn.data.model.CategoryItem;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.user.UserDto;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.data.repository.ChapterRepository;
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


//         Trong phần thêm dữ liệu:
//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
//        NovelRepository novelRepository = new NovelRepository(db);
//        ChapterRepository chapterRepository = new ChapterRepository(db);
//
//
//        CategoryRepository categoryRepository = new CategoryRepository(db);
//        List<CategoryDto> novelLists = new ArrayList<>();
//        novelLists.add(new CategoryDto(1, "Thể loại 1"));
//        novelLists.add(new CategoryDto(2, "Thể loại 2"));
//        novelLists.add(new CategoryDto(3, "Thể loại 3"));
//        for (CategoryDto novelDto : novelLists) {
//            categoryRepository.insert(novelDto);
//        }
//
//        List<NovelCreateDto> novelList = new ArrayList<>();
//        novelList.add(new NovelCreateDto("Truyện về 5 anh coder thần thoại Hy Lạp", "A lô, a lô, hôm nay chúng ta tìm hiểu luật an toàn giao thông trên đoạn đường thẳng. Kiến Càng làm ô tô, Kiến Vống làm nông dân, Kiến Lửa làm xe máy, Kiến Đen làm xe đạp, còn Kiến Gió, Kiến Hôi làm học sinh, cuối cùng Kiến Kim sẽ làm em bé mẫu giáo.", "https://cdn.popsww.com/blog/sites/2/2022/03/truyen-tranh-ve-dep_Website.jpg", 1));
//        novelList.add(new NovelCreateDto("Câu truyện Kiến thi an toàn giao thông", "A lô, a lô, hôm nay chúng ta tìm hiểu luật an toàn giao thông trên đoạn đường thẳng. Kiến Càng làm ô tô, Kiến Vống làm nông dân, Kiến Lửa làm xe máy, Kiến Đen làm xe đạp, còn Kiến Gió, Kiến Hôi làm học sinh, cuối cùng Kiến Kim sẽ làm em bé mẫu giáo.", "https://i.pinimg.com/564x/cc/bc/f5/ccbcf5b3441d3c53a45a3348c7aac57c.jpg", 3));
//        novelList.add(new NovelCreateDto("Truyện về tình yêu", "A lô, a lô, hôm nay chúng ta tìm hiểu luật an toàn giao thông trên đoạn đường thẳng. Kiến Càng làm ô tô, Kiến Vống làm nông dân, Kiến Lửa làm xe máy, Kiến Đen làm xe đạp, còn Kiến Gió, Kiến Hôi làm học sinh, cuối cùng Kiến Kim sẽ làm em bé mẫu giáo.", "https://i.pinimg.com/564x/19/79/33/197933ac72530650a77ca14b732bc39e.jpg", 1));
//        novelList.add(new NovelCreateDto("Truyện về siêu nhân", "A lô, a lô, hôm nay chúng ta tìm hiểu luật an toàn giao thông trên đoạn đường thẳng. Kiến Càng làm ô tô, Kiến Vống làm nông dân, Kiến Lửa làm xe máy, Kiến Đen làm xe đạp, còn Kiến Gió, Kiến Hôi làm học sinh, cuối cùng Kiến Kim sẽ làm em bé mẫu giáo.", "https://ae04.alicdn.com/kf/H8c382d20f70a450e8879b936759171d8C.jpg", 3));
//        novelList.add(new NovelCreateDto("Truyện về đời sống", "A lô, a lô, hôm nay chúng ta tìm hiểu luật an toàn giao thông trên đoạn đường thẳng. Kiến Càng làm ô tô, Kiến Vống làm nông dân, Kiến Lửa làm xe máy, Kiến Đen làm xe đạp, còn Kiến Gió, Kiến Hôi làm học sinh, cuối cùng Kiến Kim sẽ làm em bé mẫu giáo.", "https://ae04.alicdn.com/kf/Hce5b99f5d1cd4cb99ac970e8b8e61646G.jpg", 1));
//        novelList.add(new NovelCreateDto("Truyện về 5 anh em siêu nhân", "A lô, a lô, hôm nay chúng ta tìm hiểu luật an toàn giao thông trên đoạn đường thẳng. Kiến Càng làm ô tô, Kiến Vống làm nông dân, Kiến Lửa làm xe máy, Kiến Đen làm xe đạp, còn Kiến Gió, Kiến Hôi làm học sinh, cuối cùng Kiến Kim sẽ làm em bé mẫu giáo.", "https://ae01.alicdn.com/kf/S516967971bff4dfeb8ab12421cd749d5o.jpg", 2));
//
//        for (NovelCreateDto novelDto : novelList) {
//            novelRepository.insertNovel(novelDto);
//        }
//        List<ChapterDto> chapterList = new ArrayList<>();
//        chapterList.add(new ChapterDto(1, "1 Đây là tên của chương 1", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test1", 1));
//        chapterList.add(new ChapterDto(2, "2 Đây là tên của chương 2", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test2", 1));
//        chapterList.add(new ChapterDto(3, "3 Đây là tên của chương 3", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test3", 1));
//        chapterList.add(new ChapterDto(4, "4 Đây là tên của chương 4", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test4", 1));
//        chapterList.add(new ChapterDto(5, "5 Đây là tên của chương 5", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test5", 1));
//        chapterList.add(new ChapterDto(6, "6 Đây là tên của chương 1", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test1", 2));
//        chapterList.add(new ChapterDto(7, "7 Đây là tên của chương 2", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test2", 2));
//        chapterList.add(new ChapterDto(8, "8 Đây là tên của chương 3", "Các chàng Kiến trẻ chỉ cần đắp hai bên vỉa hè test3", 2));
//        for (ChapterDto chapterDto : chapterList) {
//            chapterRepository.insert(chapterDto);
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
                    if (mPresenter.getStoredLoginStatus()) {
                        selectedFragment = new BookmarkFragment();
                    } else {
                        selectedFragment = new AccountLogoutFragment(); // Replace with AccountFragment.class for older versions
                    }
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
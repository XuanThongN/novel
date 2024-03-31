package com.xuanthongn.ui.fragment.novel_details_fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.xuanthongn.R;
import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.NovelComment;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.ui.adapter.NovelDetailsCommentAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsYourlikeAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.main.NovelDetailsActivity;
import com.xuanthongn.ui.presenter.NovelDetailPresenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

public class InformationFragment extends Fragment implements INovelDetailConstract.IView {
    private INovelDetailConstract.IPresenter mPresenter;
    private BottomSheetDialogFragment mCommentBottomSheetFragment;
    RecyclerView rvNovelRecommend;
    TextView textViewDescription;
    TextView textViewCategory;
    LinearLayout commentLayout;
    Button btShowmore;
    FloatingActionButton fabAddContact;
    TextView novel_detail_count_chapter;
    CategoryRepository categoryRepository;
    AppDatabase db;

    private Animation animation;

    @SuppressLint("MissingInflatedId")


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        textViewDescription = view.findViewById(R.id.textViewContent);
        textViewCategory = view.findViewById(R.id.category_novel);
        novel_detail_count_chapter = view.findViewById(R.id.novel_detail_count_chapter);
        rvNovelRecommend = view.findViewById(R.id.rv_continue_yourlike_novel);
        fabAddContact = view.findViewById(R.id.fabAddContact);
        btShowmore = view.findViewById(R.id.btShowmore);
        commentLayout = view.findViewById(R.id.commentLayout);
        initGUI(view);

        // Khởi tạo animation
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_up_down);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);

        // Sử dụng Handler để khởi động animation sau một khoảng thời gian ngắn
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                fabAddContact.startAnimation(animation);
                handler.postDelayed(this, 750); // Lặp lại sau mỗi 100ms
            }
        };
        handler.postDelayed(runnable, 100); // Bắt đầu chuyển động sau 100ms


        // Xử lý sự kiện khi nhấn nút "Xem thêm..."
        btShowmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btShowmore.getText().toString().equalsIgnoreCase("Xem thêm...")) {
                    textViewDescription.setMaxLines(Integer.MAX_VALUE);
                    btShowmore.setText("Ẩn Bớt");
                } else {
                    textViewDescription.setMaxLines(3);
                    btShowmore.setText("Xem thêm...");
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new NovelDetailPresenter(getContext());
        mPresenter.setView(this);
        NovelDetailsActivity parentActivity = (NovelDetailsActivity) getActivity();
        NovelDto novel = parentActivity.getNovel();
        if (novel != null) {
            textViewCategory.setText(novel.getCategoryName());
            textViewDescription.setText(novel.getDescription());
            mPresenter.getLatestNovelsByCategory(novel.getCategory_id());
            mPresenter.getTotalChapterCount(novel.getId());
        }

        commentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo BottomSheetDialogFragment mới
                mCommentBottomSheetFragment = new CommentFragment();
                // Hiển thị BottomSheetDialogFragment
                mCommentBottomSheetFragment.show(getParentFragmentManager(), mCommentBottomSheetFragment.getTag());
            }
        });
    }


    @Override
    public void displayError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLatestNovels(List<NovelRecommendDto> novels) {
        rvNovelRecommend.setAdapter(new NovelDetailsYourlikeAdapter(this.getContext(), novels));
    }

    @Override
    public void showChapters(List<ChapterDto> chapters) {

    }

    @Override
    public void showChaptersNew(List<ChapterDto> chapters) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showTotalChapterCount(int count) {
        novel_detail_count_chapter.setText(String.valueOf(count));
    }

    private void initGUI(View view) {
        Context context = this.getContext();

//        Truyền dữ liệu vào  bình luận
        RecyclerView rvContinueComment = view.findViewById(R.id.rv_continue_comment_novel);
        List<NovelComment> novelComment = new ArrayList<>();
        novelComment.add(new NovelComment(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "OK HEHE", 145, new Date(102, 1, 12), 3, 4));
        novelComment.add(new NovelComment(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "QUÁ TỆ", 145, new Date(102, 1, 12), 3, 4));
        novelComment.add(new NovelComment(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "Không hay chi hết", 145, new Date(102, 1, 12), 3, 4));
        novelComment.add(new NovelComment(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "Rất tệ so với suy nghĩ", 145, new Date(102, 1, 12), 3, 4));

        rvContinueComment.setAdapter(new NovelDetailsCommentAdapter(context, novelComment));

    }


}

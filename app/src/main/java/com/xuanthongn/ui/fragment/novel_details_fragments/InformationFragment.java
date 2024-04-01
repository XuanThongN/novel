package com.xuanthongn.ui.fragment.novel_details_fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.xuanthongn.R;
import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.NovelComment;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;
import com.xuanthongn.data.repository.CategoryRepository;
import com.xuanthongn.ui.adapter.NovelDetailsCommentAdapter;
import com.xuanthongn.ui.adapter.NovelDetailsYourlikeAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.main.NovelDetailsActivity;
import com.xuanthongn.ui.presenter.NovelDetailPresenter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import io.reactivex.rxjava3.annotations.NonNull;

public class InformationFragment extends Fragment implements INovelDetailConstract.IView {
    private INovelDetailConstract.IPresenter mPresenter;
    private BottomSheetDialogFragment mCommentBottomSheetFragment;
    RecyclerView rvNovelRecommend;
    TextView textViewDescription;
    TextView textViewCategory;
    LinearLayout commentLayout;
    Button btShowmore;
    RecyclerView rvContinueComment;
    TextView novel_detail_count_chapter;
    TextView comment_total;
    CategoryRepository categoryRepository;
    AppDatabase db;
    List<NovelComment> novelComments = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        initGUI(view);

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
            mPresenter.getAllComments(novel.getId());
        }

        commentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo BottomSheetDialogFragment mới
                mCommentBottomSheetFragment = new CommentFragment(novelComments);
                // Hiển thị BottomSheetDialogFragment
                mCommentBottomSheetFragment.show(getParentFragmentManager(), mCommentBottomSheetFragment.getTag());
            }
        });
    }


    @Override
    public void displayError(String errorMessage) {
        System.err.println("Lỗi: " + errorMessage);
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

    @Override
    public void showComments(List<CommentsResponseModel> result) {
        Context context = this.getContext();
//       Convert result to List<NovelComment>
        for (CommentsResponseModel comment : result) {
            novelComments.add(new NovelComment(comment.getId(), comment.getText(), comment.getAuthor().getEmail(), comment.getText(), 0, comment.getCreated_at(), 2, 4));
        }
        rvContinueComment.setAdapter(new NovelDetailsCommentAdapter(context, novelComments));
        comment_total.setText(novelComments.size() + " Bình luận");

    }

    @Override
    public void addCommentToList(CommentsResponseModel result) {

    }

    private void initGUI(View view) {
        textViewDescription = view.findViewById(R.id.textViewContent);
        textViewCategory = view.findViewById(R.id.category_novel);
        novel_detail_count_chapter = view.findViewById(R.id.novel_detail_count_chapter);
        rvNovelRecommend = view.findViewById(R.id.rv_continue_yourlike_novel);
        btShowmore = view.findViewById(R.id.btShowmore);
        comment_total = view.findViewById(R.id.comment_total);
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

        commentLayout = view.findViewById(R.id.commentLayout);
        rvContinueComment = view.findViewById(R.id.rv_continue_comment_novel);

//        Truyền dữ liệu vào  bình luận
//        List<NovelComment> novelComment = new ArrayList<>();
//        novelComment.add(new NovelComment(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "OK HEHE", 145, new Date(102, 1, 12), 3, 4));
//        novelComment.add(new NovelComment(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "QUÁ TỆ", 145, new Date(102, 1, 12), 3, 4));
//        novelComment.add(new NovelComment(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "Không hay chi hết", 145, new Date(102, 1, 12), 3, 4));
//        novelComment.add(new NovelComment(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "dung1@gmail.com", "Rất tệ so với suy nghĩ", 145, new Date(102, 1, 12), 3, 4));


    }


}

package com.xuanthongn.ui.fragment.novel_details_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.xuanthongn.R;
import com.xuanthongn.data.AppDatabase;
import com.xuanthongn.data.model.NovelComment;
import com.xuanthongn.data.model.novel.NovelDto;
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

    CategoryRepository categoryRepository;
    AppDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        textViewDescription = view.findViewById(R.id.textViewContent);
        textViewCategory = view.findViewById(R.id.category_novel);
        rvNovelRecommend = view.findViewById(R.id.rv_continue_yourlike_novel);
        commentLayout = view.findViewById(R.id.commentLayout);
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
    public void showLatestNovels(List<NovelDto> novels) {
        rvNovelRecommend.setAdapter(new NovelDetailsYourlikeAdapter(this.getContext(), novels));
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

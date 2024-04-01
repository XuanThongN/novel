package com.xuanthongn.ui.fragment.novel_details_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.xuanthongn.R;
import com.xuanthongn.data.model.NovelComment;
import com.xuanthongn.data.model.chapter.ChapterDto;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
import com.xuanthongn.data.model.response_model.comment.CommentsResponseModel;
import com.xuanthongn.ui.adapter.NovelDetailsAllCommentAdapter;
import com.xuanthongn.ui.constract.INovelDetailConstract;
import com.xuanthongn.ui.main.NovelDetailsActivity;
import com.xuanthongn.ui.presenter.NovelDetailPresenter;

import java.util.ArrayList;
import java.util.List;

public class CommentFragment extends BottomSheetDialogFragment implements INovelDetailConstract.IView {

    INovelDetailConstract.IPresenter mPresenter;
    RecyclerView rvAllComment;

    List<NovelComment> comments = new ArrayList<>();

    ImageView ivSendComment;
    EditText edtComment;

    public CommentFragment(List<NovelComment> comments) {
        // Required empty public constructor
        this.comments = comments;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        mPresenter = new NovelDetailPresenter(getContext());
        mPresenter.setView(this);
        rvAllComment = view.findViewById(R.id.commentRecyclerView);
        ivSendComment = view.findViewById(R.id.sendButton);
        edtComment = view.findViewById(R.id.commentEditText);
        showComments();
        NovelDetailsActivity parentActivity = (NovelDetailsActivity) getActivity();
        NovelDto novel = parentActivity.getNovel();
        if (novel != null) {

        }
        ivSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtComment.getText().toString().trim();
                if (text.length() <= 0) return;
                mPresenter.postComment(novel.getId(), text, 1);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // You can set up your views and handle events here if needed
    }

    public void showComments() {
// Set up your adapter here
        // Create a layout manager (LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager, etc.)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext()); // Replace LinearLayoutManager with your desired layout manager

// Optionally, configure the layout manager (e.g., set orientation, reverse layout, etc.)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // Example configuration

// Attach the layout manager to the RecyclerView
        rvAllComment.setLayoutManager(layoutManager);
        rvAllComment.setAdapter(new NovelDetailsAllCommentAdapter(this.getContext(), comments));
    }

    @Override
    public void displayError(String errorMessage) {
        Toast.makeText(getContext(), "Bình luận chứa từ ngữ xúc phạm hoặc không hợp lệ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLatestNovels(List<NovelRecommendDto> novels) {

    }

    @Override
    public void showChapters(List<ChapterDto> chapters) {

    }

    @Override
    public void showChaptersNew(List<ChapterDto> chapters) {

    }

    @Override
    public void showTotalChapterCount(int count) {

    }

    @Override
    public void showComments(List<CommentsResponseModel> result) {

    }

    @Override
    public void addCommentToList(CommentsResponseModel result) {
        NovelComment comment = new NovelComment();
        comment.setId(result.getId());
        comment.setContent(result.getText());
        comment.setEmail(result.getAuthor().getEmail());
        comment.setNovelDate(result.getCreated_at());
        comments.add(comment);
        edtComment.setText("");
        edtComment.clearFocus();

//       adapter listen change
        rvAllComment.getAdapter().notifyDataSetChanged();

    }
}

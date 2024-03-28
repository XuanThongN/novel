package com.xuanthongn.ui.fragment.novel_details_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.xuanthongn.R;
import com.xuanthongn.data.model.Novel;
import com.xuanthongn.data.model.NovelComment;
import com.xuanthongn.data.model.NovelYourLikes;
import com.xuanthongn.data.model.novel.NovelDto;
import com.xuanthongn.data.model.novel.NovelRecommendDto;
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
    RecyclerView rvNovelRecommend;

    TextView textViewTitle;
    TextView textViewAuthor;

    TextView textViewDescription;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        rvNovelRecommend = view.findViewById(R.id.rv_continue_category_novel);

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


        // Lấy dữ liệu từ arguments của fragment
//        Bundle arguments = getArguments();
//        if (arguments != null) {
//            int novelId = arguments.getInt("novel_id", -1);
//            if (novelId != -1) {
//                // Load thông tin chi tiết của cuốn truyện
//                mPresenter.loadNovelDetails(novelId);
//            } else {
//                // Hiển thị thông báo lỗi nếu không có novelId được truyền qua arguments
//                displayError("Không tìm thấy ID của cuốn truyện");
//            }
//        } else {
//            // Hiển thị thông báo lỗi nếu arguments là null
//            displayError("Không có arguments được truyền vào fragment");
//        }
    }

    public static InformationFragment newInstance(NovelRecommendDto novel) {
        InformationFragment fragment = new InformationFragment();
        Bundle args = new Bundle();
        args.putSerializable("novel", novel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void displayNovelDetails(NovelDto novel) {
        textViewTitle.setText(novel.getName());
        textViewAuthor.setText(novel.getAuthor());
        textViewDescription.setText(novel.getDescription());

    }

    @Override
    public void displayError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
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


        //        Truyền dữ liệu vào mục truyện bạn có thể thích
        RecyclerView rvContinueYourlike = view.findViewById(R.id.rv_continue_yourlike_novel);
        List<NovelYourLikes> novelYourlike = new ArrayList<>();
        novelYourlike.add(new NovelYourLikes(1, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Tiên hiệp - Tiên hiệp cổ điển cổ điển", "Lấy bối cảnh Trung Quốc, nội dung chủ yếu miêu tả quá trình theo đuổi Tiên đạo"));
        novelYourlike.add(new NovelYourLikes(2, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Tiên hiệp - Tiên hiệp ổ điển cổ điển", "Lấy bối cảnh Trung Quốc, nội dung chủ yếu miêu tả quá trình theo đuổi Tiên đạo"));
        novelYourlike.add(new NovelYourLikes(3, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Tiên hiệp - Tiên hiệp ổ điển cổ điển", "Lấy bối cảnh Trung Quốc, nội dung chủ yếu miêu tả quá trình theo đuổi Tiên đạo"));
        novelYourlike.add(new NovelYourLikes(4, "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Tiên hiệp - Tiên hiệp ổ điển cổ điển", "Lấy bối cảnh Trung Quốc, nội dung chủ yếu miêu tả quá trình theo đuổi Tiên đạo"));

        rvContinueYourlike.setAdapter(new NovelDetailsYourlikeAdapter(context, novelYourlike));

    }

//    @Override
//    public void setCategory(List<CategoryDto> novelList) {
//        rvNovelRecommend.setAdapter(new CategoryNovelItemAdapter(this.getContext(), novelList));
//    }


}

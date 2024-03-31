package com.xuanthongn.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xuanthongn.R;

public class CustomBindingAdapter {

    public static void loadImage(ImageView imageView, String url) {

        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions().placeholder(android.R.drawable.progress_indeterminate_horizontal))
                .into(imageView);
    }
}

package com.xuanthongn.ui.fragment.home;

import static com.xuanthongn.R.id.profile_detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.xuanthongn.R;
import com.xuanthongn.ui.main.ProfileActivity;

public class AccountFragment extends Fragment {
    LinearLayout profile_detail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        profile_detail = view.findViewById(R.id.profile_detail);
        profile_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }

        });
        return view;
    }
}

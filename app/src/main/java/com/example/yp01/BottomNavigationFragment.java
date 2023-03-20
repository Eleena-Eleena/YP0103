package com.example.yp01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BottomNavigationFragment extends Fragment implements View.OnClickListener {
    View view;
    RelativeLayout homer, navr, profr;
    ImageView ihome, inav, iprof;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getChildFragmentManager();
        view = inflater.inflate(R.layout.include_bottom_toolbar, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
    }

    public void initializeComponents() {
        if (getView() == null) {
            return;
        }
        homer = getView().findViewById(R.id.homei);
        navr = getView().findViewById(R.id.navi);
        profr = getView().findViewById(R.id.profi);

        ihome = getView().findViewById(R.id.iv_1);
        inav = getView().findViewById(R.id.iv_2);
        iprof = getView().findViewById(R.id.iv_3);

        homer.setOnClickListener(this);
        navr.setOnClickListener(this);
        profr.setOnClickListener(this);

        setBottomNavigationView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.homei:
                Intent intent = new Intent(getActivity(), HomePage.class);
                getActivity().startActivity(intent);
                break;
            case R.id.navi:
                Intent intent1 = new Intent(getActivity(), ListenPage.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.profi:
                Intent intent2 = new Intent(getActivity(), Profile.class);
                getActivity().startActivity(intent2);
                break;
        }
    }

    private void setBottomNavigationView() {
        int black_color = getActivity().getResources().getColor(R.color.black);
        int white_color = getActivity().getResources().getColor(R.color.white);

        if (getActivity() != null && getActivity() instanceof HomePage) {
            ihome.setColorFilter(white_color);
            inav.setColorFilter(black_color);
            iprof.setColorFilter(black_color);
        } else if (getActivity() != null && getActivity() instanceof ListenPage) {
            ihome.setColorFilter(black_color);
            inav.setColorFilter(white_color);
            iprof.setColorFilter(black_color);
        } else if (getActivity() != null && getActivity() instanceof Profile) {
            ihome.setColorFilter(black_color);
            inav.setColorFilter(black_color);
            iprof.setColorFilter(white_color);
        }
    }
}

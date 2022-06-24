package com.example.anfood.Login.Premire_Tutorial;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.example.anfood.Login.Login;
import com.example.anfood.Menu.Menu;
import com.example.anfood.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends Fragment {
    LottieAnimationView btn_gotohome;

    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    ViewGroup rootview =(ViewGroup)inflater.inflate(R.layout.fragment_fragment4, container, false);
    btn_gotohome=rootview.findViewById(R.id.btn_gotohome);
    btn_gotohome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btn_gotohome.playAnimation();
            Intent i = new Intent(getActivity(), Login.class);
            getActivity().startActivity(i);
            getActivity().finish();

        }
    });
        return rootview;
    }

}

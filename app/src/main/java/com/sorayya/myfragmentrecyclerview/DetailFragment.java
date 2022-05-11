package com.sorayya.myfragmentrecyclerview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private String mParam1;
    private Integer mParam2;
    private String mParam3;
    ImageView imageViewCall;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(String param1, Integer param2,String param3) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2,param2);
        args.putString(ARG_PARAM3, param3);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        TextView titleTV= view.findViewById(R.id.titleTV);
        ImageView imageView=view.findViewById(R.id.imageDetail);
        TextView phoneText=view.findViewById(R.id.phoneNumber);
        titleTV.setText(mParam1);
        imageView.setImageResource(mParam2);
        phoneText.setText(mParam3);
        imageViewCall=view.findViewById(R.id.imageViewCall);
        imageViewCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Calling "+mParam3, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", mParam3, null));
                startActivity(intent);
            }
        });
        return view;
    }

}
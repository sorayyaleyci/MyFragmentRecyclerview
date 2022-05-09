package com.sorayya.myfragmentrecyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainFragment extends Fragment implements RecyclerviewAdapter.ItemClicklistener{
    private final ArrayList<DataModel> list=new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        return new MainFragment();
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

 */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_main, container, false);
        buildListData();
        initRecyclerview(view);
        return view;
    }
    private void initRecyclerview(View view){
        RecyclerView recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerviewAdapter adapter= new RecyclerviewAdapter(list,this);
        recyclerView.setAdapter(adapter);

    }
    private void buildListData(){
        list.add(new DataModel("Sheldon",getResources().getDrawable(R.drawable.faceone),"09144743400",R.drawable.faceone));
        list.add(new DataModel("Bernadette",getResources().getDrawable(R.drawable.facetwo),"09370692392",R.drawable.facetwo));
        list.add(new DataModel("Mary",getResources().getDrawable(R.drawable.facethree),"09332873719",R.drawable.facethree));
        list.add(new DataModel("Emily",getResources().getDrawable(R.drawable.facefour),"09125367896",R.drawable.facefour));
        list.add(new DataModel("Melissa",getResources().getDrawable(R.drawable.facefive),"09758621368",R.drawable.facefive));
        list.add(new DataModel("Amy",getResources().getDrawable(R.drawable.facesix),"09363458612",R.drawable.facesix));
        list.add(new DataModel("Penny",getResources().getDrawable(R.drawable.faceseven),"0945896321",R.drawable.faceseven));

    }

    @Override
    public void onItemClick(DataModel dataModel) {
        Fragment fragment = DetailFragment.newInstance(dataModel.getTitle(),dataModel.getDrawableID(),dataModel.getPhoneNumber());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
       // transaction.replace(R.id.frame_container,fragment,"detail_fragment");
        transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("main_fragment"));
        transaction.add(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
package com.example.darsh.newsession14;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<ImageModel> mList;
    RecyclerView mRecyclerView;
    ImageAdapter imageAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_home_fragment, container, false);
        mRecyclerView=view.findViewById(R.id.myRV);
        mList=new ArrayList<>();
        imageAdapter=new ImageAdapter(getContext(),mList);
        mLayoutManager=new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(imageAdapter);
        Data();
        return view;
    }
    private void Data() {
        ImageModel imageModel;
        for (int i=0;i<=73;i++){
            imageModel=new ImageModel(R.drawable.image+i);
            mList.add(imageModel);
        }
        imageAdapter.notifyDataSetChanged();


    }
}

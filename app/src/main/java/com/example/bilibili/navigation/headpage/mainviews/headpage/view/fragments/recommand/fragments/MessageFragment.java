package com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments.recommand.fragments;


import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibili.R;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.DownLoadAndMessageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    private RecyclerView recyclerViewMessage;


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerViewMessage = view.findViewById(R.id.message_recycler);
        recyclerViewMessage.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMessage.addItemDecoration(new MyDecoration());
        //2为消息类型
        recyclerViewMessage.setAdapter(new DownLoadAndMessageAdapter(getContext(),2));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int gap = 2;
            outRect.set(0,0,0,gap);
        }
    }
}

package com.example.bilibili.navigation.headpage.mainviews.videodetail.Fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bilibili.R;
import com.example.bilibili.contentobj.RecommendObject;
import com.example.bilibili.navigation.headpage.mainviews.videodetail.adapter.BriefIntroAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BriefIntroFragment extends Fragment {
    private Context context;
    private RecommendObject recommendObject;
    private RecyclerView recyclerView;
    private ableScroll ableScroll;
    private NestedScrollView nestedScrollChild;

    public BriefIntroFragment(Context context, RecommendObject recommendObject){
        this.context = context;
        this.recommendObject = recommendObject;
    }
    public void setScrollListener(ableScroll ableScroll){
        this.ableScroll = ableScroll;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerView);
        nestedScrollChild = view.findViewById(R.id.nestedScroll_child);
        recyclerView.setLayoutManager(new LinearLayoutManager(context){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerView.addItemDecoration(new MyDecoration());
        recyclerView.setAdapter(new BriefIntroAdapter(context,recommendObject));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_briefintro_fragment,container,false);

    }

    class MyDecoration extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = 2;

            outRect.set(0,0,0,gap);
        }
    }
    public interface ableScroll{
        boolean getScroll();
    }


}

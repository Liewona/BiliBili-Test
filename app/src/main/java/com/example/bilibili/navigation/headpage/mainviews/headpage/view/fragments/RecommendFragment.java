package com.example.bilibili.navigation.headpage.mainviews.headpage.view.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bilibili.R;
import com.example.bilibili.activitys.VideoDetailActivity;
import com.example.bilibili.data.GetNewRecommendData;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.MyRecyclerViewRecommendAdapter;
import com.example.bilibili.utils.ThreadUtils;
import com.example.bilibili.navigation.headpage.mainviews.headpage.view.adapters.OnLoadMoreListener;
import com.example.bilibili.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {

    private Context mContext;
    private GridLayoutManager mManager;
    private MyRecyclerViewRecommendAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private View headerLayout;
    private List<String> bannerSourceItems = new ArrayList<>();

    int page = 1;

    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if(true) return;
        mContext = getContext();
        mAdapter = new MyRecyclerViewRecommendAdapter(mContext);
        mRefreshLayout = getView().findViewById(R.id.recommend_page);
        initMoviesData(false);

        mRecyclerView = getView().findViewById(R.id.recommend_page_recycler_view);
        mManager = new GridLayoutManager(mContext, 2);


        initRecyclerView();
        mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(mAdapter.getItemViewType(position) == mAdapter.MOVIE_TYPE)
                    return 1;
                else return 2;
            }
        });

    }

    //获得推荐视频的数据
    private void initMoviesData(boolean flag) {

        ThreadUtils.setInThread(new Runnable() {
            @Override
            public void run() {
                int state = GetNewRecommendData.getNewData(page, mAdapter, flag);
                if(state == GetNewRecommendData.LOAD_SUCCESSFUL) {
                    ThreadUtils.setInUIThread(new Runnable() {
                        @Override
                        public void run() {
                            if(! flag) {
                                mAdapter.setHeader(headerLayout, changeItems());
                            }
                            Log.d("mylog", "run: " + bannerSourceItems.size());
                            mAdapter.notifyDataSetChanged();
                            mRefreshLayout.setRefreshing(false);
                        }
                    });
                } else if (state == GetNewRecommendData.LOAD_FAILD) {
                    Looper.prepare();
                    ToastUtil.makeText(mContext, "网络不良，加载失败！", Toast.LENGTH_SHORT);
                    mRefreshLayout.setRefreshing(false);
                    Looper.loop();
                }
            }
        });

    }
    //初始化RecyclerView
    private void initRecyclerView() {
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mManager);

        headerLayout = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_head_layout, mRecyclerView, false);

        mRefreshLayout.setColorSchemeResources(R.color.nav_bar_text_select_color);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page += 1;
                initMoviesData(false);
            }
        });

        mAdapter.setItemClickListener(new MyRecyclerViewRecommendAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mContext,"position " + position,Toast.LENGTH_SHORT).show();
                int p = position;
                if (mAdapter.hasHeader()) {
                    if (position == 0) {
                        return;
                    }
                    p -= 1;
                }
                if(mAdapter.hasFooter()) {
                    return ;
                }
                Bundle bundle = new Bundle();
//                            bundle.putInt("position" ,position);
                Intent intent = new Intent(mContext, VideoDetailActivity.class);
                bundle.putSerializable("movie", mAdapter.getAllMovies().get(p));
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

        mRecyclerView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                ToastUtil.makeText(mContext, "正在加载", Toast.LENGTH_SHORT);

                page += 1;
                initMoviesData(true);
            }
        });
    }


    public MyRecyclerViewRecommendAdapter getmAdapter() {
        return mAdapter;
    }





    public List<String> changeItems() {
        bannerSourceItems.clear();
        Random random = new Random();
        int moviesCount = mAdapter.getAllMovies().size();
        int num = random.nextInt(moviesCount);
        Log.d("mylog", "changeItems: " + moviesCount);
        String picStr = "";
        for(int i = 0; i < 4; i++) {
            picStr = mAdapter.getAllMovies().get(num).pic;
            if( ! bannerSourceItems.contains(picStr)) {
                bannerSourceItems.add(picStr);
            } else {
                i -= 1;
            }
            num = random.nextInt(moviesCount);
        }
        return bannerSourceItems;
    }



}

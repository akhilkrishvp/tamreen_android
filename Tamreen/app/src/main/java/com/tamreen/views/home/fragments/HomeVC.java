package com.tamreen.views.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.tamreen.R;
import com.tamreen.core.Utilities.AppBarStateChangeListener;
import com.tamreen.core.Utilities.CoreFragment;
import com.tamreen.views.adapter.AdapterHomeCourseTypeList;
import com.tamreen.views.adapter.AdapterHomePopularTeachersList;
import com.tamreen.views.adapter.AdapterHomeProfTrainerList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeVC extends CoreFragment {
    AppBarLayout app_bar_layout;
    Toolbar toolbar;
    @BindView(R.id.proTrainerList)
    RecyclerView proTrainerList;
    @BindView(R.id.courseTypeList)
    RecyclerView courseTypeList;
    @BindView(R.id.popularTeachersList)
    RecyclerView popularTeachersList;
    Unbinder unbinder;
    AdapterHomeProfTrainerList adapterHomeProfTrainerList;
    AdapterHomeCourseTypeList adapterHomeCourseTypeList;
    AdapterHomePopularTeachersList adapterHomePopularTeachersList;

    public HomeVC() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        app_bar_layout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        initAppBar();
        initRV();
        return view;
    }

    private void initAppBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        app_bar_layout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0) {
                    toolbar.setAlpha(1f);
                }
                else {

                    toolbar.setAlpha(0f);
                }
            }
        });
    }

    private void initRV() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        proTrainerList.setLayoutManager(layoutManager);
        proTrainerList.setHasFixedSize(true);
        proTrainerList.setNestedScrollingEnabled(false);
        adapterHomeProfTrainerList = new AdapterHomeProfTrainerList(context);
        proTrainerList.setAdapter(adapterHomeProfTrainerList);

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        courseTypeList.setLayoutManager(layoutManager1);
        courseTypeList.setHasFixedSize(true);
        courseTypeList.setNestedScrollingEnabled(false);
        adapterHomeCourseTypeList = new AdapterHomeCourseTypeList(context);
        courseTypeList.setAdapter(adapterHomeCourseTypeList);

        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        popularTeachersList.setLayoutManager(layoutManager2);
        popularTeachersList.setHasFixedSize(true);
        popularTeachersList.setNestedScrollingEnabled(false);
        adapterHomePopularTeachersList = new AdapterHomePopularTeachersList(context);
        popularTeachersList.setAdapter(adapterHomePopularTeachersList);


    }
}

package com.tamreen.views.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.tamreen.R;
import com.tamreen.model.api.country.CountryObj;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class AdapterHomeCourseTypeList extends RecyclerView.Adapter<AdapterHomeCourseTypeList.ViewHolder> {

    private int currentIndex=0;
    private List<CountryObj> dataList = new ArrayList<>();
    Context context;
    Typeface boldTF,normalTF;
    OnItemClickListner onCityClickListner;

    public void setDataList(List<CountryObj> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    private LayoutInflater layoutInflater;

    public AdapterHomeCourseTypeList(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item_home_course_type, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        //ButterKnife.bind(this, view);


        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


    }


    @Override
    public int getItemCount() {
        return 8;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface OnItemClickListner {
        void onCountryItemClick(int position);
    }

}
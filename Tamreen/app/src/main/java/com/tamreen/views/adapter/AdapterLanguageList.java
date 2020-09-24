package com.tamreen.views.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tamreen.R;
import com.tamreen.model.api.country.CountryObj;
import com.tamreen.model.staticModel.Language;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterLanguageList extends RecyclerView.Adapter<AdapterLanguageList.ViewHolder> {

    private List<Language> dataList = new ArrayList<>();
    Context context;
    Typeface boldTF,normalTF;
    OnItemClickListner onCityClickListner;

    public void setDataList(List<Language> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    private LayoutInflater layoutInflater;

    public AdapterLanguageList(Context context, OnItemClickListner onCityClickListner) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.onCityClickListner = onCityClickListner;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_country_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        //ButterKnife.bind(this, view);


        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Language dataObj = dataList.get(position);
        holder.countryNameTV.setText(dataObj.getName());
        if(dataObj.isSelected()){
            holder.selectorRadioBtn.setChecked(true);
        }
        else {
            holder.selectorRadioBtn.setChecked(false);
        }
        holder.iconIV.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.language));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCityClickListner.onLanguageClick(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.flagIV)
        ImageView iconIV;
        @BindView(R.id.countryNameTV)
        AppCompatTextView countryNameTV;
        @BindView(R.id.selectorRadioBtn)
        AppCompatRadioButton selectorRadioBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface OnItemClickListner {
        void onLanguageClick(int position);
    }

}
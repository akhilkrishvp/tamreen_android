package com.tamreen.views.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.tamreen.R;
import com.tamreen.model.api.country.CountryObj;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterCountryList extends RecyclerView.Adapter<AdapterCountryList.ViewHolder> {

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

    public AdapterCountryList(Context context,OnItemClickListner onCityClickListner) {
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

        CountryObj countryObj = dataList.get(position);
        holder.countryNameTV.setText(countryObj.getNameString());
        if(countryObj.isSelected()){
            holder.selectorRadioBtn.setChecked(true);
        }
        else {
            holder.selectorRadioBtn.setChecked(false);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCityClickListner.onCountryItemClick(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
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
        void onCountryItemClick(int position);
    }

}
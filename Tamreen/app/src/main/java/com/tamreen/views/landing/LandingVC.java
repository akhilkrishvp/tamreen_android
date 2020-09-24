package com.tamreen.views.landing;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tamreen.R;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.core.Utilities.UserSettings;
import com.tamreen.model.api.country.CountryObj;
import com.tamreen.model.api.country.CountryResponse;
import com.tamreen.model.staticModel.Language;
import com.tamreen.network.Api;
import com.tamreen.views.adapter.AdapterCountryList;
import com.tamreen.views.adapter.AdapterLanguageList;
import com.tamreen.views.splash.LaunchVC;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandingVC extends CoreVC implements AdapterCountryList.OnItemClickListner,AdapterLanguageList.OnItemClickListner{
    @BindView(R.id.countryList)
    RecyclerView countryRV;
    @BindView(R.id.languageList)
    RecyclerView languageRV;
    @BindView(R.id.continueBtn)
    AppCompatTextView continueBtn;
    AdapterCountryList adapterCountryList;
    AdapterLanguageList adapterLanguageList;
    ArrayList<CountryObj> countryList = new ArrayList<>();
    List<Language> languageList = new ArrayList<>();
    CountryObj countryObj = new CountryObj();
    String lang = "en";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_vc);
        ButterKnife.bind(this);
        initRV();
        getCountryList();
        setLanguageData();
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSettings.setCountryObj(countryObj,context);
                UserSettings.setLang(context,lang);
                Launch(OnboardingVC.class);
            }
        });
    }
    private void initRV(){
        adapterCountryList = new AdapterCountryList(this,this::onCountryItemClick);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        countryRV.setLayoutManager(layoutManager1);
        countryRV.setAdapter(adapterCountryList);

        adapterLanguageList = new AdapterLanguageList(this,this::onLanguageClick);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        languageRV.setLayoutManager(layoutManager2);
        languageRV.setAdapter(adapterLanguageList);
    }

    @Override
    public void onCountryItemClick(int position) {
        countryObj = countryList.get(position);
        setCountrySelection(position);
    }

    @Override
    public void onLanguageClick(int position) {
        lang = languageList.get(position).getValue();
        setLangSelection(position);
    }
    private void getCountryList(){
        startIndicator();
        Api.getApi().getCountryList(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                stopIndicator();
                if(response.body() != null){
                    countryList = response.body().getCountryList();
                    countryList.get(0).setSelected(true);
                    updateCountryList();

                }

            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {

            }
        });
    }
    private void updateCountryList(){
        adapterCountryList.setDataList(countryList);
        countryObj = countryList.get(0);
    }
    private void setLanguageData(){
        languageList.add(new Language(getResources().getString(R.string.english),"en",true));
        languageList.add(new Language(getResources().getString(R.string.arabic),"ar",false));
        adapterLanguageList.setDataList(languageList);
    }
    private void setCountrySelection(int pos) {
        for (int i = 0; i < countryList.size(); i++) {
            if (i == pos) {
                countryList.get(i).setSelected(true);
            } else {
                countryList.get(i).setSelected(false);
            }
        }
        adapterCountryList.setDataList(countryList);
    }
    private void setLangSelection(int pos) {
        for (int i = 0; i < languageList.size(); i++) {
            if (i == pos) {
                countryList.get(i).setSelected(true);
            } else {
                countryList.get(i).setSelected(false);
            }
        }
        adapterLanguageList.setDataList(languageList);
    }
}

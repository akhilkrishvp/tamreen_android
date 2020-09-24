package com.tamreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.davidmiguel.numberkeyboard.NumberKeyboard;
import com.davidmiguel.numberkeyboard.NumberKeyboardListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tamreen.core.Utilities.AppBarStateChangeListener;
import com.tamreen.customViews.HorizontalCarouselRecyclerView;
import com.tamreen.model.api.country.CountryResponse;
import com.tamreen.network.Api;
import com.tamreen.views.adapter.AdapterHomeProfTrainerList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    HorizontalCarouselRecyclerView testRv;
    AdapterHomeProfTrainerList adapterHomeProfTrainerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        ButterKnife.bind(this);
        testRv = (HorizontalCarouselRecyclerView) findViewById(R.id.testRV);
        adapterHomeProfTrainerList = new AdapterHomeProfTrainerList(this);
        testRv.initialize(adapterHomeProfTrainerList);

    }



}
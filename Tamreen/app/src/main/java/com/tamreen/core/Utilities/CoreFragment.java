package com.tamreen.core.Utilities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.tamreen.R;
import com.tamreen.views.home.MainTabBarVC;

import java.util.HashMap;

/**
 * Created by diyaa on 10/9/17.
 */

public class CoreFragment extends Fragment implements OnBackPressListener {

     public MainTabBarVC mainTabBar;
    public Context context;
    private FrameLayout fragmentContainer;

    public CoreFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainTabBar = (MainTabBarVC) getActivity();
        context = mainTabBar.getApplicationContext();
    }

    public void title(String title) {

    }

    public int Dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public int dpToPx(int dp) {
        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }
    public void ChangeBackArrow() {

    }

    public void setRightItem(@Nullable View.OnClickListener l) {

    }

    public void pushFragment(Fragment vc, @Nullable Bundle bundle) {
        if (bundle != null) {
            vc.setArguments(bundle);
        }
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        //ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);

        //ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.h, R.anim.hyperspace_in, R.anim.slide_out );
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,
                android.R.anim.slide_out_right, android.R.anim.slide_in_left);
        ft.addToBackStack(null);
        ft.replace(R.id.container, vc).commit();
        mainTabBar.currentFragment = vc;

        //print(mainTabBar.currentFragment.getClass().getName());

    }
    @Override
    public void onAttach(Context mcontext) {
        super.onAttach(mcontext);
        context = mcontext;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }
    public void pushVC(Class<?> vc, @Nullable Bundle bundle) {
        if (bundle != null) {
            //vc.setArguments(bundle);
        }
        // mainTabBar.changeBackArrow();
        mainTabBar.Launch(vc);
    }
    public void Launch(Class<?> distention) {
        Intent intent = new Intent(getActivity(), distention);
        startActivity(intent);
    }
    public void  pushVC(Class<?> vc,String key,Object dataObj) {
        mainTabBar.Launch(vc,key,dataObj);
    }
    public void pushVC(Class<?> distention, String key, Object dataObj, HashMap<String, Boolean> extras) {
        mainTabBar.LaunchWithExtras(distention,key,dataObj,extras);
    }


    public void pushVC(Class<?> vc,String key,int dataObj) {
        mainTabBar.Launch(vc,key,dataObj);
    }

    public void pushVC(Class<?> vc,String key,String dataObj) {
        mainTabBar.Launch(vc,key,dataObj);
    }


    public void startIndicator() {
        mainTabBar.startIndicator();
    }

    public void stopIndicator() {
        mainTabBar.stopIndicator();

    }


    public void popVC() {
        popVC();
    }


    public void print(String msg) {
        Log.d("**", msg);
    }

    public void print(String msg, String msg2) {
        Log.d("**", msg + " " + msg2);
    }


    public void showAlert(final String msg) {
        mainTabBar.showAlert(msg);
    }

    /**
     * Refresh
     */
    public void refresh() {
        print("Re-Load View");
        /*if (getArguments().getInt("index", 0) > 0) {
        }*/
    }

    /**
     * Called when a fragment will be displayed
     */


    @Override
    public boolean onBackPressed() {
        return new BackPressImpl(this).onBackPressed();
    }

}

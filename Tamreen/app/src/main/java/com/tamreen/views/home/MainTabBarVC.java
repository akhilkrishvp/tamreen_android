package com.tamreen.views.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.tamreen.R;
import com.tamreen.core.Utilities.CoreFragment;
import com.tamreen.core.Utilities.CoreVC;
import com.tamreen.views.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MainTabBarVC extends CoreVC {
    private AHBottomNavigationViewPager viewPager;
    private AHBottomNavigation bottomNavigation;
    private AHBottomNavigationAdapter navigationAdapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    public Fragment currentFragment;
    public ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_bar);
        initTabBar();
    }


    private void initTabBar(){
        bottomNavigation = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.view_pager);
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_home, R.drawable.tab_home_icon, R.color.grey);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_bookings, R.drawable.clock, R.color.grey);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_chat, R.drawable.tab_chat_icon, R.color.grey);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_fav, R.drawable.tab_fav_icon, R.color.grey);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(R.string.tab_profile, R.drawable.tab_profile_icon, R.color.grey);

        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigationItems.add(item4);
        bottomNavigationItems.add(item5);

        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setAccentColor(Color.parseColor("#000000"));
        bottomNavigation.setInactiveColor(Color.parseColor("#8a8a8f"));
        bottomNavigation.setTranslucentNavigationEnabled(true);
        bottomNavigation.setForceTint(true);
//        bottomNavigation.setBehaviorTranslationEnabled(false);
      //  bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (currentFragment == null) {
                    currentFragment = adapter.getCurrentFragment();
                }
                if (wasSelected) {
                    CoreFragment fragment = (CoreFragment) currentFragment;
                    fragment.refresh();
                    return true;
                }
                if (currentFragment != null) {
                   // currentFragment.willBeHidden();
                }
                viewPager.setCurrentItem(position, false);
                if (currentFragment == null) {
                    return true;
                }
                currentFragment = adapter.getCurrentFragment();
                CoreFragment fragment = (CoreFragment) currentFragment;
                fragment.refresh();
                return true;
            }
        });
        viewPager.setOffscreenPageLimit(4);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        currentFragment = adapter.getCurrentFragment();
    }
}

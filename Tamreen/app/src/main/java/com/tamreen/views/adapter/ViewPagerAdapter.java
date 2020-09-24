package com.tamreen.views.adapter;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tamreen.views.home.fragments.BookingVC;
import com.tamreen.views.home.fragments.ChatVC;
import com.tamreen.views.home.fragments.FavoriteVC;
import com.tamreen.views.home.fragments.HomeVC;
import com.tamreen.views.home.fragments.ProfileVC;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment;


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(new HomeVC());
        fragments.add(new BookingVC());
        fragments.add(new ChatVC());
        //fragments.add(new CartVC());
        fragments.add(new FavoriteVC());
        fragments.add(new ProfileVC());


        //fragments.add(TabBarFragment.newInstance(4));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);

      /*  switch (position){
            case 0:
                return new HomeVC();
            case 1:
                return new CartVC();
            default:
                break;
        }
        return null;
     */
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((Fragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    /**
     * Get the current fragment
     */
    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}
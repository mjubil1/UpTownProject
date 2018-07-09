package project.uptown.sideproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import project.uptown.sideproject.FirstFragment;
import project.uptown.sideproject.FourthFragment;
import project.uptown.sideproject.MainActivity;
import project.uptown.sideproject.SecondFragment;
import project.uptown.sideproject.ThirdFragment;

/**
 * Created by Montrell on 6/27/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_PAGES = 4;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return FirstFragment.newInstance(1, "Instance 1");
            case 1: return SecondFragment.newInstance(2, "Instance 1");
            case 2: return ThirdFragment.newInstance(3,"ThirdFragment, Instance 1");
            case 3: return FourthFragment.newInstance(4,"FourthFragment, Instance 1");
            default: return null;
        }
    }
}

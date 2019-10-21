package com.chel.sangwa_sytles;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chel.sangwa_sytles.models.Business;

import java.util.List;

public class MallPagerAdapter extends FragmentPagerAdapter {
    private List<Business> mMalls;

    public MallPagerAdapter(FragmentManager fm, List<Business> malls) {
        super(fm);
        mMalls = malls;
    }

    @Override
    public Fragment getItem(int position) {
        return MallDetailFragment.newInstance(mMalls.get(position));
    }

    @Override
    public int getCount() {
        return mMalls.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMalls.get(position).getName();
    }
}
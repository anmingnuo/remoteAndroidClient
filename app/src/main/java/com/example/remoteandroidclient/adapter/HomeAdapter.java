package com.example.remoteandroidclient.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> datas;

    public HomeAdapter(@NonNull FragmentManager fm, List<Fragment> datas) {

        super(fm);
        this.datas = datas;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}
package com.geektech.navlesson.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.geektech.navlesson.fragments.SectionFragment;
import com.geektech.navlesson.study.fragments.CalculatorFragment;
import com.geektech.navlesson.study.fragments.ListFragment;

// Created by askar on 10/2/18.
//TODO: Создайте свой адаптер на основе этого для использования своих фрагментов
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private int mPagesCount = 2;
    Fragment fragment;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //Возвращаем нужный фрагмент по заданной позиции i, можно использовать уже готовый список фрагментов
    //TODO: Передать название фрагмента
    @Override
    public Fragment getItem(int i) {


        switch (i){
            case 0:
                return SectionFragment.getInstance("Home");

            case 1:
                //return SectionFragment.getInstance("Posts");
                return ListFragment.getInstance();
            case 2:
                //return SectionFragment.getInstance("Settings");
                return  CalculatorFragment.getFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return mPagesCount;
    }
}

package com.example.tiendatbkhn.recyclerviewexample.screen.viewpagerex;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;

/**
 * Created by tiendatbkhn on 23/04/2018.
 */

public class ViewPagerViewModel extends BaseObservable implements ViewPagerContract.ViewModel {
    private ViewPagerAdapter mAdapter;
    private ViewPagerContract.View mNavigator;
    @Override
    public void onStartViewModel() {
        //do something
    }

    @Override
    public void setView(BaseView baseView) {
        mNavigator = (ViewPagerContract.View) baseView;
    }

    @Bindable
    public ViewPagerAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(ViewPagerAdapter mAdapter) {
        this.mAdapter = mAdapter;
        notifyPropertyChanged(BR.adapter);
    }
}

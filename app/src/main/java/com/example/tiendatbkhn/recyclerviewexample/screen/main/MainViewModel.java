package com.example.tiendatbkhn.recyclerviewexample.screen.main;

import android.databinding.BaseObservable;

import com.example.tiendatbkhn.recyclerviewexample.model.main.Example;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class MainViewModel extends BaseObservable implements MainContract.ViewModel,ExampleItemViewModel.ItemExampleClick {
    private MainContract.View mNavigator;
    private ExampleAdapter mAdapter;

    @Override
    public void onStartViewModel() {
        getMainRepo();
    }

    @Override
    public void setView(BaseView baseView) {
        mNavigator = (MainContract.View) baseView;
    }

    @Override
    public void getMainRepo() {
        //do something with network
    }

    public ExampleAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(ExampleAdapter mAdapter) {
        this.mAdapter = mAdapter;
        this.mAdapter.setItemExampleClick(this);
    }

    @Override
    public void onExampleClick(Example obj) {
        if (obj.getId() == 1) {
            mNavigator.goRecyclerViewExample();
        } else if (obj.getId() == 2) {
            mNavigator.goViewPagerExample();
        }
    }
}

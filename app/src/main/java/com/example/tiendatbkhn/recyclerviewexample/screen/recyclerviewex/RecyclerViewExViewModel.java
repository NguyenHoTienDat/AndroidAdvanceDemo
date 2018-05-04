package com.example.tiendatbkhn.recyclerviewexample.screen.recyclerviewex;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.tiendatbkhn.recyclerviewexample.databinding.ActivityRecyclerViewExBinding;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ItemCarBinding;
import com.example.tiendatbkhn.recyclerviewexample.model.recyclerviewmodel.CarRepo;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class RecyclerViewExViewModel extends BaseObservable implements
        RecyclerViewExContract.ViewModel,CarAdapter.OnLoadMoreListener {
    private RecyclerViewExContract.View mNavigator;
    private CarAdapter mAdapter;
    private ActivityRecyclerViewExBinding mBinding;

    @Override
    public void onStartViewModel() {

    }

    @Override
    public void setView(BaseView baseView) {
        mNavigator = (RecyclerViewExContract.View) baseView;
    }

    @Bindable
    public CarAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(CarAdapter adapter) {
        this.mAdapter = adapter;
        this.mAdapter.setRcCar(mBinding.rcExample);
        this.mAdapter.setOnLoadMoreListener(this);
    }

    public void setBinding(ActivityRecyclerViewExBinding binding) {
        this.mBinding = binding;
    }

    @Override
    public void onBackClick() {
        mNavigator.finishView();
    }


    @Override
    public void onLoadMore() {
        mNavigator.loadMoreItem();
    }
}

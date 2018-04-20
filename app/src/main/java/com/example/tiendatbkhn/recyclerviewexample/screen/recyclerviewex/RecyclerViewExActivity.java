package com.example.tiendatbkhn.recyclerviewexample.screen.recyclerviewex;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ActivityRecyclerViewExBinding;
import com.example.tiendatbkhn.recyclerviewexample.model.recyclerviewmodel.CarRepo;

public class RecyclerViewExActivity extends AppCompatActivity implements RecyclerViewExContract.View {
    private RecyclerViewExViewModel mViewModel;
    private CarAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewExBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_recycler_view_ex);

        mViewModel = new RecyclerViewExViewModel();
        mViewModel.setView(this);
        mViewModel.setBinding(binding);
        mAdapter = new CarAdapter(this,CarRepo.getCars());
        mViewModel.setAdapter(mAdapter);

        initViewModel();
        binding.setViewModel(mViewModel);
    }

    @Override
    public void initViewModel() {
        mViewModel.onStartViewModel();
    }

    @Override
    public void finishView() {
        finish();
    }

    @Override
    public void loadMoreItem() {
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {


                if(mAdapter.getNumberOfData() < 16) {
                    mAdapter.addDataLoadMore(CarRepo.getCars());
                    mAdapter.setLoaded();
                }
                else {
                    mAdapter.setNoHaveMoreData();
                }
            }
        },3000);
    }
}

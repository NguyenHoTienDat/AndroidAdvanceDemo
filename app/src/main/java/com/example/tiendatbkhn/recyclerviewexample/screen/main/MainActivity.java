package com.example.tiendatbkhn.recyclerviewexample.screen.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ActivityMainBinding;
import com.example.tiendatbkhn.recyclerviewexample.model.main.MainRepo;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;
import com.example.tiendatbkhn.recyclerviewexample.screen.asynctaskex.AsyncTaskActivity;
import com.example.tiendatbkhn.recyclerviewexample.screen.broadcast.BroadcastActivity;
import com.example.tiendatbkhn.recyclerviewexample.screen.notification.NotificationActivity;
import com.example.tiendatbkhn.recyclerviewexample.screen.recyclerviewex.RecyclerViewExActivity;
import com.example.tiendatbkhn.recyclerviewexample.screen.service.ServiceActivity;
import com.example.tiendatbkhn.recyclerviewexample.screen.viewpagerex.ViewPagerActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mViewModel = new MainViewModel();
        mViewModel.setAdapter(new ExampleAdapter(this,MainRepo.getExamples()));
        mViewModel.setView(this);

        initViewModel();
        mBinding.setViewModel(mViewModel);

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
    public void goRecyclerViewExample() {
        startActivity(new Intent(MainActivity.this, RecyclerViewExActivity.class));
    }

    @Override
    public void goViewPagerExample() {
        startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
    }

    @Override
    public void goAsyncTaskExample() {
        startActivity(new Intent(MainActivity.this, AsyncTaskActivity.class));
    }

    @Override
    public void goBroadcastExample() {
        startActivity(new Intent(MainActivity.this, BroadcastActivity.class));
    }

    @Override
    public void goNotificationExample() {
        startActivity(new Intent(MainActivity.this, NotificationActivity.class));
    }

    @Override
    public void goServiceExample() {
        startActivity(new Intent(MainActivity.this, ServiceActivity.class));
    }
}

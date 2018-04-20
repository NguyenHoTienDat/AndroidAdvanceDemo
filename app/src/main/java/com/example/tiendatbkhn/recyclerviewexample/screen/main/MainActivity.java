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
import com.example.tiendatbkhn.recyclerviewexample.screen.recyclerviewex.RecyclerViewExActivity;

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
}

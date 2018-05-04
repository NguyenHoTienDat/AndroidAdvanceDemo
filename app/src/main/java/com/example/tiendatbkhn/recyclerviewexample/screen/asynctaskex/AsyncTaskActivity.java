package com.example.tiendatbkhn.recyclerviewexample.screen.asynctaskex;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ActivityAsyncTaskBinding;

public class AsyncTaskActivity extends AppCompatActivity implements AsyncTaskContract.View {
    private ActivityAsyncTaskBinding mBinding;
    private AsyncTaskViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_async_task);
        mViewModel = new AsyncTaskViewModel();
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
    public void showMessage(String mes) {
        Toast.makeText(this, ""+mes, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.stopAsyncTask();
    }
}

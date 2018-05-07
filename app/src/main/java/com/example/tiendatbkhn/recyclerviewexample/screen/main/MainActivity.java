package com.example.tiendatbkhn.recyclerviewexample.screen.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

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
import com.example.tiendatbkhn.recyclerviewexample.util.Constant;

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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    Constant.MY_PERMISSIONS_REQUEST_STORAGE);

            return;
        }
        startActivity(new Intent(MainActivity.this, ServiceActivity.class));
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constant.MY_PERMISSIONS_REQUEST_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    goServiceExample();

                } else {
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}

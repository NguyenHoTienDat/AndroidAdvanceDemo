package com.example.tiendatbkhn.recyclerviewexample.screen.service;

import android.content.ContentResolver;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ActivityServiceBinding;
import com.example.tiendatbkhn.recyclerviewexample.model.servicemodel.Song;
import com.example.tiendatbkhn.recyclerviewexample.util.Constant;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity implements ServiceContract.View,
        ItemMusicViewModel.IItemMusicClick {
    private ServiceModel mViewModel;
    private ActivityServiceBinding mBinding;
    private ContentResolver mResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_service);

        mViewModel = new ServiceModel();
        mViewModel.setView(this);
        mResolver = getContentResolver();
        mViewModel.setResover(mResolver);
        mViewModel.setMusicAdapter(new MusicAdapter(this, new ArrayList<Song>(), this));
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
    public void onItemMusicClick(Song song) {
        Intent intent = new Intent(this,MusicService.class);
        intent.putExtra(Constant.MUSIC_KEY,song);
        startService(intent);
    }
}

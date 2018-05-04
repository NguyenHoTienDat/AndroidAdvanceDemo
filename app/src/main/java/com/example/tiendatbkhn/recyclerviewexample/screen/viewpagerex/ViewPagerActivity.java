package com.example.tiendatbkhn.recyclerviewexample.screen.viewpagerex;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ActivityViewPagerBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity implements ViewPagerContract.View {
    private ActivityViewPagerBinding mBinding;
    private ViewPagerViewModel mViewModel;
    private ViewPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_view_pager);

        mViewModel = new ViewPagerViewModel();
        mViewModel.setView(this);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentOne.getFragmentOneInstance());
        fragments.add(FragmentTwo.getFragmentTwoInstance());
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        mViewModel.setAdapter(mAdapter);

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
}

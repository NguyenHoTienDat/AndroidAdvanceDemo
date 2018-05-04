package com.example.tiendatbkhn.recyclerviewexample.screen.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ActivityBroadcastBinding;

public class BroadcastActivity extends AppCompatActivity implements BroadcastContract.View {
    private ActivityBroadcastBinding mBinding;
    private BroadcastViewModel mViewModel;
    private ChargeStateReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_broadcast);

        mReceiver = new ChargeStateReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mReceiver,filter);

        mViewModel = new BroadcastViewModel();
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

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    public class ChargeStateReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;
            mViewModel.setLightState(isCharging);
        }
    }
}

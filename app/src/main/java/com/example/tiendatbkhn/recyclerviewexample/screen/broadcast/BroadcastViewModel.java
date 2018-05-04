package com.example.tiendatbkhn.recyclerviewexample.screen.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;

/**
 * Created by tiendatbkhn on 04/05/2018.
 */

public class BroadcastViewModel extends BaseObservable implements BroadcastContract.ViewModel {
    private BroadcastContract.View mNavigator;
    private boolean mLightState;


    @Override
    public void onStartViewModel() {

    }

    @Override
    public void setView(BaseView baseView) {
        mNavigator = (BroadcastContract.View) baseView;
    }

    @Bindable
    public boolean isLightState() {
        return mLightState;
    }

    public void setLightState(boolean mLightState) {
        this.mLightState = mLightState;
        notifyPropertyChanged(BR.lightState);
    }


    @Override
    public void updateState(boolean state) {
        setLightState(state);
    }
}

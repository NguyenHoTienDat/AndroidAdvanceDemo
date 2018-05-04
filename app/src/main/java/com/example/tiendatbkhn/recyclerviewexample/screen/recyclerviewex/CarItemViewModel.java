package com.example.tiendatbkhn.recyclerviewexample.screen.recyclerviewex;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.model.main.Example;
import com.example.tiendatbkhn.recyclerviewexample.model.recyclerviewmodel.Car;
import com.example.tiendatbkhn.recyclerviewexample.screen.main.ExampleItemViewModel;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class CarItemViewModel extends BaseObservable {
    private Car mCar;
    private ExampleItemViewModel.ItemExampleClick itemExampleClick;

    public CarItemViewModel(Car car) {
        this.mCar = car;
    }

    @Bindable
    public Car getCar() {
        return mCar;
    }

    public void setCar(Car car) {
        this.mCar = car;
        notifyPropertyChanged(BR.car);
    }


}

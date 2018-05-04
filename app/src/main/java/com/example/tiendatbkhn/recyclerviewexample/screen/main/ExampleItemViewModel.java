package com.example.tiendatbkhn.recyclerviewexample.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.model.main.Example;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class ExampleItemViewModel extends BaseObservable {
    private Example mExample;
    private ItemExampleClick itemExampleClick;

    public ExampleItemViewModel(Example example, ItemExampleClick itemExampleClick) {
        this.mExample = example;
        this.itemExampleClick = itemExampleClick;
    }

    public void onExampleClick() {
        itemExampleClick.onExampleClick(mExample);
    }
    @Bindable
    public Example getExample() {
        return mExample;
    }

    public void setExample(Example example) {
        this.mExample = example;
        notifyPropertyChanged(BR.example);
    }

    public interface ItemExampleClick {
        void onExampleClick(Example obj);
    }
}

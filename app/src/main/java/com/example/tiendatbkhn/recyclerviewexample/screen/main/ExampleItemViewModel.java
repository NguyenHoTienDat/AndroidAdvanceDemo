package com.example.tiendatbkhn.recyclerviewexample.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.model.main.Example;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class ExampleItemViewModel extends BaseObservable {
    private Example example;
    private ItemExampleClick itemExampleClick;

    public ExampleItemViewModel(Example example, ItemExampleClick itemExampleClick) {
        this.example = example;
        this.itemExampleClick = itemExampleClick;
    }

    public void onExampleClick() {
        itemExampleClick.onExampleClick(example);
    }
    @Bindable
    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
        notifyPropertyChanged(BR.example);
    }

    public interface ItemExampleClick {
        void onExampleClick(Example obj);
    }
}

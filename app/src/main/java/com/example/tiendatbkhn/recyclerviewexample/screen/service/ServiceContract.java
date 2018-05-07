package com.example.tiendatbkhn.recyclerviewexample.screen.service;

import android.database.Cursor;

import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseViewModel;

/**
 * Created by tiendatbkhn on 07/05/2018.
 */

public interface ServiceContract {
    interface ViewModel extends BaseViewModel {
        void getMusicFromStorage();

        void showMusic(Cursor cursor);
    }

    interface View extends BaseView {

    }
}

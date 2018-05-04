package com.example.tiendatbkhn.recyclerviewexample.screen.asynctaskex;

import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseViewModel;

/**
 * Created by tiendatbkhn on 04/05/2018.
 */

public interface AsyncTaskContract {
    interface ViewModel extends BaseViewModel {
        void excuteAsyncTask();

        void stopAsyncTask();

        void updateData(int i);

        void onCancelClick();
    }

    interface View extends BaseView {
        void showMessage(String mes);
    }
}

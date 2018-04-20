package com.example.tiendatbkhn.recyclerviewexample.screen.main;

import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseViewModel;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public interface MainContract {

    interface ViewModel extends BaseViewModel {

        void getMainRepo();
    }

    interface View extends BaseView {
        void goRecyclerViewExample();
    }
}

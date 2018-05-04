package com.example.tiendatbkhn.recyclerviewexample.screen.broadcast;

import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseViewModel;

/**
 * Created by tiendatbkhn on 04/05/2018.
 */

public interface BroadcastContract {
    interface ViewModel extends BaseViewModel {
        void updateState(boolean state);
    }

    interface View extends BaseView {

    }
}

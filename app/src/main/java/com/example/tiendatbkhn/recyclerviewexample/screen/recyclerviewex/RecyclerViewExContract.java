package com.example.tiendatbkhn.recyclerviewexample.screen.recyclerviewex;

import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseViewModel;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public interface RecyclerViewExContract {

    interface ViewModel extends BaseViewModel{
        void onBackClick();

    }

    interface View extends BaseView {
        void loadMoreItem();
    }
}

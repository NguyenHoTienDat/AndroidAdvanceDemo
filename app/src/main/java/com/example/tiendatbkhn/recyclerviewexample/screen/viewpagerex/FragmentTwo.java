package com.example.tiendatbkhn.recyclerviewexample.screen.viewpagerex;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiendatbkhn.recyclerviewexample.R;

/**
 * Created by tiendatbkhn on 23/04/2018.
 */

public class FragmentTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two,container,false);
    }

    public static FragmentTwo getFragmentTwoInstance() {
        return new FragmentTwo();
    }
}

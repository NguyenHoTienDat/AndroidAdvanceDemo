package com.example.tiendatbkhn.recyclerviewexample.model.main;

import java.io.Serializable;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class Example implements Serializable{
    private int mId;
    private String mName;

    public Example(int mId,String mName) {
        this.mName = mName;
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }
}

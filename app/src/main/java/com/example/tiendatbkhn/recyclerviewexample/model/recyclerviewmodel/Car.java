package com.example.tiendatbkhn.recyclerviewexample.model.recyclerviewmodel;

import java.io.Serializable;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class Car implements Serializable{
    private String mName;
    private String mImage;

    public Car(String mName, String mImage) {
        this.mName = mName;
        this.mImage = mImage;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }
}

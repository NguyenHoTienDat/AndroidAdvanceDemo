package com.example.tiendatbkhn.recyclerviewexample.screen.service;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.app.AppCompatDelegate;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.model.servicemodel.Song;

/**
 * Created by tiendatbkhn on 07/05/2018.
 */

public class ItemMusicViewModel extends BaseObservable {
    private Song mSong;
    private IItemMusicClick itemMusicClick;

    public ItemMusicViewModel(Song mSong, IItemMusicClick itemMusicClick) {
        this.mSong = mSong;
        this.itemMusicClick = itemMusicClick;
    }

    public void onMusicClick() {
        itemMusicClick.onItemMusicClick(mSong);
    }

    @Bindable
    public Song getSong() {
        return mSong;
    }

    public void setSong(Song mSong) {
        this.mSong = mSong;
        notifyPropertyChanged(BR.song);
    }

    public interface IItemMusicClick {
        void onItemMusicClick(Song song);
    }
}

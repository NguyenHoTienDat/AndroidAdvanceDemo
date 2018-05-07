package com.example.tiendatbkhn.recyclerviewexample.screen.service;

import android.content.ContentResolver;
import android.database.Cursor;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.model.servicemodel.Song;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiendatbkhn on 07/05/2018.
 */

public class ServiceModel extends BaseObservable implements ServiceContract.ViewModel {
    private ServiceContract.View mNavigator;
    private MusicAdapter mMusicAdapter;
    private ContentResolver mResover;

    @Override
    public void onStartViewModel() {
        getMusicFromStorage();
    }

    @Override
    public void setView(BaseView baseView) {
        mNavigator = (ServiceContract.View) baseView;
    }

    @Override
    public void getMusicFromStorage() {
        String[] projections = new String[]{
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ALBUM,
        };

        Cursor cursor = mResover.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projections,
                null,
                null,
                MediaStore.Audio.Media.TITLE + " ASC"
        );

        ArrayList<Song> songs = new ArrayList<>();

        if (cursor != null) {
            showMusic(cursor);
        }

        cursor.close();
    }

    @Override
    public void showMusic(Cursor cursor) {
        List<Song> songs = new ArrayList<>();
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
        int indexData = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
        int indexAlbumId = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);

        cursor.moveToFirst();
        int tmpId = 1;
        while (!cursor.isAfterLast()) {
            String title = cursor.getString(indexTitle);
            String artist = cursor.getString(indexArtist);
            long duration = cursor.getLong(indexDuration);
            Uri data = Uri.parse(cursor.getString(indexData));
            String album = cursor.getString(indexAlbumId);

            if (duration > 180000) {
                songs.add(new Song(tmpId,title, artist, data, duration, album));
                tmpId++;
            }
            cursor.moveToNext();
        }
        mMusicAdapter.setData(songs);
        cursor.close();
    }

    @Bindable
    public MusicAdapter getMusicAdapter() {
        return mMusicAdapter;
    }

    public void setMusicAdapter(MusicAdapter mMusicAdapter) {
        this.mMusicAdapter = mMusicAdapter;
        notifyPropertyChanged(BR.musicAdapter);
    }

    public void setResover(ContentResolver mResover) {
        this.mResover = mResover;
    }
}

package com.example.tiendatbkhn.recyclerviewexample.screen.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.model.servicemodel.Song;
import com.example.tiendatbkhn.recyclerviewexample.util.Constant;

/**
 * Created by tiendatbkhn on 07/05/2018.
 */

public class MusicService extends Service {
    private Song mSong;
    private MediaPlayer mMediaPlayer;
    private int mCurrentSongId;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mCurrentSongId = -1;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.getBooleanExtra(Constant.MUSIC_PLAY_KEY, false)) {
            updateCurrentSong();
            return super.onStartCommand(intent, flags, startId);
        }

        if (intent.getBooleanExtra(Constant.MUSIC_CLOSE_KEY, false)) {
            stopMusicService();
            return super.onStartCommand(intent, flags, startId);
        }
        mSong = (Song) intent.getParcelableExtra(Constant.MUSIC_KEY);
        createNewSong();
        return super.onStartCommand(intent, flags, startId);
    }

    public void stopMusicService() {
        Log.e("ser", "stop");
        stopSelf();
        mMediaPlayer.pause();
        mMediaPlayer.release();
    }

    public void createNewSong() {
        if (mSong.getId() != mCurrentSongId || mCurrentSongId == -1){
            if (mMediaPlayer != null ) {
                mMediaPlayer.pause();
            }
            mMediaPlayer = MediaPlayer.create(this, mSong.getUri());
            mMediaPlayer.start();
            mCurrentSongId = mSong.getId();
            startForeground(mSong.getId(), buildNotification(true));
        }

    }

    public void updateCurrentSong() {
        Log.e("ser", "chay pause");
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            startForeground(mSong.getId(), buildNotification(false));
        } else {
            mMediaPlayer.start();
            startForeground(mSong.getId(), buildNotification(true));
        }

    }


    public Notification buildNotification(boolean isPlay) {
        Intent launchIntent = new Intent(this, ServiceActivity.class);
        PendingIntent launchPendingIntent =
                PendingIntent.getActivity(this, mSong.getId(), launchIntent, PendingIntent.FLAG_NO_CREATE);

        Intent updateIntent = new Intent(this, MusicService.class);
        updateIntent.putExtra(Constant.MUSIC_PLAY_KEY, true);
        PendingIntent updatePendingIntent =
                PendingIntent.getService(this, mSong.getId(), updateIntent, PendingIntent.FLAG_CANCEL_CURRENT);


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "channel")
                .setSmallIcon(R.drawable.light_on)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentTitle("" + mSong.getArtist())
                .setContentText("" + mSong.getName())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(launchPendingIntent);

        if (isPlay) {
            mBuilder.addAction(R.drawable.pause_icon, "pause",
                    updatePendingIntent);
        } else {
            mBuilder.addAction(R.drawable.play_icon, "play",
                    updatePendingIntent);
        }
        return mBuilder.build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

package com.example.tiendatbkhn.recyclerviewexample.model.servicemodel;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by tiendatbkhn on 07/05/2018.
 */

public class Song implements Parcelable {
    private String name;
    private String artist;
    private Uri uri;
    private long duration;
    private String album;
    private int id;

    public Song(int id, String name, String artist, Uri uri, long duration, String album) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.uri = uri;
        this.duration = duration;
        this.album = album;
    }

    protected Song(Parcel in) {
        name = in.readString();
        artist = in.readString();
        uri = in.readParcelable(Uri.class.getClassLoader());
        duration = in.readLong();
        album = in.readString();
        id = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(artist);
        dest.writeParcelable(uri, flags);
        dest.writeLong(duration);
        dest.writeString(album);
        dest.writeInt(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

}

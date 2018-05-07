package com.example.tiendatbkhn.recyclerviewexample.screen.service;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ItemMusicBinding;
import com.example.tiendatbkhn.recyclerviewexample.model.servicemodel.Song;

import java.util.List;

/**
 * Created by tiendatbkhn on 07/05/2018.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {
    private Context mCtx;
    private List<Song> mSongs;
    private ItemMusicViewModel.IItemMusicClick itemMusicClick;

    public MusicAdapter(Context mCtx, List<Song> mSongs, ItemMusicViewModel.IItemMusicClick itemMusicClick) {
        this.mCtx = mCtx;
        this.mSongs = mSongs;
        this.itemMusicClick = itemMusicClick;
    }

    @Override
    public MusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMusicBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mCtx),
                R.layout.item_music,
                parent,
                false
        );
        return new MusicHolder(binding);
    }

    @Override
    public void onBindViewHolder(MusicHolder holder, int position) {
        holder.setBinding(mSongs.get(position));
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public void setData(List<Song> songs) {
        mSongs.clear();
        mSongs.addAll(songs);
        notifyDataSetChanged();
    }

    public class MusicHolder extends RecyclerView.ViewHolder {
        private ItemMusicBinding mBinding;

        public MusicHolder(ItemMusicBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        public void setBinding(Song obj) {
            mBinding.setViewModel(new ItemMusicViewModel(obj, itemMusicClick));
            mBinding.executePendingBindings();
        }
    }
}

package com.example.tiendatbkhn.recyclerviewexample.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ItemExampleBinding;
import com.example.tiendatbkhn.recyclerviewexample.model.main.Example;

import java.util.List;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private List<Example> mExamples;
    private ExampleItemViewModel.ItemExampleClick itemExampleClick;

    public ExampleAdapter(Context mContext, List<Example> examples) {
        this.mContext = mContext;
        this.mExamples = examples;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemExampleBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_example,
                parent,
                false
        );
        return new ExampleViewHolder(binding,itemExampleClick);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        holder.setBinding(mExamples.get(position));
    }

    public void setItemExampleClick(ExampleItemViewModel.ItemExampleClick itemExampleClick) {
        this.itemExampleClick = itemExampleClick;
    }

    @Override
    public int getItemCount() {
        return mExamples.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        private ItemExampleBinding mBinding;
        private ExampleItemViewModel.ItemExampleClick itemExampleClick;
        public ExampleViewHolder(ItemExampleBinding binding,ExampleItemViewModel.ItemExampleClick itemExampleClick) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.itemExampleClick = itemExampleClick;
        }

        public void setBinding(Example example) {
            mBinding.setViewModel(new ExampleItemViewModel(example,itemExampleClick));
            mBinding.executePendingBindings();
        }
    }
}

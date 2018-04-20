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
    private List<Example> examples;
    private ExampleItemViewModel.ItemExampleClick itemExampleClick;

    public ExampleAdapter(Context mContext, List<Example> examples) {
        this.mContext = mContext;
        this.examples = examples;
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
        holder.setBinding(examples.get(position));
    }

    public void setItemExampleClick(ExampleItemViewModel.ItemExampleClick itemExampleClick) {
        this.itemExampleClick = itemExampleClick;
    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        private ItemExampleBinding binding;
        private ExampleItemViewModel.ItemExampleClick itemExampleClick;
        public ExampleViewHolder(ItemExampleBinding binding,ExampleItemViewModel.ItemExampleClick itemExampleClick) {
            super(binding.getRoot());
            this.binding = binding;
            this.itemExampleClick = itemExampleClick;
        }

        public void setBinding(Example example) {
            binding.setViewModel(new ExampleItemViewModel(example,itemExampleClick));
            binding.executePendingBindings();
        }
    }
}

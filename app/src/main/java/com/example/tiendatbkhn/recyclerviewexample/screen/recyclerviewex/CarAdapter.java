package com.example.tiendatbkhn.recyclerviewexample.screen.recyclerviewex;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ItemCarBinding;
import com.example.tiendatbkhn.recyclerviewexample.databinding.ItemExampleBinding;
import com.example.tiendatbkhn.recyclerviewexample.model.main.Example;
import com.example.tiendatbkhn.recyclerviewexample.model.recyclerviewmodel.Car;
import com.example.tiendatbkhn.recyclerviewexample.screen.main.ExampleAdapter;
import com.example.tiendatbkhn.recyclerviewexample.screen.main.ExampleItemViewModel;
import com.example.tiendatbkhn.recyclerviewexample.screen.main.MainActivity;

import java.util.List;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class CarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private Context mContext;
    private List<Car> mCars;
    private OnLoadMoreListener mOnLoadMoreListener;
    private RecyclerView rcCar;

    private boolean isLoad;
    private boolean isHaveMoreData;


    public CarAdapter(Context mContext, List<Car> cars) {
        this.mContext = mContext;
        this.mCars = cars;
        isLoad = false;
        isHaveMoreData = true;
        Log.e("car size : ",cars.size()+"");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_ITEM) {
            ItemCarBinding binding = DataBindingUtil.inflate(
                    LayoutInflater.from(mContext),
                    R.layout.item_car,
                    parent,
                    false
            );
            return new CarViewHolder(binding);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_load_more, parent, false);

            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CarViewHolder) {
            ((CarViewHolder)holder).setBinding(mCars.get(position));

        } else if (holder instanceof LoadingViewHolder){

            ((LoadingViewHolder) holder).progressBar.setVisibility( isHaveMoreData ?View.VISIBLE :View.GONE);
            ((LoadingViewHolder) holder).txtMoreData.setVisibility( isHaveMoreData ?View.GONE :View.VISIBLE);

        }

    }



    @Override
    public int getItemViewType(int position) {
        return (position == mCars.size()) ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return (mCars == null) ?0 :mCars.size() +1 ;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    public void setRcCar(RecyclerView rcCar) {
        this.rcCar = rcCar;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rcCar.getLayoutManager();
        rcCar.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int totalItemCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoad && totalItemCount <= (lastVisibleItem+1)) {
                    Log.e("adapter","run");
                    if (mOnLoadMoreListener != null) {
                        mOnLoadMoreListener.onLoadMore();
                    }

                    isLoad = true;
                }
            }
        });
    }

    public void setLoaded() {
        isLoad = false;
    }

    public void setNoHaveMoreData() {
        isHaveMoreData = false;
        notifyDataSetChanged();
    }

    public int getNumberOfData() {
        return mCars.size();
    }

    public void addDataLoadMore(List<Car> carMore) {
        this.mCars.addAll(carMore);
        notifyDataSetChanged();

    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        private ItemCarBinding mBinding;

        public CarViewHolder(ItemCarBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;

        }

        public void setBinding(Car car) {
            mBinding.setViewModel(new CarItemViewModel(car));
            mBinding.executePendingBindings();
        }
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;
        public TextView txtMoreData;
        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
            txtMoreData = itemView.findViewById(R.id.txt_more);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }


}

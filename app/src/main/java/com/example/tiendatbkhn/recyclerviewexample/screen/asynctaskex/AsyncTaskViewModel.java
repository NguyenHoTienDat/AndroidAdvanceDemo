package com.example.tiendatbkhn.recyclerviewexample.screen.asynctaskex;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.AsyncTask;

import com.example.tiendatbkhn.recyclerviewexample.BR;
import com.example.tiendatbkhn.recyclerviewexample.screen.BaseView;

/**
 * Created by tiendatbkhn on 04/05/2018.
 */

public class AsyncTaskViewModel extends BaseObservable implements AsyncTaskContract.ViewModel {
    private AsyncTaskContract.View mNavigator;
    private String mCurIndex;
    private MyAsyncTask mAsyncTask;
    private int mIndex;
    private boolean isRunning;

    @Override
    public void onStartViewModel() {
        excuteAsyncTask();
    }

    @Override
    public void setView(BaseView baseView) {
        this.mNavigator = (AsyncTaskContract.View) baseView;
    }

    @Override
    public void excuteAsyncTask() {
        mAsyncTask = new MyAsyncTask();
        mAsyncTask.execute();
        isRunning = true;
    }

    @Override
    public void stopAsyncTask() {
        if (mIndex != 10 && isRunning) {
            mAsyncTask.cancel(true);
            isRunning = false;
            mNavigator.showMessage("Load is Canceled");
        }
    }

    @Override
    public void updateData(int i) {
        setCurIndex(i+"");
        mIndex = i;
    }

    @Override
    public void onCancelClick() {
        stopAsyncTask();
    }

    @Bindable
    public String getCurIndex() {
        return mCurIndex;
    }

    public void setCurIndex(String mCurIndex) {
        this.mCurIndex = mCurIndex;
        notifyPropertyChanged(BR.curIndex);
    }

    public class MyAsyncTask extends AsyncTask<Void,Integer,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= 10; i++) {
                        if (isCancelled()) {
                            break;
                        } else {
                            try {
                                publishProgress(i);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            thread.run();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mNavigator.showMessage("Load Done");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            updateData(values[0]);
        }
    }
}

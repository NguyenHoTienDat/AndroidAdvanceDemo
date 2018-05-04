package com.example.tiendatbkhn.recyclerviewexample.util;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.tiendatbkhn.recyclerviewexample.R;
import com.example.tiendatbkhn.recyclerviewexample.screen.viewpagerex.ZoomOutPagerTranform;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class CustomBingdingAdapter {

    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(final RecyclerView recyclerView,
                                                 RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);

        AnimationSet set = new AnimationSet(true);

        // Fade in animation
        Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(400);
        fadeIn.setFillAfter(true);
        set.addAnimation(fadeIn);

        // Slide up animation from bottom of screen
        Animation slideUp = new TranslateAnimation(0, 0, 100, 0);
        slideUp.setInterpolator(new DecelerateInterpolator(4.f));
        slideUp.setDuration(800);
        set.addAnimation(slideUp);

        // Set up the animation controller              (second parameter is the delay)
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.2f);
        recyclerView.setLayoutAnimation(controller);
        /*recyclerView.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {

                    @Override
                    public boolean onPreDraw() {
                        recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);

                        for (int i = 0; i < recyclerView.getChildCount(); i++) {
                            View v = recyclerView.getChildAt(i);
                            v.setAlpha(0.0f);
                            v.animate().alpha(1.0f)
                                    .setDuration(300)
                                    .setStartDelay(i * 500)
                                    .start();
                        }

                        return true;
                    }
                });*/
    }


    /*@BindingAdapter({"layoutManager"})
    public static void setLayoutManager(RecyclerView recyclerView,
                                        LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }*/

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        if (url != null && url.length() > 0) {
            Picasso.with(view.getContext()).load(url).into(view);
        }
    }

    @BindingAdapter({"imageResource"})
    public static void loadImageResource(ImageView view, int res) {
        view.setImageResource(res);
    }

    @BindingAdapter({"imageUrl", "progressBar"})
    public static void loadImageWithProgressBar(final ImageView view, String url, final ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        if (url != null && url.length() > 0) {

            Picasso.with(view.getContext()).load(url).into(view, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    progressBar.setVisibility(View.GONE);
                    view.setImageResource(R.drawable.no_image);
                }
            });
        } else {
            progressBar.setVisibility(View.GONE);
            view.setImageResource(R.drawable.no_image);
        }
    }

    /**
     * use div 2 event scroll of recycleView and NestedScroll
     *
     * @param view
     * @param b
     */
    @BindingAdapter({"scroll"})
    public static void setScroll(RecyclerView view, boolean b) {
        view.setNestedScrollingEnabled(b);
    }

    @BindingAdapter({"imgSelected"})
    public static void setImgSelected(ImageView view, boolean b) {
        view.setSelected(b);
    }

    @BindingAdapter("viewSelected")
    public static void setSelectedView(View v, boolean b) {
        v.setSelected(b);
    }

    @BindingAdapter({"viewPagerAdater"})
    public static void setAdapterForViewPager(final ViewPager view, FragmentPagerAdapter pagerAdapter) {
        // final Wallet adapter = new MainActionsAdapter(view.getContext(), activity.getSupportFragmentManager());
        view.setAdapter(pagerAdapter);
        view.setPageTransformer(false, new ZoomOutPagerTranform());
    }

    @BindingAdapter({"slidePagerAdapter"})
    public static void setSlidePagerAdapter(ViewPager v, PagerAdapter adapter) {
        v.setAdapter(adapter);
    }

    @BindingAdapter({"vpCurrentTab"})
    public static void setVpCurrentTab(ViewPager view, int pos) {
        view.setCurrentItem(pos, true);
    }

    @BindingAdapter("viewPager")
    public static void setViewPagerForTablayout(TabLayout tablayout, ViewPager viewPager) {
        tablayout.setupWithViewPager(viewPager);
    }


    @BindingAdapter("cbInit")
    public static void checkBoxInit(CheckBox view, boolean b) {
        view.setChecked(b);

    }

    @BindingAdapter("lightState")
    public static void setLightState(ImageView view, boolean state) {
        if (state) {
            view.setImageResource(R.drawable.light_on);
        } else {
            view.setImageResource(R.drawable.light_off);
        }

    }

}

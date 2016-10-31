package com.example.mzninegridview.activity;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import com.alibaba.fastjson.JSON;
import com.example.mzninegridview.ImageInfo;
import com.example.mzninegridview.widget.PhotoViewPager;
import com.example.mzninegridview.R;
import com.example.mzninegridview.fragment.PhotoFragment;
import com.example.mzninegridview.widget.SmoothPhotoView;
import com.example.mzninegridview.widget.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by song
 * on 2016-10-17 上午11:25.
 */

public class PhotoActivity extends FragmentActivity implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final String IMG_URLS = "imgUrls";
    public static final String BOUNDS = "bounds";
    public static final String INDEX = "index";

    private PhotoViewPager viewPager;
    private List<ImageInfo> imgUrls;
    private List<Rect> rects;
    private ArrayList<PhotoFragment> fragments;
    private int index;
    private PhotoFragmentAdapter adapter;
    private ViewPagerIndicator indicator;
    private View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_photo);
        root = findViewById(R.id.root);
        viewPager = (PhotoViewPager) findViewById(R.id.viewpager);
        indicator = (ViewPagerIndicator) findViewById(R.id.vp_indicator);

        String temp = getIntent().getStringExtra(IMG_URLS);
        imgUrls = JSON.parseArray(temp, ImageInfo.class);
        String tempRect = getIntent().getStringExtra(BOUNDS);
        rects = JSON.parseArray(tempRect, Rect.class);
        index = getIntent().getIntExtra(INDEX, 0);

        if (rects == null || imgUrls == null) {
            finish();
        } else {
            adapter = new PhotoFragmentAdapter(getSupportFragmentManager());
            fragments = new ArrayList<>();
            int rectSize = rects.size();
            for (int i = 0; i < imgUrls.size(); i++) {
                PhotoFragment fragment = new PhotoFragment();
                Bundle bundle = new Bundle();
                bundle.putString(PhotoFragment.IMG_URL, imgUrls.get(i).getThumbnailUrl());

                int tempIndex = i < rectSize ? i : rectSize - 1;
                bundle.putParcelable(PhotoFragment.IMG_STAT_BOUNDS, rects.get(tempIndex));
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
            viewPager.setAdapter(adapter);
            viewPager.getViewTreeObserver().addOnGlobalLayoutListener(this);
            indicator.setViewPager(viewPager);
            indicator.refreshIndicator(fragments.size());
            viewPager.setCurrentItem(index);
        }
    }


    @Override
    public void onGlobalLayout() {
        PhotoFragment fragment = fragments.get(index);
        fragment.transformIn(new SmoothPhotoView.onTransformListener() {

            @Override
            public void onTransformCompleted(SmoothPhotoView.Status status) {
                root.setBackgroundColor(Color.BLACK);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            viewPager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            viewPager.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    private class PhotoFragmentAdapter extends FragmentPagerAdapter {

        PhotoFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments == null ? 0 : fragments.size();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            transformOut();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void transformOut() {
        int currentIndex = viewPager.getCurrentItem();
            PhotoFragment fragment = fragments.get(currentIndex);
            indicator.setVisibility(View.GONE);
            root.setBackgroundColor(Color.TRANSPARENT);
            fragment.transformOut(new SmoothPhotoView.onTransformListener() {
                @Override
                public void onTransformCompleted(SmoothPhotoView.Status status) {
                    finish();
                    PhotoActivity.this.overridePendingTransition(0, 0);
                }
            });
    }
}


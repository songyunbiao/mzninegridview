package com.example.mywechat.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mywechat.ImageInfo;
import com.example.mywechat.R;

import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by song
 * on 2016-10-12 下午3:38.
 */

public class PictureActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE_URL = "image_url";

    //    public static final String IMAGE_INFO = "IMAGE_INFO";
    public static final String CURRENT_ITEM = "CURRENT_ITEM";
    public static final String TRANSIT_PIC = "picture";
    List<ImageInfo> mImageUrl;
    PhotoViewAttacher mPhotoViewAttacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        setContentView(R.layout.activity_picture);
        String temp = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        mImageUrl = JSON.parseArray(temp, ImageInfo.class);
        int index = getIntent().getIntExtra(CURRENT_ITEM, 0);

        PhotoView photoView = (PhotoView) findViewById(R.id.picture);
//        ViewCompat.setTransitionName(findViewById(R.id.rootView), TRANSIT_PIC + index);
        ViewCompat.setTransitionName(photoView, TRANSIT_PIC + index);
        Glide.with(this)
                .load(mImageUrl.get(index).getThumbnailUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(photoView);

        mPhotoViewAttacher = new PhotoViewAttacher(photoView);
        mPhotoViewAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                ActivityCompat.finishAfterTransition(PictureActivity.this);
            }
        });

//        Glide.with(this).load(mImageUrl).listener(new RequestListener<String, GlideDrawable>() {
//            @Override
//            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                mPhotoViewAttacher.update();
//                return false;
//            }
//        }).into(imageView);

    }

    @Override
    protected void onDestroy() {
        Log.e("TAG", "onDestroy");
        mPhotoViewAttacher.cleanup();
        super.onDestroy();
    }
}

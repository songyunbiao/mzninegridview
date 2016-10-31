//package com.example.mywechat.activity;
//
//import android.graphics.Rect;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.ActivityCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewTreeObserver;
//import android.view.Window;
//
//import com.alibaba.fastjson.JSON;
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.example.mywechat.ImageInfo;
//import com.example.mywechat.R;
//import com.example.mywechat.widget.SmoothPhotoView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import uk.co.senab.photoview.PhotoView;
//import uk.co.senab.photoview.PhotoViewAttacher;
//
///**
// * Created by song
// * on 2016-10-12 下午3:38.
// */
//
//public class PictureActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener{
//    private static final String TAG = PictureActivity.class.getSimpleName();
//    public static final String EXTRA_IMAGE_URL = "image_url";
//
//    //    public static final String IMAGE_INFO = "IMAGE_INFO";
//    public static final String CURRENT_ITEM = "CURRENT_ITEM";
//    public static final String TRANSIT_PIC = "picture";
//    public static final String BOUNDS = "bounds";
//
//    private int index;
//    private List<Rect> rects;
//    private SmoothPhotoView photoView;
//    List<ImageInfo> mImageUrl;
//    PhotoViewAttacher mPhotoViewAttacher;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_picture);
//        String temp = getIntent().getStringExtra(EXTRA_IMAGE_URL);
//        mImageUrl = JSON.parseArray(temp, ImageInfo.class);
//        index = getIntent().getIntExtra(CURRENT_ITEM, 0);
//
//        String tempRect = getIntent().getStringExtra(BOUNDS);
//        rects = JSON.parseArray(tempRect, Rect.class);
//        Log.e(TAG, String.valueOf(rects.get(index)));
//        photoView = (SmoothPhotoView) findViewById(R.id.picture);
////        ViewCompat.setTransitionName(photoView, TRANSIT_PIC + index);
//        Glide.with(this)
//                .load(mImageUrl.get(index).getThumbnailUrl())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(photoView);
//
//        this.findViewById(android.R.id.content).getViewTreeObserver().addOnGlobalLayoutListener(this);
//
//        mPhotoViewAttacher = new PhotoViewAttacher(photoView);
//        mPhotoViewAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
//            @Override
//            public void onViewTap(View view, float x, float y) {
//                ActivityCompat.finishAfterTransition(PictureActivity.this);
//            }
//        });
//
////        Glide.with(this).load(mImageUrl).listener(new RequestListener<String, GlideDrawable>() {
////            @Override
////            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
////                return false;
////            }
////
////            @Override
////            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
////                mPhotoViewAttacher.update();
////                return false;
////            }
////        }).into(imageView);
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        Log.e("TAG", "onDestroy");
//        mPhotoViewAttacher.cleanup();
//        super.onDestroy();
//    }
//
//    @Override
//    public void onGlobalLayout() {
//        photoView.transformIn(rects.get(index), new SmoothPhotoView.onTransformListener() {
//            @Override
//            public void onTransformCompleted(SmoothPhotoView.Status status) {
//                Log.e(TAG, "transformIn success!");
//            }
//        });
//    }
//}

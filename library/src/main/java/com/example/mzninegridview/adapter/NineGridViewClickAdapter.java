//package com.example.mzninegridview.adapter;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Rect;
//import android.view.View;
//
//import com.alibaba.fastjson.JSON;
//import com.example.mzninegridview.ImageInfo;
//import com.example.mzninegridview.activity.PhotoActivity;
//import com.example.mzninegridview.adapter.NineGridViewAdapter;
//import com.example.mzninegridview.widget.NineGridView;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by song
// * on 2016-10-31 下午2:40.
// */
//
//public class NineGridViewClickAdapter extends NineGridViewAdapter {
//
//    private int statusHeight;
//    private Activity mActivity;
//    private List<ImageInfo> imageUrls;
//
//    public NineGridViewClickAdapter(Activity activity, List<ImageInfo> imageInfo) {
//        super(activity, imageInfo);
//        mActivity = activity;
//        imageUrls = imageInfo;
//        statusHeight = getStatusHeight(activity);
//    }
//
//    @Override
//    public void onImageItemClick(Context context, NineGridView nineGridView, int index, List<ImageInfo> imageInfo) {
//
//        startPictureActivity(nineGridView, index);
//    }
//
//    private void startPictureActivity(NineGridView nineGridView, int index) {
//        ArrayList<Rect> rects = new ArrayList<>();
//        for (int i = 0; i < nineGridView.getChildCount(); i++) {
//            Rect rect = new Rect();
//            View child = nineGridView.getChildAt(i);
//            child.getGlobalVisibleRect(rect);
//            rects.add(rect);
//        }
//
//        Intent intent = new Intent(mActivity, PhotoActivity.class);
//        intent.putExtra(PhotoActivity.IMG_URLS, JSON.toJSONString(imageUrls));
//        intent.putExtra(PhotoActivity.INDEX, index);
//        intent.putExtra(PhotoActivity.BOUNDS, JSON.toJSONString(rects));
//        mActivity.startActivity(intent);
//        mActivity.overridePendingTransition(0, 0);
//    }
//
//    /**
//     * 获得状态栏的高度
//     */
//    private int getStatusHeight(Context context) {
//        int statusHeight = -1;
//        try {
//            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
//            Object object = clazz.newInstance();
//            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
//            statusHeight = context.getResources().getDimensionPixelSize(height);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return statusHeight;
//    }
//
////    private void startPictureActivity(NineGridView nineGridView, int index) {
////        ArrayList<Rect> rects = new ArrayList<>();
////        for (int i = 0; i < 9; i++) {
////            Rect rect = new Rect();
////            View child = nineGridView.getChildAt(i);
////            child.getGlobalVisibleRect(rect);
////            rects.add(rect);
////        }
////        Log.e(TAG, "old " + String.valueOf(rects.get(index)));
////
////        Intent intent = new Intent(mActivity, PictureActivity.class);
////        intent.putExtra(PictureActivity.EXTRA_IMAGE_URL, JSON.toJSONString(imageUrls));
////        intent.putExtra(PictureActivity.CURRENT_ITEM, index);
////        intent.putExtra(PhotoActivity.BOUNDS, JSON.toJSONString(rects));
////        mActivity.startActivity(intent);
////        mActivity.overridePendingTransition(0, 0);
////    }
//}

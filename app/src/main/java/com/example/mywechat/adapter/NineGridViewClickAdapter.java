package com.example.mywechat.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.mywechat.ImageInfo;
import com.example.mywechat.activity.PictureActivity;
import com.example.mywechat.widget.NineGridView;
import java.util.List;

import static android.content.ContentValues.TAG;

public class NineGridViewClickAdapter extends NineGridViewAdapter {

    private int statusHeight;
    private Activity mActivity;
    private List<ImageInfo> imageUrls;
    public NineGridViewClickAdapter(Activity activity, List<ImageInfo> imageInfo) {
        super(activity, imageInfo);
        mActivity = activity;
        imageUrls = imageInfo;
        statusHeight = getStatusHeight(activity);
    }

    @Override
    public void onImageItemClick(Context context, NineGridView nineGridView, int index, List<ImageInfo> imageInfo) {
//        for (int i = 0; i < imageInfo.size(); i++) {
//            ImageInfo info = imageInfo.get(i);
//            View imageView;
//            if (i < nineGridView.getMaxSize()) {
//                imageView = nineGridView.getChildAt(i);
//            } else {
//                //如果图片的数量大于显示的数量，则超过部分的返回动画统一退回到最后一个图片的位置
//                imageView = nineGridView.getChildAt(nineGridView.getMaxSize() - 1);
//            }
//            info.imageViewWidth = imageView.getWidth();
//            info.imageViewHeight = imageView.getHeight();
//            int[] points = new int[2];
//            imageView.getLocationInWindow(points);
//            info.imageViewX = points[0];
//            info.imageViewY = points[1] - statusHeight;
//        }

//        Intent intent = new Intent(context, ImagePreviewActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(ImagePreviewActivity.IMAGE_INFO, (Serializable) imageInfo);
//        bundle.putInt(ImagePreviewActivity.CURRENT_ITEM, index);
//        intent.putExtras(bundle);
//        context.startActivity(intent);
//        ((Activity) context).overridePendingTransition(0, 0);
        startPictureActivity(nineGridView.getChildAt(index), index);
    }

    private void startPictureActivity(View transitView, int index) {
        Log.e(TAG, "index " + index);
        Intent intent = new Intent(mActivity, PictureActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                mActivity, transitView, PictureActivity.TRANSIT_PIC + index);
        intent.putExtra(PictureActivity.EXTRA_IMAGE_URL, JSON.toJSONString(imageUrls));
        intent.putExtra(PictureActivity.CURRENT_ITEM, index);
        try {
            ActivityCompat.startActivity(mActivity, intent, optionsCompat.toBundle());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            mActivity.startActivity(intent);
        }
    }

    /**
     * 获得状态栏的高度
     */
    private int getStatusHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }
}

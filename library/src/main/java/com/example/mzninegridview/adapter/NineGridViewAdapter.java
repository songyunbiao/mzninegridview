package com.example.mzninegridview.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.example.mzninegridview.widget.NineGridViewWrapper;

import java.util.List;

/**
 * Created by song
 * on 2016-10-31 下午2:39.
 */
public class NineGridViewAdapter{

    protected Context context;

    public NineGridViewAdapter(Context context) {
        this.context = context;
    }

    /**
     * 生成ImageView容器的方式，默认使用NineGridImageViewWrapper类，即点击图片后，图片会有蒙板效果
     * 如果需要自定义图片展示效果，重写此方法即可
     *
     * @param context 上下文
     * @return 生成的 ImageView
     */
    public ImageView generateImageView(Context context) {
        NineGridViewWrapper imageView = new NineGridViewWrapper(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }
}

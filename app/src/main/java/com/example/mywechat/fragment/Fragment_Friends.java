package com.example.mywechat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mywechat.ImageInfo;
import com.example.mywechat.R;
import com.example.mywechat.adapter.NineGridViewClickAdapter;
import com.example.mywechat.widget.NineGridView;

import java.util.ArrayList;
import java.util.List;

//通讯录
public class Fragment_Friends extends Fragment {
    private String TAG = Fragment_Friends.class.getSimpleName();
    private View layout;
    List<ImageInfo> imageUrls = new ArrayList<>();
    ImageInfo imageInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_friends, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww4.sinaimg.cn/large/7a8aed7bgw1ewsip9thfoj20hs0qo774.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww1.sinaimg.cn/large/7a8aed7bgw1esahpyv86sj20hs0qomzo.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww1.sinaimg.cn/large/610dc034jw1f8kmud15q1j20u011hdjg.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww2.sinaimg.cn/large/7a8aed7bgw1ex66r1sk5wj20et0m8q4q.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww2.sinaimg.cn/large/7a8aed7bjw1exfffnlf2gj20hq0qoju9.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww3.sinaimg.cn/large/7a8aed7bgw1ewy3cst6rzj20lx0v4wj5.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww1.sinaimg.cn/large/610dc034jw1f7lughzrjmj20u00k9jti.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww1.sinaimg.cn/large/610dc034jw1f8a5uj64mpj20u00u0tca.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww1.sinaimg.cn/large/610dc034jw1f867mvc6qjj20u00u0wh7.jpg");
        imageUrls.add(imageInfo);

        imageInfo = new ImageInfo();
        imageInfo.setThumbnailUrl("http://ww1.sinaimg.cn/large/610dc034jw1f7qgschtz8j20hs0hsac7.jpg");
        imageUrls.add(imageInfo);

        NineGridView nineGridView = (NineGridView) layout.findViewById(R.id.nine_grid_view);
        nineGridView.setAdapter(new NineGridViewClickAdapter(getActivity(), imageUrls));

//        ImageView imageView = (ImageView) layout.findViewById(R.id.grid_view);
//        Glide.with(getActivity())
//                .load(imageUrls.get(0).getThumbnailUrl())
//                .error(R.mipmap.ic_launcher)
//                .listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        Log.e(TAG, "onException " + e);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        Log.e(TAG, "onResourceReady ");
//
//                        return false;
//                    }
//                })
//                .into(imageView);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startPictureActivity(view);
//            }
//        });
    }

//    private void startPictureActivity(View transitView) {
//        ArrayList<Rect> rects = new ArrayList<>();
//        for (int i = 0; i < 1; i++) {
//            Rect rect = new Rect();
//            View child = transitView;
//            child.getGlobalVisibleRect(rect);
//            rects.add(rect);
//        }
//
//        Intent intent = new Intent(getActivity(), PhotoActivity.class);
//        intent.putExtra(PhotoActivity.IMG_URLS, JSON.toJSONString(imageUrls));
//        intent.putExtra(PhotoActivity.INDEX, 0);
//        intent.putExtra(PhotoActivity.BOUNDS, JSON.toJSONString(rects));
//        getActivity().startActivity(intent);
//        getActivity().overridePendingTransition(0, 0);
//    }

// private void startPictureActivity(View transitView) {
//        Intent intent = new Intent(getContext(), PictureActivity.class);
//        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                getActivity(), transitView, PictureActivity.TRANSIT_PIC);
//        intent.putExtra(PictureActivity.EXTRA_IMAGE_URL, url);
//        try {
//            ActivityCompat.startActivity(getActivity(), intent, optionsCompat.toBundle());
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            startActivity(intent);
//        }
//    }
}

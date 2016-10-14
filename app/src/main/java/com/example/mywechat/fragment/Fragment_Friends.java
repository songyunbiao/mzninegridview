package com.example.mywechat.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mywechat.ImageInfo;
import com.example.mywechat.R;
import com.example.mywechat.activity.PictureActivity;
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

        NineGridView.setImageLoader(new GlideImageLoader());
        NineGridView nineGridView = (NineGridView) layout.findViewById(R.id.nine_grid_view);
        nineGridView.setAdapter(new NineGridViewClickAdapter(getActivity(), imageUrls));


//        Glide.with(getContext())
//                .load(url)
//                .into(imageView);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startPictureActivity(view);
//            }
//        });
    }


    /** Glide 加载 */
    private class GlideImageLoader implements NineGridView.ImageLoader {
        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            Glide.with(context).load(url)//
                    .placeholder(R.drawable.ic_default_color)//
                    .error(R.drawable.ic_default_color)//
                    .into(imageView);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }

//    private void startPictureActivity(View transitView) {
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

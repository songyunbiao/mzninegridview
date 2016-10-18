package com.example.mywechat.fragment;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mywechat.R;
import com.example.mywechat.activity.PhotoActivity;
import com.example.mywechat.widget.SmoothPhotoView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by song
 * on 2016-10-17 上午11:25.
 */
public class PhotoFragment extends Fragment {
	public static final  String IMG_URL = "img_url";
	public static final  String IMG_STAT_BOUNDS = "img_start_Bounds";
	private SmoothPhotoView ivPhoto;
	private Rect startBounds;
	private Activity activity;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_photo,null);
		activity = getActivity();
		ivPhoto = (SmoothPhotoView)rootView.findViewById(R.id.iv_photo);
		ivPhoto.setMinimumScale(0.5f);
		ivPhoto.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
			@Override
			public void onViewTap(View view, float x, float y) {
				((PhotoActivity)activity).transformOut();
			}
		});
		Bundle args = getArguments();
		if(args !=null && args.containsKey(IMG_URL)){
			String imgUrl = args.getString(IMG_URL);
			startBounds = args.getParcelable(IMG_STAT_BOUNDS);
			//TODO
			Glide.with(getActivity())
					.load(imgUrl)//
					.into(ivPhoto);
		}
		return rootView;
	}

	public void transformIn(SmoothPhotoView.onTransformListener listener){
		ivPhoto.transformIn(startBounds,listener);
	}

	public void transformOut(SmoothPhotoView.onTransformListener listener){
		ivPhoto.transformOut(startBounds,listener);
	}
}

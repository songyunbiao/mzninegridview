package com.example.mywechat.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywechat.R;

//我
public class Fragment_Profile extends Fragment {
	private View layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		layout = inflater.inflate(R.layout.fragment_profile, container, false);

		return layout;
	}

}
package com.spc.fragment;
import com.example.dg.R;
import com.spc.activity.MainActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class MenuFragment extends Fragment implements OnClickListener{

	private FragmentManager fragmentManager;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frame_left, container, false);
		fragmentManager = ((MainActivity) getActivity()).getFragmentManager();
		initUI(view);
		initData();
		return view;
	}

	private void initData() {
		
	}
	
	private void initUI(View view) {
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	

}

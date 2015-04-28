package com.spc.fragment;

import com.example.dg.R;
import com.spc.activity.CompanyActivity;
import com.spc.activity.LoginActivity;
import com.spc.activity.MainActivity;
import com.spc.activity.QueryCompanyAty;
import com.spc.activity.RegisterActivity;
import com.spc.util.DataRequest;
import com.spc.util.FileUtil;
import com.spc.util.MyUtil;
import com.spc.view.progressbutton.CircularProgressButton;

import android.animation.ValueAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class ContentFragment extends Fragment implements OnClickListener{

	private FragmentManager fragmentManager;
	private CircularProgressButton bt_upload;
	private CircularProgressButton bt_download;
	private Button btLogin;
	private Button btRegister;
	private Button btAddCpn;
	private Button btQuery;
	private Button btDelete;
	private Button btUpdate;
	private Context mContext;
	private LinearLayout ll_image;
	private CircularProgressButton bt_delete_file;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.content_frg, container, false);
		fragmentManager = ((MainActivity) getActivity()).getFragmentManager();
		initUI(view);
		initData();
		return view;
	}

	private void initData() {

	}

	private void initUI(View view) {
		mContext=getActivity();
		btLogin=(Button)view.findViewById(R.id.button1);
		btRegister=(Button)view.findViewById(R.id.button2);
		btAddCpn=(Button)view.findViewById(R.id.button3);
		btQuery=(Button)view.findViewById(R.id.button4);
		btDelete=(Button)view.findViewById(R.id.button5);
		btUpdate=(Button)view.findViewById(R.id.button6);
		bt_upload=(CircularProgressButton)view.findViewById(R.id.bt_upload);
		bt_download=(CircularProgressButton)view.findViewById(R.id.bt_download);
		bt_delete_file=(CircularProgressButton)view.findViewById(R.id.bt_delete_file);
		ll_image=(LinearLayout)view.findViewById(R.id.ll_image);
		btLogin.setOnClickListener(this);
		btRegister.setOnClickListener(this);
		btAddCpn.setOnClickListener(this);
		btQuery.setOnClickListener(this);
		btDelete.setOnClickListener(this);
		btUpdate.setOnClickListener(this);
		bt_upload.setOnClickListener(this);
		bt_download.setOnClickListener(this);
		bt_delete_file.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.button1:
			MyUtil.skipToNextActiivty(getActivity(), LoginActivity.class);
			break;
		case R.id.button2:
			MyUtil.skipToNextActiivty(getActivity(), RegisterActivity.class);

			break;
		case R.id.button3:
			MyUtil.skipToNextActiivty(getActivity(), CompanyActivity.class);

			break;
		case R.id.button4:
			MyUtil.skipToNextActiivty(getActivity(), QueryCompanyAty.class);
			break;
		case R.id.button5:
			DataRequest.getInstance().deleteCompany("百度",mContext);

			break;
		case R.id.button6:

			break;
		case R.id.bt_upload:
			FileUtil.uploadFile("test.png", bt_upload);
			break;
		case R.id.bt_download:
			FileUtil.downFile(mContext,"test.png", ll_image,bt_download);
			break;
		case R.id.bt_delete_file:
			FileUtil.deleteFile(bt_delete_file,"test.png");
			break;

		default:
			break;
		}
	}

	/**
	 * 成功
	 */
	private void simulateSuccessProgress(final CircularProgressButton button) {
		ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 100);
		widthAnimation.setDuration(1500);
		widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Integer value = (Integer) animation.getAnimatedValue();
				button.setProgress(value);
			}
		});
		widthAnimation.start();
	}
}

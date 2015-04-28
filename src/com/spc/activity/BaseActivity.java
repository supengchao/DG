package com.spc.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;

public abstract class BaseActivity extends Activity implements OnClickListener{
	
	public abstract void initView();
	public abstract void initData();
}

package com.spc.app;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.spc.bean.Company;

import android.app.Application;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		initApp();
	}
	/**
	 * 
	 * 苏鹏超创建于20152015-4-11下午4:10:57
	 * void APP初始化
	 * TODO
	 */
	private void initApp() {
		AVObject.registerSubclass(Company.class);
		AVOSCloud.initialize( getApplicationContext(), Constant.AppId, Constant.AppKey);
		
	}
	
	
}

package com.spc.app;

import com.spc.bean.User;

public enum UserManager {
	INSTANCE;
	private boolean isLogin = false;//�û��Ƿ��¼
	private User user=null;
	
	
	
	

	 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
	
}

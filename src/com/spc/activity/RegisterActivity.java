package com.spc.activity;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SignUpCallback;
import com.example.dg.R;
import com.spc.bean.User;
import com.spc.util.MyUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * 
 * @author 苏鹏超创建于2015-4-11下午3:59:24
 * TODO	用户注册界面
 */
public class RegisterActivity extends BaseActivity {

	private EditText et_username;
	private EditText et_email;
	private EditText et_psw;
	private Button bt_register;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_register);
		mContext=RegisterActivity.this;
		initView();
		initData();
	}

	@Override
	public void initView() {
		et_username=(EditText)findViewById(R.id.et_username);
		et_email=(EditText)findViewById(R.id.et_email);
		et_psw=(EditText)findViewById(R.id.et_psw);
		bt_register=(Button)findViewById(R.id.bt_register);
		bt_register.setOnClickListener(this);
		
	}

	@Override
	public void initData() {
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bt_register:
			if(MyUtil.isEmptyEditText(et_username)){
				MyUtil.toast(mContext, "请输入用户名 ！");
				return;
			}
			if(MyUtil.isEmptyEditText(et_psw)){
				MyUtil.toast(mContext, "请输入密码 ！");
				return;
			}
			if(MyUtil.isEmptyEditText(et_email)){
				MyUtil.toast(mContext, "请输入Email！");
				return;
			}
			User  mUser = new User();
			mUser.setUsername(MyUtil.getEtString(et_username));
			mUser.setPassword(MyUtil.getEtString(et_psw));
			mUser.setEmail(MyUtil.getEtString(et_email));
			mUser.signUpInBackground(new SignUpCallback() {
				
				@Override
				public void done(AVException arg0) {
					if(arg0==null){
						MyUtil.toast(mContext, "欢迎"+MyUtil.getEtString(et_username)+"加入DG!");
						Intent intent = new Intent(mContext,LoginActivity.class);
						startActivity(intent);
					}else{
						MyUtil.toast(mContext, "出错了！---"+arg0.getMessage());
					}
				}
			});
			break;

		default:
			break;
		}
	}
}

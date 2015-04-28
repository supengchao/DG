package com.spc.activity;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.RequestPasswordResetCallback;
import com.example.dg.R;
import com.spc.app.UserManager;
import com.spc.bean.User;
import com.spc.util.CommonUtil;
import com.spc.util.MyUtil;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
/**
 * 
 * @author 苏鹏超创建于2015-4-11下午3:58:47
 * TODO  登录界面
 */
public class LoginActivity extends BaseActivity  {

	private EditText et_login_username;
	private EditText et_login_psw;
	private Button bt_login;
	private Context mContext;
	private Button bt_logout;
	private Button bt_forget_psw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_login);
		mContext=LoginActivity.this;
		initView();
		initData();
	}

	@SuppressWarnings("static-access")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login:
			if(UserManager.INSTANCE.getUser()!=null&&UserManager.INSTANCE.getUser().getCurrentUser()!=null){
				MyUtil.toast(mContext, UserManager.INSTANCE.getUser().getCurrentUser().getUsername()+"已经登录，如果想更换账号登陆，请点击注销后，再次登录！");
			}else{

				if(MyUtil.isEmptyEditText(et_login_username)){
					MyUtil.toast(mContext, "请输入用户名 ！");
					return;
				}
				if(MyUtil.isEmptyEditText(et_login_psw)){
					MyUtil.toast(mContext, "请输入密码 ！");
					return;
				}
				User user = new User();
				UserManager.INSTANCE.setUser(user);
				user.logInInBackground(MyUtil.getEtString(et_login_username), MyUtil.getEtString(et_login_psw), new LogInCallback<AVUser>() {

					@Override
					public void done(AVUser arg0, AVException arg1) {
						if(arg0!=null){
							MyUtil.toast(mContext, arg0.getUsername()+"登录成功");
						}else{
							MyUtil.toast(mContext, "登录失败，请检查用户名、密码是否正确！"+arg1.getMessage());
						}
					}
				});
			}
			break;
		case R.id.bt_logout:
			if(UserManager.INSTANCE.getUser()!=null&&UserManager.INSTANCE.getUser().getCurrentUser()!=null){
				MyUtil.toast(mContext, UserManager.INSTANCE.getUser().getCurrentUser().getUsername()+"已经注销登录！");
				UserManager.INSTANCE.getUser().getCurrentUser().logOut();
			}else{

			}

			break;
		case R.id.bt_forget_psw:
			Builder dialog=null;
			LayoutInflater inflater = LayoutInflater.from(mContext);
			View view = inflater.inflate(R.layout.dialog_alert, null);
			final EditText et_dialog_alert=(EditText)view.findViewById(R.id.et_dialog_alert);
			Button bt_ok=(Button)view.findViewById(R.id.bt_ok);
			if(dialog==null){
				dialog = new AlertDialog.Builder(mContext,AlertDialog.THEME_HOLO_LIGHT);
			}
			dialog.setView(view);
			dialog.setCancelable(true);
			dialog.show();
			bt_ok.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if(!MyUtil.isEmptyEditText(et_dialog_alert)){
						String email=MyUtil.getEtString(et_dialog_alert);
						AVUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {

							@Override
							public void done(AVException e) {
								if (e == null) {
									MyUtil.toast(mContext, "发送成功，请尽快登录邮箱重置密码！");
								} else {
									MyUtil.toast(mContext, "请检查输入邮箱的格式是否正确！");
								}

							}
						});
					}else{
						MyUtil.toast(mContext, "请输入邮箱！");
					}

				}
			});
			break;
		default:
			break;
		}

	}

	@Override
	public void initView() {
		et_login_username=(EditText)findViewById(R.id.et_login_username);
		et_login_psw=(EditText)findViewById(R.id.et_login_psw);
		bt_login=(Button)findViewById(R.id.bt_login);
		bt_logout=(Button)findViewById(R.id.bt_logout);
		bt_forget_psw=(Button)findViewById(R.id.bt_forget_psw);
		bt_login.setOnClickListener(this);
		bt_logout.setOnClickListener(this);
		bt_forget_psw.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}
}

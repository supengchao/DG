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
 * @author ������������2015-4-11����3:58:47
 * TODO  ��¼����
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
				MyUtil.toast(mContext, UserManager.INSTANCE.getUser().getCurrentUser().getUsername()+"�Ѿ���¼�����������˺ŵ�½������ע�����ٴε�¼��");
			}else{

				if(MyUtil.isEmptyEditText(et_login_username)){
					MyUtil.toast(mContext, "�������û��� ��");
					return;
				}
				if(MyUtil.isEmptyEditText(et_login_psw)){
					MyUtil.toast(mContext, "���������� ��");
					return;
				}
				User user = new User();
				UserManager.INSTANCE.setUser(user);
				user.logInInBackground(MyUtil.getEtString(et_login_username), MyUtil.getEtString(et_login_psw), new LogInCallback<AVUser>() {

					@Override
					public void done(AVUser arg0, AVException arg1) {
						if(arg0!=null){
							MyUtil.toast(mContext, arg0.getUsername()+"��¼�ɹ�");
						}else{
							MyUtil.toast(mContext, "��¼ʧ�ܣ������û����������Ƿ���ȷ��"+arg1.getMessage());
						}
					}
				});
			}
			break;
		case R.id.bt_logout:
			if(UserManager.INSTANCE.getUser()!=null&&UserManager.INSTANCE.getUser().getCurrentUser()!=null){
				MyUtil.toast(mContext, UserManager.INSTANCE.getUser().getCurrentUser().getUsername()+"�Ѿ�ע����¼��");
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
									MyUtil.toast(mContext, "���ͳɹ����뾡���¼�����������룡");
								} else {
									MyUtil.toast(mContext, "������������ĸ�ʽ�Ƿ���ȷ��");
								}

							}
						});
					}else{
						MyUtil.toast(mContext, "���������䣡");
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

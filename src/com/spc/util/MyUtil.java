package com.spc.util;

import com.example.dg.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyUtil {
	
	/**
	 * 
	 * 苏鹏超创建于20152015-4-11下午3:36:54
	 * boolean
	 * TODO 判断用户输入是否为空
	 */
	public static boolean isEmptyEditText(EditText et){
		String str= MyUtil.getEtString(et);
		if(CommonUtil.isEmpty(str)){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * 苏鹏超创建于20152015-4-11下午3:36:21
	 * String
	 * TODO 获取EditText中的值
	 */
	public static String getEtString(EditText et){
		String str= et.getText().toString().trim();
		return str;
	}
	/**
	 * 
	 * 苏鹏超创建于20152015-4-11下午3:35:59
	 * void
	 * TODO toast util
	 */
	public static void toast(Context mContext,String str){
		Toast.makeText(mContext, str,Toast.LENGTH_SHORT).show();
	}
	/**
	 * 
	 * 苏鹏超创建于20152015-4-11下午3:55:14
	 * void
	 * TODO 通过Intent 从当前的Acitivity或者Fragment跳到下一个界面
	 */
	public static void skipToNextActiivty(Activity aty1,Class<?> aty2){
		Intent intent = new Intent(aty1,aty2);
		aty1.startActivity(intent);
	}
	
//	public AlertDialog showMyDialog(Context context) {
//		AlertDialog dialog=null;
//		LayoutInflater inflater = LayoutInflater.from(context);
//		View view = inflater.inflate(R.layout.dialog_alert, null);
////		TextView tv_load = (TextView) view.findViewById(R.id.current_action);
//		if (dialog == null) {
//			dialog = new AlertDialog(context,AlertDialog.THEME_HOLO_LIGHT);
//		}
//		dialog.setCanceledOnTouchOutside(false);
//		dialog.setCancelable(true);
//		dialog.show();
//		
//		dialog.setContentView(view);
//		
//		return dialog;
//	}
}

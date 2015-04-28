package com.spc.util;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dg.R;
import com.spc.view.dialog.Effectstype;
import com.spc.view.dialog.NiftyDialogBuilder;

public class DialogUtil {
	private static Effectstype effect;

	public static NiftyDialogBuilder showDialog(Context mContext,View view,String title,String msg){
		NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(mContext);
		//		effect=Effectstype.Slit;
		//		effect=Effectstype.Fadein;
		//		effect=Effectstype.Slideright; 
		//		effect=Effectstype.Slideleft; 
		//		effect=Effectstype.Slidetop; 
		//		effect=Effectstype.SlideBottom; 
		//		effect=Effectstype.Newspager; 
		//		effect=Effectstype.Fall; 
		//		effect=Effectstype.Sidefill; 
		//		effect=Effectstype.Fliph; 
		//		effect=Effectstype.Flipv; 
		//		effect=Effectstype.RotateBottom; 
		//		effect=Effectstype.RotateLeft; 
		//		effect=Effectstype.Slit; 
		effect=Effectstype.Shake; 
		
		dialogBuilder.isCancelableOnTouchOutside(false)
		.withTitle(title)
		.withTitleColor("#FFFFFF")
		.withDividerColor("#11000000")
		.withMessage(msg)
		.withMessageColor("#FFFFFF")
		.withIcon(mContext.getResources().getDrawable(R.drawable.icon1))
		.withEffect(effect)
		.withButton1Text("确定")
		.withButton2Text("取消")
		.setCustomView(view,mContext)
		.show();
		return dialogBuilder;
	}
}

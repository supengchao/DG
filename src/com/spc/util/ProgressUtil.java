package com.spc.util;

import com.spc.view.progressbutton.CircularProgressButton;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class ProgressUtil {
	/**
	 * 
	 * ������������20152015-4-14����3:22:44
	 * void
	 * TODO ProgressButton����ʧ�ܶ�������
	 */
	public static void setErrorShow(final CircularProgressButton button){
		ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 99);
		widthAnimation.setDuration(1500);
		widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Integer value = (Integer) animation.getAnimatedValue();
				button.setProgress(value);
				if (value == 99) {
					button.setProgress(-1);
				}
			}
		});
		widthAnimation.start();

	}
	/**
	 * 
	 * ������������20152015-4-15����4:03:22
	 * void
	 * TODO ProgressButton���سɹ���������
	 */
	public static void setOKShow(final CircularProgressButton button){
		ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 99);
		widthAnimation.setDuration(1500);
		widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
		widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Integer value = (Integer) animation.getAnimatedValue();
				button.setProgress(value);
				if (value == 99) {
					button.setProgress(100);
				}
			}
		});
		widthAnimation.start();
		
	}
	
	public static boolean isReadyReset(final CircularProgressButton button){
		if(button.getProgress()>=99){
			return true;
		}
		return false;
	}
}

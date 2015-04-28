package com.spc.activity;

import com.example.dg.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingActivity;
import com.spc.fragment.ContentFragment;
import com.spc.fragment.MenuFragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends SlidingActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		setBehindContentView(R.layout.frame_menu);
		
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		MenuFragment menuFragment = new MenuFragment();
		fragmentTransaction.replace(R.id.menu, menuFragment);
		
		ContentFragment contentFragment = new ContentFragment();
		fragmentTransaction.replace(R.id.content, contentFragment);
		fragmentTransaction.commit();
		
		SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidth(20);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffset(250);
        sm.setFadeDegree(0.35f);
        
      //设置slding menu的几种手势模式
        //TOUCHMODE_FULLSCREEN 全屏模式，在content页面中，滑动，可以打开sliding menu
        //TOUCHMODE_MARGIN 边缘模式，在content页面中，如果想打开slding ,你需要在屏幕边缘滑动才可以打开slding menu
        //TOUCHMODE_NONE 自然是不能通过手势打开啦
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        
		initUI();
		
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
	}
}

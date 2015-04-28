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
        
      //����slding menu�ļ�������ģʽ
        //TOUCHMODE_FULLSCREEN ȫ��ģʽ����contentҳ���У����������Դ�sliding menu
        //TOUCHMODE_MARGIN ��Եģʽ����contentҳ���У�������slding ,����Ҫ����Ļ��Ե�����ſ��Դ�slding menu
        //TOUCHMODE_NONE ��Ȼ�ǲ���ͨ�����ƴ���
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        
		initUI();
		
	}

	private void initUI() {
		// TODO Auto-generated method stub
		
	}
}

package com.spc.activity;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SaveCallback;
import com.example.dg.R;
import com.example.dg.R.layout;
import com.spc.bean.Company;
import com.spc.util.MyUtil;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyActivity extends Activity implements View.OnClickListener{


	private View in1;
	private View in2;
	private TextView tv_web_site;
	private EditText et_web_content;
	private View in3;
	private View in4;
	private View in5;
	private View in6;
	private View in7;
	private View in8;
	private ListView listView;
	private TextView tv_first_devide;
	private EditText et_first_devide;
	private TextView tv_detail_field;
	private EditText et_detail_field;
	private TextView tv_main_business;
	private EditText et_main_business;
	private TextView tv_build_time;
	private EditText et_build_time;
	private TextView tv_finacing_step;
	private EditText et_finacing_step;
	private TextView tv_appraisement;
	private EditText et_appraisement;
	private TextView tv_factions;
	private EditText et_factions;
	private TextView tv_originator;
	private EditText et_originator;
	private View in9;
	private View in10;
	private TextView tv_company_name;
	private EditText et_company_name;
	private Context context;
	private Button bt_commit_company;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context=CompanyActivity.this;
		initView();
		initData();
	}

	private void initData() {
		tv_company_name.setText(R.string.company_name);
		tv_web_site.setText(R.string.field_rank);
		tv_first_devide.setText(R.string.first_devide);
		tv_detail_field.setText(R.string.detail_field);
		tv_main_business.setText(R.string.main_business);
		tv_build_time.setText(R.string.build_time);
		tv_finacing_step.setText(R.string.finacing_step);
		tv_appraisement.setText(R.string.appraisement);
		tv_factions.setText(R.string.factions);
		tv_originator.setText(R.string.originator);
	}

	private void initView() {
		in1=(View)findViewById(R.id.in1);
		in2=(View)findViewById(R.id.in2);
		in3=(View)findViewById(R.id.in3);
		in4=(View)findViewById(R.id.in4);
		in5=(View)findViewById(R.id.in5);
		in6=(View)findViewById(R.id.in6);
		in7=(View)findViewById(R.id.in7);
		in8=(View)findViewById(R.id.in8);
		in9=(View)findViewById(R.id.in9);
		in10=(View)findViewById(R.id.in10);
		
		tv_company_name=(TextView)in1.findViewById(R.id.tv_name);
		et_company_name=(EditText)in1.findViewById(R.id.et_content);
		
		tv_web_site=(TextView)in2.findViewById(R.id.tv_name);
		et_web_content=(EditText)in2.findViewById(R.id.et_content);
		
		tv_first_devide=(TextView)in3.findViewById(R.id.tv_name);
		et_first_devide=(EditText)in3.findViewById(R.id.et_content);
		 
		tv_detail_field=(TextView)in4.findViewById(R.id.tv_name);
		et_detail_field=(EditText)in4.findViewById(R.id.et_content);
		
		tv_main_business=(TextView)in5.findViewById(R.id.tv_name);
		et_main_business=(EditText)in5.findViewById(R.id.et_content);
		
		tv_build_time=(TextView)in6.findViewById(R.id.tv_name);
		et_build_time=(EditText)in6.findViewById(R.id.et_content);
		
		tv_finacing_step=(TextView)in7.findViewById(R.id.tv_name);
		et_finacing_step=(EditText)in7.findViewById(R.id.et_content);
		
		tv_appraisement=(TextView)in8.findViewById(R.id.tv_name);
		et_appraisement=(EditText)in8.findViewById(R.id.et_content);
		
		tv_factions=(TextView)in9.findViewById(R.id.tv_name);
		et_factions=(EditText)in9.findViewById(R.id.et_content);
		
		tv_originator=(TextView)in10.findViewById(R.id.tv_name);
		et_originator=(EditText)in10.findViewById(R.id.et_content);
		
		bt_commit_company=(Button)findViewById(R.id.bt_commit_company);
		bt_commit_company.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bt_commit_company:
			Company mCompany= new Company();
			if(!MyUtil.isEmptyEditText(et_company_name)){
				mCompany.setCompany_name(MyUtil.getEtString(et_company_name));
			}
			if(!MyUtil.isEmptyEditText(et_web_content)){
				mCompany.setField_rank(MyUtil.getEtString(et_web_content));
			}
			if(!MyUtil.isEmptyEditText(et_first_devide)){
				mCompany.setFirst_devide(MyUtil.getEtString(et_first_devide));
			}
			
			if(!MyUtil.isEmptyEditText(et_detail_field)){
				mCompany.setDetail_field(MyUtil.getEtString(et_detail_field));
			}
			if(!MyUtil.isEmptyEditText(et_main_business)){
				mCompany.setMain_business(MyUtil.getEtString(et_main_business));
				
			}
			if(!MyUtil.isEmptyEditText(et_build_time)){
				mCompany.setBuild_time(MyUtil.getEtString(et_build_time));
			}
			if(!MyUtil.isEmptyEditText(et_finacing_step)){
				mCompany.setFinacing_step(MyUtil.getEtString(et_finacing_step));
			}
			if(!MyUtil.isEmptyEditText(et_appraisement)){
				mCompany.setAppraisement(MyUtil.getEtString(et_appraisement));
			}
			if(!MyUtil.isEmptyEditText(et_factions)){
				mCompany.setFactions(MyUtil.getEtString(et_factions));
			}
			if(!MyUtil.isEmptyEditText(et_originator)){
				mCompany.setOriginator(MyUtil.getEtString(et_originator));
			}
			mCompany.saveInBackground(new SaveCallback() {
				
				@Override
				public void done(AVException arg0) {
					// TODO Auto-generated method stub
					if(arg0!=null){
						Toast.makeText(context, arg0.getMessage(), Toast.LENGTH_SHORT).show();
					}else{
						Toast.makeText(context, "上传成功", Toast.LENGTH_SHORT).show();
					}
				}
			});
			break;

		default:
			break;
		}
	}
 

}

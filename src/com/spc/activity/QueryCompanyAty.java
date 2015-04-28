package com.spc.activity;

import java.util.ArrayList;
import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.RequestPasswordResetCallback;
import com.example.dg.R;
import com.spc.adapter.CompanyAdapter;
import com.spc.bean.Company;
import com.spc.util.DataRequest;
import com.spc.util.DialogUtil;
import com.spc.util.MyUtil;
import com.spc.view.XListView;
import com.spc.view.XListView.IXListViewListener;
import com.spc.view.dialog.NiftyDialogBuilder;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class QueryCompanyAty extends BaseActivity implements IXListViewListener{

	private Button bt_query1;
	private Button bt_query2;
	private Button bt_query3;
	private Button bt_query4;
	private Button bt_query5;
	private Button bt_query6;
	private Context mContext;
	private XListView listView;
	private CompanyAdapter adapter;
	private int number=1;
	private View view;
	private EditText et_name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query_company);
		mContext=QueryCompanyAty.this;
		initView();
		initData();
	}

	@Override
	public void initView() {
		bt_query1=(Button)findViewById(R.id.bt_query1);
		bt_query2=(Button)findViewById(R.id.bt_query2);
		bt_query3=(Button)findViewById(R.id.bt_query3);
		bt_query4=(Button)findViewById(R.id.bt_query4);
		bt_query5=(Button)findViewById(R.id.bt_query5);
		bt_query6=(Button)findViewById(R.id.bt_query6);
		listView=(XListView)findViewById(R.id.listView);
	    view=View.inflate(mContext, R.layout.custom_view, null);
		et_name=(EditText)view.findViewById(R.id.et_name);
		bt_query1.setOnClickListener(this);
		bt_query2.setOnClickListener(this);
		bt_query3.setOnClickListener(this);
		bt_query4.setOnClickListener(this);
		bt_query5.setOnClickListener(this);
		bt_query6.setOnClickListener(this);
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				final NiftyDialogBuilder dialog=DialogUtil.showDialog(mContext,view,"DG","确定要删除该");
				dialog.setButton1Click(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						if(!MyUtil.isEmptyEditText(et_name)){
							getCompanyByName(et_name);
						}else{
							MyUtil.toast(mContext, "请输入公司名称！");
						}
						dialog.dismiss();
					}
				});
				dialog.setButton2Click(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});

				return false;
			}
		});
	}

	@Override
	public void initData() {
		bt_query1.setText("查询所有");
		bt_query2.setText("名称查");
		bt_query3.setText("行业查询");
		bt_query4.setText("时间查询");
		bt_query5.setText("融资查询");
		listView.setPullLoadEnable(true);
		listView.setXListViewListener(this);
		listView.setFooterVisible();
		listView.setPullRefreshEnable(true);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_query1:
			number=1;
			getCompanyList();
			break;
		case R.id.bt_query2:
			number=2;
			final NiftyDialogBuilder dialog=DialogUtil.showDialog(mContext,view,"DG","请输入公司名称");
			dialog.setButton1Click(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if(!MyUtil.isEmptyEditText(et_name)){
						getCompanyByName(et_name);
					}else{
						MyUtil.toast(mContext, "请输入公司名称！");
					}
					dialog.dismiss();
				}
			});
			dialog.setButton2Click(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});

			break;
		case R.id.bt_query3:
			number=3;
			final NiftyDialogBuilder dialog1=DialogUtil.showDialog(mContext,view,"DG","请输入要查询的行业");
			dialog1.setButton1Click(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if(!MyUtil.isEmptyEditText(et_name)){
						getCompanyByField(et_name);
					}else{
						MyUtil.toast(mContext, "请输入行业名称！");
					}
					dialog1.dismiss();
				}
			});
			dialog1.setButton2Click(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					dialog1.dismiss();
				}
			});

			break;
		case R.id.bt_query4:
			number=4;
			final NiftyDialogBuilder dialog2=DialogUtil.showDialog(mContext,view,"DG","请输入要查询的行业");
			dialog2.setButton1Click(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					if(!MyUtil.isEmptyEditText(et_name)){
						getCompanyByField(et_name);
					}else{
						MyUtil.toast(mContext, "请输入行业名称！");
					}
					dialog2.dismiss();
				}
			});
			dialog2.setButton2Click(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					dialog2.dismiss();
				}
			});
			break;
		default:
			break;
		}
	}
	/**
	 * 苏鹏超创建于20152015-4-14上午11:26:29
	 * void
	 * TODO根据所属领域查询
	 */
	
	private void getCompanyByField(EditText et_name){
		String str=MyUtil.getEtString(et_name);
		AVQuery<Company> query = AVQuery.getQuery(Company.class);
		query.whereEqualTo("factions", str);
		query.findInBackground(new FindCallback<Company>() {

			@Override
			public void done(List<Company> arg0,
					AVException arg1) {
				if(arg0!=null&&arg0.size()!=0){
					adapter= new CompanyAdapter(arg0, mContext);
					listView.setAdapter(adapter);
					adapter.notifyDataSetChanged();
					stopRefreshLoad();
				}else{
					MyUtil.toast(mContext, "没有找到匹配该行业的公司！");
				}
				
			}
		});
		
	}
/**
 * 
 * 苏鹏超创建于20152015-4-14上午11:24:39
 * void
 * TODO 根据公司名称查询
 */
	private void getCompanyByName(EditText et_name) {
		String str=MyUtil.getEtString(et_name);
		AVQuery<Company> query = AVQuery.getQuery(Company.class);
		query.whereEqualTo("company_name", str);
		query.setLimit(10);
		query.setSkip(10);
		query.findInBackground(new FindCallback<Company>() {

			@Override
			public void done(List<Company> arg0,
					AVException arg1) {
				if(arg0!=null&&arg0.size()!=0){
					adapter= new CompanyAdapter(arg0, mContext);
					listView.setAdapter(adapter);
					adapter.notifyDataSetChanged();
					stopRefreshLoad();
				}else{
					MyUtil.toast(mContext, "没有找到匹配该行业的公司！");
				}
			}
		});
	}
	@Override
	public void onRefresh() {
		switch (number) {
		case 1:
			getCompanyList();
			break;
		case 2:
			getCompanyByName(et_name);
			break;
		case 3:
			getCompanyByField(et_name);
			break;
		default:
			break;
		}
	}

	@Override
	public void onLoadMore() {
		switch (number) {
		case 1:
			getCompanyList();
			break;
		case 2:
			getCompanyByName(et_name);
			break;
		case 3:
			getCompanyByField(et_name);
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * 苏鹏超创建于20152015-4-13下午1:49:09
	 * void
	 * TODO  获取公司列表，并显示到listview中
	 */
	private void getCompanyList() {
		AVQuery<Company> query = AVQuery.getQuery(Company.class);
		query.findInBackground(new FindCallback<Company>() {

			@Override
			public void done(List<Company> arg0, AVException arg1) {
				adapter= new CompanyAdapter(arg0, mContext);
				listView.setAdapter(adapter);
				adapter.notifyDataSetChanged();
				stopRefreshLoad();
			}
		});
	}
	/**
	 * 
	 * 苏鹏超创建于20152015-4-13下午1:55:01
	 * void
	 * TODO  停止刷新，加载
	 */
	private void stopRefreshLoad(){
		listView.stopRefresh();
		listView.stopLoadMore();
	}

}

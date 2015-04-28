package com.spc.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.dg.R;
import com.spc.bean.Company;
import com.spc.util.CommonUtil;
import com.spc.util.MyUtil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CompanyAdapter extends BaseAdapter {

	private List<Company> list=new ArrayList<Company>();
	private Context mContext;

	public CompanyAdapter(List<Company> list, Context mContext) {
		super();
		if(list!=null){
			this.list = list;
		}
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHoldler holdler;
		if(convertView==null){
			holdler=new ViewHoldler();
			convertView=View.inflate(mContext, R.layout.item_company_list,null);
			holdler.tv_name=(TextView)convertView.findViewById(R.id.tv_name);
			holdler.tv_appraisement=(TextView)convertView.findViewById(R.id.tv_appraisement);
			holdler.tv_first_divide=(TextView)convertView.findViewById(R.id.tv_first_divide);
			holdler.tv_finacing_step=(TextView)convertView.findViewById(R.id.tv_finacing_step);
			holdler.tv_build_time=(TextView)convertView.findViewById(R.id.tv_build_time);
			holdler.tv_main_business=(TextView)convertView.findViewById(R.id.tv_main_business);
			holdler.tv_detail_field=(TextView)convertView.findViewById(R.id.tv_detail_field);
			holdler.tv_field_rank=(TextView)convertView.findViewById(R.id.tv_field_rank);
			holdler.tv_originator=(TextView)convertView.findViewById(R.id.tv_originator);
			convertView.setTag(holdler);
		}else{
			holdler=(ViewHoldler) convertView.getTag();
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_name.setText("��˾���ƣ�"+list.get(position).getCompany_name());
		}else{
			holdler.tv_name.setText("��˾���ƣ�����Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getAppraisement())){
			holdler.tv_appraisement.setText("���ʽ�"+list.get(position).getAppraisement());
		} else{
			holdler.tv_name.setText("���ʽ�����Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_first_divide.setText("��һ���ࣺ"+list.get(position).getFirst_devide());
		}else{
			holdler.tv_name.setText("��һ���ࣺ����Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_finacing_step.setText("����������"+list.get(position).getFinacing_step());
		}else{
			holdler.tv_name.setText("��������������Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_build_time.setText("����ʱ�䣺"+list.get(position).getBuild_time());
		}else{
			holdler.tv_name.setText("����ʱ�䣺����Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_main_business.setText("��Ҫҵ��"+list.get(position).getMain_business());
		}else{
			holdler.tv_name.setText("��Ҫҵ�񣺹���Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_detail_field.setText("ϸ������"+list.get(position).getDetail_field());
		}else{
			holdler.tv_name.setText("ϸ�����򣺹���Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_field_rank.setText("�������У�"+list.get(position).getField_rank());
		}else{
			holdler.tv_name.setText("�������У�����Ա��δ��д" );
		}
		if(!CommonUtil.isEmpty(list.get(position).getCompany_name())){
			holdler.tv_originator.setText("��ʼ�ˣ�"+list.get(position).getOriginator());
		}else{
			holdler.tv_name.setText("��ʼ�ˣ�����Ա��δ��д" );
		}
		 
		return convertView;
	}

	private class ViewHoldler{
		private TextView tv_name,tv_appraisement,tv_first_divide,
		tv_finacing_step,tv_build_time,tv_main_business,
		tv_detail_field,tv_field_rank,tv_originator;
	}
}

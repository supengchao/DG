package com.spc.util;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.DeleteCallback;
import com.avos.avoscloud.FindCallback;
import com.spc.adapter.CompanyAdapter;
import com.spc.bean.Company;

/**
 * 
 * @author 苏鹏超创建于2015-4-13下午1:21:06
 * TODO 数据获取操作类
 */
public class DataRequest {
	private List<Company> list = new ArrayList<Company>();
	private static DataRequest instance;
	private DataRequest(){}
	public static DataRequest getInstance(){
		if(instance==null){
			instance= new DataRequest();
		}
		return instance;
	}
/**
 * 
 * 苏鹏超创建于20152015-4-13下午1:28:25
 * List<Company>
 * TODO 查询所有的公司信息
 */
	public List<Company> getCompanyList(){
		AVQuery<Company> query = AVQuery.getQuery(Company.class);
		query.findInBackground(new FindCallback<Company>() {

			@Override
			public void done(List<Company> arg0, AVException arg1) {
				list=arg0;
			}
		});
		return list;
	}
	
	public void deleteCompany(final String name,final Context mContext){
		AVQuery<Company> query = AVQuery.getQuery(Company.class);
		query.findInBackground(new FindCallback<Company>() {

			@Override
			public void done(List<Company> arg0, AVException arg1) {
				for (Company company : arg0) {
					if(name.equals( company.getCompany_name())){
						company.deleteInBackground( new DeleteCallback() {
							
							@Override
							public void done(AVException arg0) {
								MyUtil.toast(mContext, name+"成功删除");
							}
						});
					}
				}
			}
		});
	}
}

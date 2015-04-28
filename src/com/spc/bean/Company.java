package com.spc.bean;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

@AVClassName("Company")
public class  Company extends AVObject {
 
	public String getCompany_name() {
		return getString("company_name");
	}
	public void setCompany_name(String company_name) {
		put("company_name", company_name);
	}
	public String getField_rank() {
		return getString("field_rank");
	}
	public void setField_rank(String field_rank) {
		put("field_rank", field_rank);
	}
	public String getFirst_devide() {
		return getString("first_devide");
	}
	public void setFirst_devide(String first_devide) {
		put("first_devide", first_devide);
	}
	public String getDetail_field() {
		return getString("detail_field");
	}
	public void setDetail_field(String detail_field) {
		put("detail_field", detail_field);
	}
	public String getMain_business() {
		return getString("main_business");
	}
	public void setMain_business(String main_business) {
		put("main_business", main_business);
	}
	public String getBuild_time() {
		return getString("build_time");
	}
	public void setBuild_time(String build_time) {
		put("build_time", build_time);
	}
	public String getFinacing_step() {
		return getString("finacing_step");
	}
	public void setFinacing_step(String finacing_step) {
		put("finacing_step", finacing_step);
	}
	public String getAppraisement() {
		return getString("appraisement");
	}
	public void setAppraisement(String appraisement) {
		put("appraisement", appraisement);
	}
	public String getFactions() {
		return getString("factions");
	}
	public void setFactions(String factions) {
		put("factions", factions);
	}
	public String getOriginator() {
		return getString("originator");
	}
	public void setOriginator(String originator) {
		put("originator", originator);
	}


}

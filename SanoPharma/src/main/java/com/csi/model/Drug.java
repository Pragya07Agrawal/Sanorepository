package com.csi.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

public class Drug {
	
	private int drugId;
	private String drugName;
	private String drugDescription;
	private String drugHeal;
	private Date drugResearchDate;
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugDescription() {
		return drugDescription;
	}
	public void setDrugDescription(String drugDescription) {
		this.drugDescription = drugDescription;
	}
	public String getDrugHeal() {
		return drugHeal;
	}
	public void setDrugHeal(String drugHeal) {
		this.drugHeal = drugHeal;
	}
	public Date getDrugResearchDate() {
		return drugResearchDate;
	}
	public void setDrugResearchDate(Date drugResearchDate) {
		this.drugResearchDate = drugResearchDate;
	}
	
	
	
	

}

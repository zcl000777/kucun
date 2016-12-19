package com.warehouse.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the panying database table.
 * 
 */
@Entity
@Table(name = "Panying")
@NamedQuery(name="Panying.findAll", query="SELECT p FROM Panying p")
public class Panying implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="Panying_IDGEN")
	@TableGenerator(
            name="Panying_IDGEN", 
            table="GAF_ID_GEN", 
            pkColumnName="\"KEY\"", 
            valueColumnName="VALUE", 
            pkColumnValue="Panying",
            allocationSize=1)
	private Long id;

	private String analysisofcauses;

	private Long eid;

	private String inventoryprofit;

	private String itemcode;

	private String position;

	private String reality;

	private String remark;

	private String storeenormous;

	private String suggest;

	private String tradename;

	public Panying() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnalysisofcauses() {
		return this.analysisofcauses;
	}

	public void setAnalysisofcauses(String analysisofcauses) {
		this.analysisofcauses = analysisofcauses;
	}

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getInventoryprofit() {
		return this.inventoryprofit;
	}

	public void setInventoryprofit(String inventoryprofit) {
		this.inventoryprofit = inventoryprofit;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getReality() {
		return this.reality;
	}

	public void setReality(String reality) {
		this.reality = reality;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStoreenormous() {
		return this.storeenormous;
	}

	public void setStoreenormous(String storeenormous) {
		this.storeenormous = storeenormous;
	}

	public String getSuggest() {
		return this.suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getTradename() {
		return this.tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

}
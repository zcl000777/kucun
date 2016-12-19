package com.warehouse.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the chuhuo database table.
 * 
 */
@Entity
@Table(name = "Chuhuo")
@NamedQuery(name="Chuhuo.findAll", query="SELECT c FROM Chuhuo c")
public class Chuhuo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="Chuhuo_IDGEN")
	@TableGenerator(
            name="Chuhuo_IDGEN", 
            table="GAF_ID_GEN", 
            pkColumnName="\"KEY\"", 
            valueColumnName="VALUE", 
            pkColumnValue="Chuhuo",
            allocationSize=1)
	private Long id;

	private String am;

	private String battery;

	private Long cid;

	private String commoditycode;

	private String customer;

	private String date;

	private String fba;

	private Long fid;

	private Long ordernumber;

	private String remark;

	private String send;

	private String shippingaddress;

	private String situation;

	private String sku;

	private String tradename;

	public Chuhuo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAm() {
		return this.am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getBattery() {
		return this.battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCommoditycode() {
		return this.commoditycode;
	}

	public void setCommoditycode(String commoditycode) {
		this.commoditycode = commoditycode;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFba() {
		return this.fba;
	}

	public void setFba(String fba) {
		this.fba = fba;
	}

	public Long getFid() {
		return this.fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(Long ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSend() {
		return this.send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public String getShippingaddress() {
		return this.shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public String getSituation() {
		return this.situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getTradename() {
		return this.tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

}
package com.warehouse.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ruku database table.
 * 
 */
@Entity
@Table(name = "Ruku")
@NamedQuery(name="Ruku.findAll", query="SELECT r FROM Ruku r")
public class Ruku implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="Ruku_IDGEN")
	@TableGenerator(
            name="Ruku_IDGEN", 
            table="GAF_ID_GEN", 
            pkColumnName="\"KEY\"", 
            valueColumnName="VALUE", 
            pkColumnValue="Ruku",
            allocationSize=1)
	private Long id;

	private String amazonas;

	private String article;

	private String asin;

	private String battery;

	private String buying;

	private String connect;

	private String did;

	private String itemcode;

	private String logistics;

	private String logisticsprocess;

	private String picture;

	private String position;

	private String productname;

	private String purchaser;

	private String quantity;

	private String realquantity;

	private String remark;

	private String remarks;

	private String testarticle;

	private String time;

	public Ruku() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAmazonas() {
		return this.amazonas;
	}

	public void setAmazonas(String amazonas) {
		this.amazonas = amazonas;
	}

	public String getArticle() {
		return this.article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getAsin() {
		return this.asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getBattery() {
		return this.battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getBuying() {
		return this.buying;
	}

	public void setBuying(String buying) {
		this.buying = buying;
	}

	public String getConnect() {
		return this.connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getLogistics() {
		return this.logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public String getLogisticsprocess() {
		return this.logisticsprocess;
	}

	public void setLogisticsprocess(String logisticsprocess) {
		this.logisticsprocess = logisticsprocess;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPurchaser() {
		return this.purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRealquantity() {
		return this.realquantity;
	}

	public void setRealquantity(String realquantity) {
		this.realquantity = realquantity;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTestarticle() {
		return this.testarticle;
	}

	public void setTestarticle(String testarticle) {
		this.testarticle = testarticle;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
package com.warehouse.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the pancun database table.
 * 
 */
@Entity
@Table(name = "Pancun")
@NamedQuery(name="Pancun.findAll", query="SELECT p FROM Pancun p")
public class Pancun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="Pancun_IDGEN")
	@TableGenerator(
            name="Pancun_IDGEN", 
            table="GAF_ID_GEN", 
            pkColumnName="\"KEY\"", 
            valueColumnName="VALUE", 
            pkColumnValue="Pancun",
            allocationSize=1)
	private Long id;

	private String delivery;

	private String itemcode;

	private Long pid;

	private String reality;

	private String remark;

	private String storagerack;

	private String tradename;

	public Pancun() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDelivery() {
		return this.delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
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

	public String getStoragerack() {
		return this.storagerack;
	}

	public void setStoragerack(String storagerack) {
		this.storagerack = storagerack;
	}

	public String getTradename() {
		return this.tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

}
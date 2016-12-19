package com.warehouse.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the kucun database table.
 * 
 */
@Entity
@Table(name = "Kucun")
@NamedQuery(name="Kucun.findAll", query="SELECT k FROM Kucun k")
public class Kucun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="Kucun_IDGEN")
	@TableGenerator(
            name="Kucun_IDGEN", 
            table="GAF_ID_GEN", 
            pkColumnName="\"KEY\"", 
            valueColumnName="VALUE", 
            pkColumnValue="Kucun",
            allocationSize=1)
	private Long id;

	private String battery;

	private Long cid;

	private String colour;

	private String connect;

	private String itemcode;

	private Long number;

	private String size;

	private String tradename;

	public Kucun() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getConnect() {
		return this.connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	public String getItemcode() {
		return this.itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public Long getNumber() {
		return this.number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTradename() {
		return this.tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

}
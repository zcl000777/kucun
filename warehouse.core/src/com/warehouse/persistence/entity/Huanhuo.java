package com.warehouse.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the huanhuo database table.
 * 
 */
@Entity
@Table(name = "Huanhuo")
@NamedQuery(name="Huanhuo.findAll", query="SELECT h FROM Huanhuo h")
public class Huanhuo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="Huanhuo_IDGEN")
	@TableGenerator(
            name="Huanhuo_IDGEN", 
            table="GAF_ID_GEN", 
            pkColumnName="\"KEY\"", 
            valueColumnName="VALUE", 
            pkColumnValue="Huanhuo",
            allocationSize=1)
	private Long id;

	private String barter;

	private String itemcode;

	private Long pid;

	private String position;

	private String reality;

	private String remark;

	private String testarticle;

	private String time;

	public Huanhuo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarter() {
		return this.barter;
	}

	public void setBarter(String barter) {
		this.barter = barter;
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
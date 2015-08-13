package com.sd.project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TEST_USER_MAPPING")
public class TestUserMapping {
	
	@Column(name="T_ID")
	private int tId;
	
	@Column(name="U_ID")
	private int uId;
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int Id;
	
	@Column(name="MARKS")
	private int marks;

	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}

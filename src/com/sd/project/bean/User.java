package com.sd.project.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name = "uid")
    private int uid;
	
	@Column(name = "email")
    private String email;
	
	
    @Column(name = "role")
    private int role;
    
    
    @Column(name = "password")
    private String password;


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}

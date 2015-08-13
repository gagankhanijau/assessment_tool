package com.sd.project.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Test")
public class Test {
	@Id
	@GeneratedValue
	@Column(name = "tid")
	int tid;
	
	@Column(name="Company")
	String CompanyName;
	
	@Column(name="setter_id")
	int setterId;
	
	@Column(name="time")
	int timeAlloted;						/*In Minutes*/

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public int getSetterId() {
		return setterId;
	}

	public void setSetterId(int setterId) {
		this.setterId = setterId;
	}

	public int getTimeAlloted() {
		return timeAlloted;
	}

	public void setTimeAlloted(int timeAlloted) {
		this.timeAlloted = timeAlloted;
	}
}

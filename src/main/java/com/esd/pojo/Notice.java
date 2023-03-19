package com.esd.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;

@Component
@Entity
@NamedQuery(name = "removenotice", query = "FROM Notice WHERE nid=:nid")
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nid;
	private String title;
	private String cnt;
	@ManyToOne
	private Student sid;
	public long getNid() {
		return nid;
	}
	public void setNid(long nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public Student getSid() {
		return sid;
	}
	public void setSid(Student sid) {
		this.sid = sid;
	}
	
}

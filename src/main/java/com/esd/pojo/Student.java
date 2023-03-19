package com.esd.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;

@Component
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "studlgn", query = "FROM Student WHERE eid=:eid AND passwd=:passwd"),
		@NamedQuery(name = "removestud", query = "FROM Student WHERE eid=:eid")
	})
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sid;
    private String firstname;
    private String lastname;
    private String eid;
    private String passwd;
    private boolean adminstu = false;
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public boolean isAdminstu() {
		return adminstu;
	}
	public void setAdminstu(boolean adminstu) {
		this.adminstu = adminstu;
	}
    
    
}

package com.example.RegisterNdLogin.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	//properties
	@Id
	private int roleId;
	private String rname;
	
	//foreign key in userrole table
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "role")
	private Set<UserRole> userRoles=new HashSet<>();

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int roleId, String rname) {
		super();
		this.roleId = roleId;
		this.rname = rname;
	}
}
package com.example.RegisterNdLogin.models;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.RegisterNdLogin.models.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users") //table name specified
public class User implements UserDetails{ //issko implement kra for login security
	//properties
	@Id //primary key is id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid") //col name specified
	private int id;
	@Column(length = 25) //column length is 25
	private String fullname;
	@Column(unique = true) //column is unique,value can't be repeated
	private String username;
	private String password;
	private int age;
	private String gender;
	private String plan;
	private String medDev;
	private Date dob;
	private Date expDate;
	private Date regDate;
	
	//user has many roles
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER ,mappedBy = "user")
	@JsonIgnore //circular dependancy na create ho
	private Set<UserRole> userRoles=new HashSet<>();

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getMedDev() {
		return medDev;
	}
	public void setMedDev(String medDev) {
		this.medDev = medDev;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	//constructors
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String fullname, String username, String password, int age, String gender, String plan,
			String medDev, Date dob, Date expDate, Date regDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.plan = plan;
		this.medDev = medDev;
		this.dob = dob;
		this.expDate = expDate;
		this.regDate = regDate;
	}
	
	//displaying
	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", username=" + username + ", password=" + password
				+ ", age=" + age + ", gender=" + gender + ", plan=" + plan + ", medDev=" + medDev + ", dob=" + dob
				+ ", expDate=" + expDate + ", regDate=" + regDate + "]";
	}
	
	//isske[security] methods ko override krne ka faida yeh hai ki issi class mei sab implementation ho jayegi
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> set = new HashSet<>();
		//adding authority;which is imp;userrole ke obj se nikalenge hum
		this.userRoles.forEach(userRole -> {
            set.add(new Authority(userRole.getRole().getRname()));
		});
		return set;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
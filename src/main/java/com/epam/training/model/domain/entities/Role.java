package com.epam.training.model.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@Column(name="role_id")
	@GeneratedValue
	private Integer roleId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.EAGER)
	private List<Employee> employees;
	
	public Role(){
		
	}

	public Role(Integer roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}

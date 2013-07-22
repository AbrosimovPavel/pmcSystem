package com.epam.training.model.domain.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue
	private int employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "position_id")
	private PositionInCompany positionInCompany;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinTable(name = "employee_roles", 
				joinColumns = { @JoinColumn(name = "employee_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private List<Role> roles;

	@ManyToMany(mappedBy = "employees")
	private List<Project> projects;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="author")
	private Set<Comment> comments;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="task_creator")
	private Set<Task> tasks;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="employee_id")
	private Set<Assignment> assignments;
	
	public Employee(){
		
	}

	public Employee(int employeeId, String firstName, String lastName,
			String password, PositionInCompany positionInCompany, List<Role> roles) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.positionInCompany = positionInCompany;
		this.roles = roles;
	}
	
	public Employee(int employeeId, String firstName, String lastName,
			String password, List<Role> roles) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.roles = roles;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public PositionInCompany getPositionInCompany() {
		return positionInCompany;
	}

	public void setPositionInCompany(PositionInCompany positionInCompany) {
		this.positionInCompany = positionInCompany;
	}

}

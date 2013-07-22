package com.epam.training.model.domain.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "project_id")
	@Basic(optional = false)
	@GeneratedValue
	private int projectId;

	@Column(name = "name")
	private String projectName;

	@ManyToOne
	@JoinColumn(name = "project_status")
	private ProjectStatus projectStatus;

	@Column(name = "planed_start_date")
	@Temporal(value = TemporalType.DATE)
	private Date planedStartDate;

	@Column(name = "planed_end_date")
	@Temporal(value = TemporalType.DATE)
	private Date planedEndDate;

	@Column(name = "actual_start_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date actualStartDate;

	@Column(name = "actual_end_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date actualendDate;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "project_member", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = { @JoinColumn(name = "employee_id") })
	private List<Employee> employees;

	public Project() {

	}

	public Project(int projectId, String projectName,
			ProjectStatus projectStatus, Date planedStartDate,
			Date planedEndDate, Date actualStartDate, Date actualendDate,
			List<Employee> members) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.planedStartDate = planedStartDate;
		this.planedEndDate = planedEndDate;
		this.actualStartDate = actualStartDate;
		this.actualendDate = actualendDate;
		this.employees = members;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Date getPlanedStartDate() {
		return planedStartDate;
	}

	public void setPlanedStartDate(Date planedStartDate) {
		this.planedStartDate = planedStartDate;
	}

	public Date getPlanedEndDate() {
		return planedEndDate;
	}

	public void setPlanedEndDate(Date planedEndDate) {
		this.planedEndDate = planedEndDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualendDate() {
		return actualendDate;
	}

	public void setActualendDate(Date actualendDate) {
		this.actualendDate = actualendDate;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}

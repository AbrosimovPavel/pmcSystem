package com.epam.training.model.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="assignment")
public class Assignment {

	@Id
	@Column(name="assignment_id")
	@GeneratedValue
	private int assignmentId;
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@Column(name = "assignment_date")
	@Temporal(value = TemporalType.DATE)
	private Date assignmentDate;

	@Column(name = "end_date")
	@Temporal(value = TemporalType.DATE)
	private Date endDate;
	
	public Assignment() {
	
	}
	
	public Assignment(int assignmentId, Task task, Employee employee,
			Date assignmentDate, Date endDate) {
		super();
		this.assignmentId = assignmentId;
		this.task = task;
		this.employee = employee;
		this.assignmentDate = assignmentDate;
		this.endDate = endDate;
	}
	

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getAssignmentDate() {
		return assignmentDate;
	}

	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
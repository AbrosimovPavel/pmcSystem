package com.epam.training.model.domain.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@Column(name = "task_id")
	@Basic(optional = false)
	@GeneratedValue
	private int taskId;

	@Column(name = "task_code")
	private String taskCode;

	@Column(name = "task_summary")
	private String taskSummary;

	@Column(name = "task_text")
	private String taskText;

	@Column(name = "creation_date")
	@Temporal(value = TemporalType.DATE)
	private Date creationDate;

	@Column(name = "start_date")
	@Temporal(value = TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "original_estimate")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date originalEstimate;

	@ManyToOne
	@JoinColumn(name = "task_status")
	private TaskStatus taskStatus;

	@ManyToOne
	@JoinColumn(name = "task_creator")
	private Employee taskCreator;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@OneToMany(cascade={CascadeType.ALL}) 
	@JoinColumn(name="task_id")
	private Set<Assignment> assignments;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="task")
	private Set<Comment> comments;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="assignment_id")
	private Set<Activity> activity;

	public Task() {

	}

	public Task(int taskId, String taskCode, String taskSuammary,
			String taskText, Date creationDate, Date startDate, Date endDate,
			Date originalEstimate, TaskStatus taskStatus, Employee tascCreator,
			Project project) {
		super();
		this.taskId = taskId;
		this.taskCode = taskCode;
		this.taskSummary = taskSuammary;
		this.taskText = taskText;
		this.creationDate = creationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.originalEstimate = originalEstimate;
		this.taskStatus = taskStatus;
		this.taskCreator = tascCreator;
		this.project = project;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getOriginalEstimate() {
		return originalEstimate;
	}

	public void setOriginalEstimate(Date originalEstimate) {
		this.originalEstimate = originalEstimate;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Employee getTascCreator() {
		return taskCreator;
	}

	public void setTascCreator(Employee tascCreator) {
		this.taskCreator = tascCreator;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getTaskCreator() {
		return taskCreator;
	}

	public void setTaskCreator(Employee taskCreator) {
		this.taskCreator = taskCreator;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public String getTaskSummary() {
		return taskSummary;
	}

	public void setTaskSummary(String taskSummary) {
		this.taskSummary = taskSummary;
	}

}

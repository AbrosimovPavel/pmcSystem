package com.epam.training.model.domain.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="task_status")
public class TaskStatus {
	@Id
	@Column(name="status_id")
	@GeneratedValue
	private Integer statusID;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="task_status")
	public Set<Task> tasks;

	public TaskStatus() {
	}

	public TaskStatus(Integer statusID, String name) {
		super();
		this.statusID = statusID;
		this.name = name;
	}

	public Integer getStatusID() {
		return statusID;
	}

	public void setStatusID(Integer statusID) {
		this.statusID = statusID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name;
	}
	
}

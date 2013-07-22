package com.epam.training.model.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity {
	
	@Id
	@Column(name="activity_id")
	@GeneratedValue
	private int activityId;
	
	@ManyToOne
	@JoinColumn(name = "assignment_id")
	private Assignment assignment;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="text")
	private String text;
	
	@Column(name="date")
	private Date date;
	
	public Activity(){
		
	}
	
	public Activity(int activityId, Assignment assignment, int duration,
			String text, Date date) {
		super();
		this.activityId = activityId;
		this.assignment = assignment;
		this.duration = duration;
		this.text = text;
		this.date = date;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

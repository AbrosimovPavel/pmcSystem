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
@Table(name="comment")
public class Comment {
	
	@Id
	@Column(name="comment_id")
	@GeneratedValue
	private int commentId;
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
	
	@Column(name="text")
	private String text;
	
	@Column(name="date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Employee author;
	
	public Comment(){
		
	}
	
	public Comment(int commentId, Task task, String text, Date date,
			Employee author) {
		super();
		this.commentId = commentId;
		this.task = task;
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
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

	public Employee getAuthor() {
		return author;
	}

	public void setAuthor(Employee author) {
		this.author = author;
	}
	
	
}

package com.epam.training.model.service;

import java.util.List;

import com.epam.training.model.domain.entities.Comment;

public interface ICommentService {
	
	public List<Comment> getCommentbyAuthor(int id);
	public List<Comment> getCommentbyTask(int id);
	
}

package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import com.epam.training.model.domain.entities.Comment;

public interface ICommentDataHandler {
	
	public List<Comment> getCommentbyAuthor(int id);
	public List<Comment> getCommentbyTask(int id);
	
}

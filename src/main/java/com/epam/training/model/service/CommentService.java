package com.epam.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.model.domain.database.datahandler.ICommentDataHandler;
import com.epam.training.model.domain.entities.Comment;

@Service
public class CommentService implements ICommentService {

	@Autowired
	public ICommentDataHandler commentDataHandler;
	
	@Override
	public List<Comment> getCommentbyAuthor(int id) {
		return commentDataHandler.getCommentbyAuthor(id);
	}

	@Override
	public List<Comment> getCommentbyTask(int id) {
		return commentDataHandler.getCommentbyTask(id);
	}

}

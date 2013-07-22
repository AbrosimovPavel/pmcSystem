package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.entities.Comment;

@Repository
@Transactional
public class CommentDataHandler implements ICommentDataHandler {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentbyAuthor(int id) {
		Session session = sessionFactory.openSession();
		List<Comment> comments = session.createQuery("from Comment where author_id = :id ")
				.setInteger("id", id)
				.list();
		return comments;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentbyTask(int id) {
		Session session = sessionFactory.openSession();
		List<Comment> comments = session.createQuery("from Comment where task_id = :id ")
				.setInteger("id", id)
				.list();
		return comments;
	}

}

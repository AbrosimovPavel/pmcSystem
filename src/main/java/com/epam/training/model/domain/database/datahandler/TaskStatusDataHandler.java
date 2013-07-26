package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.entities.TaskStatus;

@Repository
@Transactional
public class TaskStatusDataHandler implements ITaskStatusDataHandler {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TaskStatus> getAllTaskStatus() {
		Session session = sessionFactory.openSession();
		List<TaskStatus> taskStatus = session.createQuery("from TaskStatus").list();
		session.close();
		return taskStatus;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

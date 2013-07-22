package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.entities.Assignment;
import com.epam.training.model.domain.entities.Task;

@Repository
@Transactional
public class AssignmentDataHandler implements IAssignmentDataHandler {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Assignment> getTaskAssignment(int id) {
		Session session = sessionFactory.openSession();
		List<Assignment> assignments = session.createQuery("from Assignment where task_id = :id ")
							 .setInteger("id", id)
							 .list();
		session.close();
		return assignments;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Assignment> getEmployeeAssignment(int id) {
		Session session = sessionFactory.openSession();
		List<Assignment> assignments = session.createQuery("from Assignment where employee_id = :id ")
				 .setInteger("id", id)
				 .list();
		session.close();
		return assignments;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}

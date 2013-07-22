package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.entities.Activity;

@Repository
@Transactional
public class ActivityDataHandler implements IActivityDataHandler {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getActivity(int id) {
		Session session = sessionFactory.openSession();
		List<Activity> activities = session.createQuery("from Activity where assignment_id = :id ")
				.setInteger("id", id)
				.list();
		return activities;
	}
	
	
	

}

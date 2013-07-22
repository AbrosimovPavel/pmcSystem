package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.entities.Project;
import com.epam.training.model.domain.entities.Task;

@Repository
public class ProjectDataHandler implements IProjectDataHandler {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Project> getAllProject() {
		Session session = sessionFactory.openSession();
		List<Project> projects = session.createQuery("from Project").list();
		session.close();
		return projects;
	}

	@Override
	public void addProject(Project proj) {
		
	}

	@Override
	public void updateProject(Project proj, Integer id) {
		
	}

	@Override
	public void deleteProject(Integer id) {
		
	}

	@Override
	@Transactional
	public Project getProjectById(Integer id) {
		Session session = sessionFactory.openSession();
		Project project = null;
		project = (Project) session.createQuery("from Project where project_id = :id")
				 .setInteger("id", id).uniqueResult();
		session.close();
		return project;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.entities.Task;

@Repository
@Transactional
public class TaskDataHandler implements ITaskDataHandler {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Task> getAllTask() {
		Session session = sessionFactory.openSession();
		List<Task> tasks = session.createQuery("from Task").list();
		session.close();
		return tasks;
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> getProjectTask(int id) {
		Session session = sessionFactory.openSession();
		List<Task> tasks = session.createQuery("from Task where project_id = :id")
							 .setInteger("id", id)
							 .list();
		session.close();
		return tasks;
	}

	@Override
	public void addTask(Task task) {
		Session session = sessionFactory.openSession();
		session.save(task);
		session.close();
	}

	@Override
	public void updateTask(Task task, Integer id) {
		
	}

	@Override
	public void deleteTask(Integer id) {
		
	}

	@Override
	public Task getTaskById(Integer id) {
		Session session = sessionFactory.openSession();
		Task task =  (Task) session.createQuery("from Task where task_id = :id")
				 .setInteger("id", id).uniqueResult();
		session.close();
		return task;
	}

}

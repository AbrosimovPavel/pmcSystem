package com.epam.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.model.domain.database.datahandler.ITaskDataHandler;
import com.epam.training.model.domain.entities.Task;

@Service
public class TaskService implements ITaskService {

	@Autowired
	private ITaskDataHandler iTaskDataHandler;
	
	@Override
	public List<Task> getAllTask() {
		return iTaskDataHandler.getAllTask();
	}
	
	@Override
	public List<Task> getProjectTask(int id) {
		return iTaskDataHandler.getProjectTask(id);
	}

	@Override
	public void addTask(Task task) {
		iTaskDataHandler.addTask(task);
	}

	@Override
	public void updateTask(Task task, Integer id) {
		
	}

	@Override
	public void deleteTask(Integer id) {
		
	}

	@Override
	public Task getTaskById(Integer id) {
		return iTaskDataHandler.getTaskById(id);
	}

	public ITaskDataHandler getITaskDataHandler() {
		return iTaskDataHandler;
	}

	public void setITaskDataHandler(ITaskDataHandler iTaskDataHandler) {
		this.iTaskDataHandler = iTaskDataHandler;
	}



}

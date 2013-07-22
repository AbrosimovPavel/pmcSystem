package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import com.epam.training.model.domain.entities.Task;

public interface ITaskDataHandler {
	public List<Task> getAllTask();
	public List<Task> getProjectTask(int id);
	public void addTask(Task task);
	public void updateTask(Task task, Integer id);
	public void deleteTask(Integer id);
	public Task getTaskById(Integer id);

}

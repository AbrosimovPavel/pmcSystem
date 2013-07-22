package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import com.epam.training.model.domain.entities.Project;

public interface IProjectDataHandler {
	public List<Project> getAllProject();
	public void addProject(Project proj);
	public void updateProject(Project proj, Integer id);
	public void deleteProject(Integer id);
	public Project getProjectById(Integer id);
}

package com.epam.training.model.service;

import java.util.Collection;
import java.util.List;

import com.epam.training.model.domain.entities.Project;

public interface IProjectService {
	public List<Project> getAllProject();
	public Collection<Project> getProject(Integer id);
	public void addProject(Project proj);
	public void deleteProject(Integer id);
	public void updateProject(Project proj, Integer id);
	public Project getProjectById(Integer id);
}

package com.epam.training.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.database.datahandler.IProjectDataHandler;
import com.epam.training.model.domain.entities.Project;

@Service
public class ProjectService implements IProjectService {

	@Autowired
	private IProjectDataHandler projectDataHandler;

	@Override
	@Transactional
	public List<Project> getAllProject() {
		return projectDataHandler.getAllProject();
	}

	@Override
	public Collection<Project> getProject(Integer id) {
		Collection<Project> projects = new ArrayList<Project>();
		for (GrantedAuthority authority : getAuthentication().getAuthorities()) {
			if (authority.getAuthority().equals("admin")) {
				return getAllProject();
			}
			if (authority.getAuthority().equals("user")) {
				Project project = getProjectById(id);
				projects.add(project);
			}
		}
		return projects;
	}
	
	@Override
	public Project getProjectById(Integer id) {
		return projectDataHandler.getProjectById(id);
	}
	
	@Override
	public void addProject(Project proj) {

	}

	@Override
	public void deleteProject(Integer id) {

	}

	@Override
	public void updateProject(Project proj, Integer id) {

	}

	public IProjectDataHandler getProjectDataHandler() {
		return projectDataHandler;
	}

	public void setProjectDataHandler(IProjectDataHandler projectDataHandler) {
		this.projectDataHandler = projectDataHandler;
	}

	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}



}

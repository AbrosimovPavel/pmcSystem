package com.epam.training.controller.pages;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.model.domain.database.datahandler.IEmployeeDataHandler;
import com.epam.training.model.domain.entities.Employee;
import com.epam.training.model.domain.entities.Project;
import com.epam.training.model.service.IProjectService;

@Controller
@RequestMapping("/")
public class ProjectController {

	@Autowired
	private IProjectService iProjectService;

	@Autowired
	private IEmployeeDataHandler employeeDataHandler;
	/*
	 * @RequestMapping(value="/project.html") public String
	 * listProject(Map<String, Object> map) { map.put("project", new Project());
	 * map.put("projectList", iProjectService.getAllProject());
	 * 
	 * return "project"; }
	 */
	@RequestMapping(value = "/project.html")
	private ModelAndView listProject() {
		ModelAndView modelAndView = new ModelAndView("project");
		Employee employee = employeeDataHandler.getEmployeeByName(getAuthentication().getName());
		Collection<Project> projects = iProjectService.getProject(employee.getEmployeeId());
		modelAndView.addObject("employee", employee);
		modelAndView.addObject("projectList", projects);
		
		return modelAndView;
	}

	@RequestMapping("/")
	public String main(Model ui)
	{
		return "redirect:project";
	}

	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public IProjectService getiProjectService() {
		return iProjectService;
	}

	public void setiProjectService(IProjectService iProjectService) {
		this.iProjectService = iProjectService;
	}

}

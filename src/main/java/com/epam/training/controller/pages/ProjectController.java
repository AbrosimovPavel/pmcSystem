package com.epam.training.controller.pages;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.model.domain.database.datahandler.IEmployeeDataHandler;
import com.epam.training.model.domain.entities.Employee;
import com.epam.training.model.domain.entities.Project;
import com.epam.training.model.service.IProjectService;

@Controller
public class ProjectController {

	@Autowired
	private IProjectService iProjectService;

	@Autowired
	private IEmployeeDataHandler employeeDataHandler;
	
	@RequestMapping(value = "/project.html", method = RequestMethod.GET)
	public ModelAndView listProject() {
		ModelAndView modelAndView = new ModelAndView("project");
		Employee employee = employeeDataHandler.getEmployeeByName(getAuthentication().getName());
		Collection<Project> projects = iProjectService.getProject(employee.getEmployeeId());
		modelAndView.addObject("employee", employee);
		modelAndView.addObject("projectList", projects);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/addproject.html", method = RequestMethod.POST)
	public String addproject(@ModelAttribute("project") Project project, BindingResult result){
		iProjectService.addProject(project);
		return "redirect:/project";
	}

	@RequestMapping("/")
	public String main(Model ui)
	{
		return "redirect:/project.html";
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

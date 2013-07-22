package com.epam.training.controller.pages;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.training.model.domain.database.datahandler.IEmployeeDataHandler;
import com.epam.training.model.domain.entities.Assignment;
import com.epam.training.model.domain.entities.Comment;
import com.epam.training.model.domain.entities.Employee;
import com.epam.training.model.domain.entities.Role;
import com.epam.training.model.service.IAssignmentService;
import com.epam.training.model.service.ICommentService;


@Controller
public class ProfileController {
	
	@Autowired
	private IEmployeeDataHandler employeeDataHandler;
	
	@Autowired
	private IAssignmentService assignmentService;
	
	@Autowired
	private ICommentService commentService;
	
	@RequestMapping(value = "/profile.html", method= RequestMethod.GET)
	private String listProject(Model ui) {
		Employee employee = employeeDataHandler.getEmployeeByName(getAuthentication().getName());
		List<Role> roles = employee.getRoles();
		List<Assignment> assignments = assignmentService.getEmployeeAssignment(employee.getEmployeeId());
		List<Comment> comments = commentService.getCommentbyAuthor(employee.getEmployeeId());
		ui.addAttribute("comments", comments);
		ui.addAttribute("roles", roles);
		ui.addAttribute("employee", employee);
		ui.addAttribute("assignments", assignments);
		
		return "profile";
	}
	
	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public IEmployeeDataHandler getEmployeeDataHandler() {
		return employeeDataHandler;
	}

	public void setEmployeeDataHandler(IEmployeeDataHandler employeeDataHandler) {
		this.employeeDataHandler = employeeDataHandler;
	}
}

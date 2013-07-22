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
import com.epam.training.model.domain.entities.Activity;
import com.epam.training.model.domain.entities.Assignment;
import com.epam.training.model.domain.entities.Comment;
import com.epam.training.model.domain.entities.Employee;
import com.epam.training.model.domain.entities.Task;
import com.epam.training.model.service.IActivityService;
import com.epam.training.model.service.IAssignmentService;
import com.epam.training.model.service.ICommentService;
import com.epam.training.model.service.ITaskService;


@Controller
public class DetailTaskController {
	
	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private IAssignmentService assignmentService;
	
	@Autowired
	private IEmployeeDataHandler employeeDataHandler;
	
	@Autowired
	private IActivityService activityService;
	
	@Autowired
	private ICommentService commentService;
	
	@RequestMapping(value = "/detailtask.html", params = {"id"}, method= RequestMethod.GET)
	private String listProject(Model ui, @RequestParam(value="id") int id){
		Task task = taskService.getTaskById(id);
		Employee employee = employeeDataHandler.getEmployeeByName(getAuthentication().getName());
		Assignment assignment = assignmentService.getTaskAssignment(id).get(0);
		List<Assignment> assignments = assignmentService.getTaskAssignment(id);
		List<Activity> activities = activityService.getActivity(task.getTaskId());
		List<Comment> comments = commentService.getCommentbyTask(id);
		ui.addAttribute("comments", comments );
		ui.addAttribute("activities", activities );
		ui.addAttribute("employee", employee );
		ui.addAttribute("assignments", assignments);
		ui.addAttribute("assignment", assignment );
		ui.addAttribute("task", task);
		return "detailtask";
	}

	public ITaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(ITaskService taskService) {
		this.taskService = taskService;
	}

	public IAssignmentService getAssignmentService() {
		return assignmentService;
	}

	public void setAssignmentService(IAssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	public IEmployeeDataHandler getEmployeeDataHandler() {
		return employeeDataHandler;
	}

	public void setEmployeeDataHandler(IEmployeeDataHandler employeeDataHandler) {
		this.employeeDataHandler = employeeDataHandler;
	}
	
	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}

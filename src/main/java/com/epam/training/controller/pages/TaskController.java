package com.epam.training.controller.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.training.model.domain.database.datahandler.IAssignmentDataHandler;
import com.epam.training.model.domain.database.datahandler.IEmployeeDataHandler;
import com.epam.training.model.domain.entities.Assignment;
import com.epam.training.model.domain.entities.Employee;
import com.epam.training.model.domain.entities.Project;
import com.epam.training.model.domain.entities.Task;
import com.epam.training.model.domain.entities.TaskStatus;
import com.epam.training.model.service.IAssignmentService;
import com.epam.training.model.service.IProjectService;
import com.epam.training.model.service.ITaskService;
import com.epam.training.model.service.ITaskStatusService;

@Controller
public class TaskController {

	@Autowired
	private ITaskService iTaskService;
	
	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private IEmployeeDataHandler employeeDataHandler;
	
	@Autowired
	private IAssignmentService assignmentService;
	
	@Autowired
	private ITaskStatusService taskStatusService;
	
	@RequestMapping(value = "/task.html", method= RequestMethod.GET)
	public String listProject(Model ui) {
		return "task";
	}
	
	@RequestMapping(value = "/task.html", params = {"id"}, method= RequestMethod.GET)
	public String listProject(Model ui, @RequestParam(value="id") int id) {
		List<Task> taskList = iTaskService.getProjectTask(id);
		Employee employee = employeeDataHandler.getEmployeeByName(getAuthentication().getName());
		Project project = null; 
		project = projectService.getProjectById(id);
		Task task = new Task();
		List<TaskStatus> taskStatus = taskStatusService.getAllTaskStatus();
		//List<Assignment> assignment = assignmentService.getTaskAssignment(id);\
		ui.addAttribute("project", project);
		ui.addAttribute("employee", employee);
		ui.addAttribute("taskList", taskList);
		ui.addAttribute("task", task);
		ui.addAttribute("taskStatus", taskStatus);
		//ui.addAttribute("assignment", assignment);
		
		return "task";
	}
	
	@RequestMapping(value="/addtask", params = {"id"}, method = RequestMethod.POST)
	public String addTask(@ModelAttribute("task") Task task, @RequestParam(value = "id") int id, BindingResult result){
		task.setProject(projectService.getProjectById(id));
		iTaskService.addTask(task);
		return "redirect:/task.html?id=" + id;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	protected Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}


	public ITaskService getiTaskService() {
		return iTaskService;
	}

	public void setiTaskService(ITaskService iTaskService) {
		this.iTaskService = iTaskService;
	}

	public IProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public IEmployeeDataHandler getEmployeeDataHandler() {
		return employeeDataHandler;
	}

	public void setEmployeeDataHandler(IEmployeeDataHandler employeeDataHandler) {
		this.employeeDataHandler = employeeDataHandler;
	}

	public IAssignmentService getAssignmentService() {
		return assignmentService;
	}

	public void setAssignmentService(IAssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	public ITaskStatusService getTaskStatusService() {
		return taskStatusService;
	}

	public void setTaskStatusService(ITaskStatusService taskStatusService) {
		this.taskStatusService = taskStatusService;
	}
}

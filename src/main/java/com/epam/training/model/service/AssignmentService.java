package com.epam.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.model.domain.database.datahandler.IAssignmentDataHandler;
import com.epam.training.model.domain.entities.Assignment;

@Service
public class AssignmentService implements IAssignmentService {

	@Autowired
	private IAssignmentDataHandler assignmentDataHandler;
	
	@Override
	public List<Assignment> getTaskAssignment(int id) {
		return assignmentDataHandler.getTaskAssignment(id);
	}
	
	@Override
	public List<Assignment> getEmployeeAssignment(int id) {
		return assignmentDataHandler.getEmployeeAssignment(id);
	}

	public IAssignmentDataHandler getAssignmentDataHandler() {
		return assignmentDataHandler;
	}

	public void setAssignmentDataHandler(
			IAssignmentDataHandler assignmentDataHandler) {
		this.assignmentDataHandler = assignmentDataHandler;
	}


	
}

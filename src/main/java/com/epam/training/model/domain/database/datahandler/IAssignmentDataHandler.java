package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import com.epam.training.model.domain.entities.Assignment;

public interface IAssignmentDataHandler {
	
	public List<Assignment> getTaskAssignment(int id);
	public List<Assignment> getEmployeeAssignment(int id);
}

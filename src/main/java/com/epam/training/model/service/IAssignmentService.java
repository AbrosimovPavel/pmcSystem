package com.epam.training.model.service;

import java.util.List;

import com.epam.training.model.domain.entities.Assignment;

public interface IAssignmentService {
	public List<Assignment> getTaskAssignment(int id);
	public List<Assignment> getEmployeeAssignment(int id);
}

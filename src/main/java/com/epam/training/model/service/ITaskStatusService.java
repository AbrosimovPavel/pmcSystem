package com.epam.training.model.service;

import java.util.List;

import com.epam.training.model.domain.entities.TaskStatus;

public interface ITaskStatusService {
	public List<TaskStatus> getAllTaskStatus();
}

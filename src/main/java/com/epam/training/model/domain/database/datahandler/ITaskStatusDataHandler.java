package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import com.epam.training.model.domain.entities.TaskStatus;

public interface ITaskStatusDataHandler {
	public List<TaskStatus> getAllTaskStatus();
}

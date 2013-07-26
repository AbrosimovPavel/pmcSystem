package com.epam.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.model.domain.database.datahandler.ITaskStatusDataHandler;
import com.epam.training.model.domain.entities.TaskStatus;

@Service
public class TaskStatusService implements ITaskStatusService {

	@Autowired
	private ITaskStatusDataHandler statusDataHandler;
	
	@Override
	public List<TaskStatus> getAllTaskStatus() {
		return statusDataHandler.getAllTaskStatus();
	}

}

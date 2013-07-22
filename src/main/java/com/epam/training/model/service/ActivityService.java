package com.epam.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.model.domain.database.datahandler.IActivityDataHandler;
import com.epam.training.model.domain.entities.Activity;

@Service
public class ActivityService implements IActivityService {

	@Autowired
	private IActivityDataHandler activityDataHandler;
	
	@Override
	public List<Activity> getActivity(int id) {
		return activityDataHandler.getActivity(id);
	}

}

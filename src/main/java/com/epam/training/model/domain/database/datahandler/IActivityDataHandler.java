package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import com.epam.training.model.domain.entities.Activity;

public interface IActivityDataHandler {

	
	public List<Activity> getActivity(int id);
}

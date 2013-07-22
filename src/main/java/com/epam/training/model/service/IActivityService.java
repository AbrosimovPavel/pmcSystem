package com.epam.training.model.service;

import java.util.List;

import com.epam.training.model.domain.entities.Activity;

public interface IActivityService {
	public List<Activity> getActivity(int id);
}

package com.epam.training.model.domain.database.datahandler;

import java.util.List;

import com.epam.training.model.domain.entities.*;

public interface IEmployeeDataHandler {
	public List<Employee> getAllEmployees();
	public void updateEmployee(Employee emp, Integer id);
    public void deleteEmployee(Integer id);
    public Employee getEmployeeById(Integer id);
    public Employee getEmployeeByName(String name);
    public void addEmployee(Employee emp);
}

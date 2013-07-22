package com.epam.training.model.domain.database.datahandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import org.h2.jdbcx.JdbcConnectionPool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.model.domain.entities.Employee;
import com.epam.training.model.domain.entities.Project;
import com.epam.training.model.domain.entities.Role;
import com.epam.training.model.domain.entities.Task;

@Repository
public class EmployeeDataHandler implements IEmployeeDataHandler {

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		List<Employee> employees = session.createQuery("from Employee").list();
		session.close();
		return employees;
	}

	@Override
	public void updateEmployee(Employee emp, Integer id) {
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		
	}

	@Override
	@Transactional
	public Employee getEmployeeById(Integer id) {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.createQuery("from Employee where employee_id = :id")
				 .setInteger("id", id).uniqueResult();
		session.close();
		return employee;
	}

	@Override
	@Transactional
	public Employee getEmployeeByName(String name) {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.createQuery("from Employee where first_name = :name")
				 .setString("name", name).uniqueResult();
		session.close();
		return employee;
	}

	@Override
	public void addEmployee(Employee emp) {
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
/*
	@Autowired
	private JdbcConnectionPool connectionPool;

	public JdbcConnectionPool getConnectionPool() {
		return connectionPool;
	}

	public void setConnectionPool(JdbcConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			String sqlQuery = "SELECT employee.employee_id, employee.first_name, employee.last_name, "
					+ "employee.password, position.name as position_name, role.role_id as role_id, role.name as role_name "
					+ "FROM (Employee JOIN position ON employee.position_id=position.position_id) "
					+ "JOIN (role JOIN employee_roles ON role.role_id=employee_roles.role_id)"
					+ "ON employee.employee_id=employee_roles.employee_id";
			Connection connection = connectionPool.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sqlQuery);
			while (rs.next()) {
				ArrayList<Role> roleList = new ArrayList<Role>();
				roleList.add(new Role(rs.getInt("role_id"),rs.getString("role_name")));
				employeeList.add(new Employee(rs.getInt("employee_id"), 
											  rs.getString("first_name"), 
											  rs.getString("last_name"), 
											  rs.getString("password"), 
 											  roleList));
			}
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public void deleteEmployee(Integer id) {

	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return null;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		try {
			String sqlQuery = "SELECT employee.employee_id, employee.first_name, employee.last_name, "
					+ "employee.password, position.name as position_name, role.role_id as role_id, role.name as role_name "
					+ "FROM (Employee JOIN position ON employee.position_id=position.position_id) "
					+ "JOIN (role JOIN employee_roles ON role.role_id=employee_roles.role_id)"
					+ "ON employee.employee_id=employee_roles.employee_id "
					+ "WHERE employee.first_name=?";
			Connection connection = connectionPool.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(sqlQuery);
			pStatement.setString(1, name);
			ResultSet rs = pStatement.executeQuery();
			while (rs.next()) {
				ArrayList<Role> roleList = new ArrayList<Role>();
				roleList.add(new Role(rs.getInt("role_id"),rs.getString("role_name")));
				return new Employee(rs.getInt("employee_id"), 
											  rs.getString("first_name"), 
											  rs.getString("last_name"), 
											  rs.getString("password"), 
 											  roleList);
			}
			pStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmployee(Employee emp, Integer id) {
		
	}

	@Override
	public void addEmployee(Employee emp) {
		
	}
*/

}

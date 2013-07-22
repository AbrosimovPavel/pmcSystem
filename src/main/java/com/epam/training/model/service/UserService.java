package com.epam.training.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.training.model.domain.database.datahandler.IEmployeeDataHandler;
import com.epam.training.model.domain.entities.Employee;

import java.util.ArrayList;
import java.util.Collection;

@Service("userDetailsService")
@SuppressWarnings("deprecation")
public class UserService implements UserDetailsService {

	@Autowired
	private IEmployeeDataHandler employeeDataHandler;
    

	@Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, DataAccessException {

        Employee user = employeeDataHandler.getEmployeeByName(login);

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        Collection<GrantedAuthority> col = new ArrayList<GrantedAuthority>();
        int countRols = user.getRoles().size();
        for (int i=0; i<countRols ; i++){
        	col.add(new GrantedAuthorityImpl(user.getRoles().get(i).getName()));
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User( user.getFirstName(),
                user.getPassword(), true, true, true, true, col);

        return userDetails;
    }


	public IEmployeeDataHandler getEmployeeDataHandler() {
		return employeeDataHandler;
	}


	public void setEmployeeDataHandler(IEmployeeDataHandler employeeDataHandler) {
		this.employeeDataHandler = employeeDataHandler;
	}




}

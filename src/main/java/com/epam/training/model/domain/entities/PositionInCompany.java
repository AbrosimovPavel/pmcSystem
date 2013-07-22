package com.epam.training.model.domain.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="position")
public class PositionInCompany {
	@Id
	@Column(name="position_id")
	@GeneratedValue
	private Integer positionId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="position_id")
	public Set<Employee> employees;
	
	public PositionInCompany(){
		
	}

	public PositionInCompany(Integer positionId, String name) {
		super();
		this.positionId = positionId;
		this.name = name;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	
}

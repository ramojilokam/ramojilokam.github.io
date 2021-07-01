package com.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetails{
	
	@Id
	private Long employeeId;
	
	private String employeeName;
	
	private String employeeDesignation;
	
	private String employeeProject;
	
	private String employeeSalary;
	
	private String employeeCostCenter;
	
	private String employeeAddress;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeProject() {
		return employeeProject;
	}

	public void setEmployeeProject(String employeeProject) {
		this.employeeProject = employeeProject;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeCostCenter() {
		return employeeCostCenter;
	}

	public void setEmployeeCostCenter(String employeeCostCenter) {
		this.employeeCostCenter = employeeCostCenter;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDesignation="
				+ employeeDesignation + ", employeeProject=" + employeeProject + ", employeeSalary=" + employeeSalary
				+ ", employeeCostCenter=" + employeeCostCenter + ", employeeAddress=" + employeeAddress + "]";
	}
	
	

}

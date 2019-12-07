package Metier;

import java.util.List;

import Entities.Employee;

public interface EmployeeMetier {
	public Employee saveEmployee(Employee E);
	public List<Employee>ListEmployees();

}

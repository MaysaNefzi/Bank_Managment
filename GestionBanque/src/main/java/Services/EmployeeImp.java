package Services;

import java.util.List;

import DAO.EmployeeRepository;
import Entities.Employee;
import Metier.EmployeeMetier;

public class EmployeeImp implements EmployeeMetier{
	private EmployeeRepository ER;

	@Override
	public Employee saveEmployee(Employee E) {
		return ER.save(E);
	}

	@Override
	public List<Employee> ListEmployees() {
		return ER.findAll();
	}

}

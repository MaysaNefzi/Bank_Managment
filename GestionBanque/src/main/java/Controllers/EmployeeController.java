package Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.EmployeeRepository;
import Entities.Employee;
import Metier.EmployeeMetier;
@RequestMapping("/Employee")
public class EmployeeController implements EmployeeMetier{
	private EmployeeRepository ER;

	@PostMapping("/newEmployee")
	public Employee saveEmployee(Employee E) {
		return ER.save(E);
	}

	@GetMapping("/allEmployees")
	public List<Employee> ListEmployees() {
		return ER.findAll();
	}
	@GetMapping("/employeeById/{code}")
	public Optional<Employee> findEmpById(@PathVariable("code") Long codeEmp) {
		return ER.findById(codeEmp);
	}
	@PutMapping("/updateEmp/{code}")
	public ResponseEntity<Object> updateEmp(@Valid @RequestBody Employee e ,@PathVariable("code") long code){
		Optional<Employee> EmployeeOptional = ER.findById(code);
		if(EmployeeOptional.isEmpty())
			return ResponseEntity.notFound().build();
		Employee emp = EmployeeOptional.get();
		emp.setCodeEmp(code);
		emp.setNameEmp(e.getNameEmp());
		emp.setFirstNameEmp(e.getFirstNameEmp());
		emp.setGroupes(e.getGroupes());
		emp.setEmpSup(e.getEmpSup());
		Employee result= ER.save(emp);
		return ResponseEntity.ok().body(result);
		
		
	}


}

package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{

}

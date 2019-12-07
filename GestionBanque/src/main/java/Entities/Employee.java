package Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Long CodeEmp;
	private String NameEmp;
	private String FirstNameEmp;
	@ManyToOne
	@JoinColumn(name="Code_emp_sup")
	private Employee EmpSup;
	@ManyToMany
	@JoinTable(name="Emp_Gr",joinColumns=
	@JoinColumn(name="Num_emp"),inverseJoinColumns=
	@JoinColumn(name="Num_Groupe"))
	private Collection<Groupe>groupes;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String nameEmp, String firstNameEmp, Employee empSup) {
		super();
		NameEmp = nameEmp;
		FirstNameEmp = firstNameEmp;
		EmpSup = empSup;
	}
	public Long getCodeEmp() {
		return CodeEmp;
	}
	public void setCodeEmp(Long codeEmp) {
		CodeEmp = codeEmp;
	}
	public String getNameEmp() {
		return NameEmp;
	}
	public void setNameEmp(String nameEmp) {
		NameEmp = nameEmp;
	}
	public String getFirstNameEmp() {
		return FirstNameEmp;
	}
	public void setFirstNameEmp(String firstNameEmp) {
		FirstNameEmp = firstNameEmp;
	}
	public Employee getEmpSup() {
		return EmpSup;
	}
	public void setEmpSup(Employee empSup) {
		EmpSup = empSup;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	
}

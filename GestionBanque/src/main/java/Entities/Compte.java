package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Compte",discriminatorType=DiscriminatorType.STRING,length=2)
public class Compte implements Serializable {
	@Id
	private String codeCompte;
	private Date CreationDate;
	private double solde;
	@ManyToOne
	@JoinColumn(name="Code_client")
	private Client client;
	@ManyToOne
	@JoinColumn(name="Code_Employee")
	private Employee employee;
	@OneToMany(mappedBy="compte")
	private Collection <Operation> operations;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String codeCompte, Date creationDate, double solde, Client client, Employee employee) {
		super();
		this.codeCompte = codeCompte;
		CreationDate = creationDate;
		this.solde = solde;
		this.client = client;
		this.employee = employee;
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		operations = operations;
	}
	
	

}

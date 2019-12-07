package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Operation",discriminatorType=DiscriminatorType.STRING,length=1)
public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long NumOperation;
	private Date DateOperation;
	private double Montant;
	@ManyToOne
	@JoinColumn(name="Code_Compte")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="Code_Employe")
	private Employee employe;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double montant, Compte compte, Employee employe) {
		super();
		DateOperation = dateOperation;
		Montant = montant;
		this.compte = compte;
		this.employe = employe;
	}
	public Long getNumOperation() {
		return NumOperation;
	}
	public void setNumOperation(Long numOperation) {
		NumOperation = numOperation;
	}
	public Date getDateOperation() {
		return DateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		DateOperation = dateOperation;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employee getEmploye() {
		return employe;
	}
	public void setEmploye(Employee employe) {
		this.employe = employe;
	}
	
}

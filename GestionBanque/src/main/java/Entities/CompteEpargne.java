package Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double taux;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CompteEpargne(String codeCompte, Date creationDate, double solde, Client client, Employee employee,
			double taux) {
		super(codeCompte, creationDate, solde, client, employee);
		this.taux = taux;
	}



	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}

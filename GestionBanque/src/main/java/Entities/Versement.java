package Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, double montant, Compte compte, Employee employe) {
		super(dateOperation, montant, compte, employe);
		// TODO Auto-generated constructor stub
	}

	
}

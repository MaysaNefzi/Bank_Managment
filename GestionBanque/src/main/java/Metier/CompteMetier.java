package Metier;

import Entities.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte c);
	public Compte getCompte(String code);

}

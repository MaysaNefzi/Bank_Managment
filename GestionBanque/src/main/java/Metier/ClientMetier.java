package Metier;

import java.util.List;

import Entities.Client;

public interface ClientMetier {
	public Client saveClient(Client c);
	public List<Client> listeClient();

}

package Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Num_Group;
	private String nomGroupe;

	@ManyToMany(mappedBy="groupes")
	private Collection<Employee> employes;

	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}

	public Long getNum_Group() {
		return Num_Group;
	}

	public void setNum_Group(Long num_Group) {
		Num_Group = num_Group;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Collection<Employee> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employee> employes) {
		this.employes = employes;
	}
	
}

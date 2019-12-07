package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue
	private Long code;
	private String name;
	private String firstname;
	private String email;
	@OneToMany (mappedBy ="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String name, String firstname, String email) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.email = email;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	

}

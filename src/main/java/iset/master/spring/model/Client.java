package iset.master.spring.model;

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
	private Long id;
	private String nom_clt;
	private String adresse_clt;
	@OneToMany (mappedBy="client", fetch=FetchType.LAZY)
	private Collection <Sortie> sortie;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_clt() {
		return nom_clt;
	}
	public void setNom_clt(String nom_clt) {
		this.nom_clt = nom_clt;
	}
	public String getAdresse_clt() {
		return adresse_clt;
	}
	public void setAdresse_clt(String adresse_clt) {
		this.adresse_clt = adresse_clt;
	}
	public Collection<Sortie> getSortie() {
		return sortie;
	}
	public void setSortie(Collection<Sortie> sortie) {
		this.sortie = sortie;
	}
	public Client() {
		super();
	}
	
	
}

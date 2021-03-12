package iset.master.spring.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue
	private Long id_fr;
	private String nom_fr;
	private String adresse_fr;
	@OneToMany (mappedBy="fournisseur", fetch=FetchType.LAZY)
	private Collection <Entree> entree;
	public Fournisseur() {
		super();
	}
	public Long getId_fr() {
		return id_fr;
	}
	public void setId_fr(Long id_fr) {
		this.id_fr = id_fr;
	}
	public String getNom_fr() {
		return nom_fr;
	}
	public void setNom_fr(String nom_fr) {
		this.nom_fr = nom_fr;
	}
	public String getAdresse_fr() {
		return adresse_fr;
	}
	public void setAdresse_fr(String adresse_fr) {
		this.adresse_fr = adresse_fr;
	}
	public Collection<Entree> getEntree() {
		return entree;
	}
	public void setEntree(Collection<Entree> entree) {
		this.entree = entree;
	}
	
}

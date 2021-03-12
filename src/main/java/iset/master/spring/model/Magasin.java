package iset.master.spring.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Magasin implements Serializable {
	@Id
	@GeneratedValue
	private Long id_magasin;
	private String designation_magasin;
	@OneToMany (mappedBy="magasin", fetch=FetchType.LAZY)
	private Collection <Entree> entree;
	public Magasin() {
		super();
	}
	public Long getId_magasin() {
		return id_magasin;
	}
	public void setId_magasin(Long id_magasin) {
		this.id_magasin = id_magasin;
	}
	public String getDesignation_magasin() {
		return designation_magasin;
	}
	public void setDesignation_magasin(String designation_magasin) {
		this.designation_magasin = designation_magasin;
	}
	public Collection<Entree> getEntree() {
		return entree;
	}
	public void setEntree(Collection<Entree> entree) {
		this.entree = entree;
	}
	
}

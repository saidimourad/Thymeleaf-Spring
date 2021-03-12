package iset.master.spring.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Entree implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_entree")
	private Long id_entree;
	private String ref_entree;
	@Temporal(TemporalType.DATE)
	private Date date_entree;
	private Double prixTotal_entree;
	@ManyToOne
	@JoinColumn(name = "id_magasin")
	private Magasin magasin;
	@ManyToOne
	@JoinColumn(name = "id_fr")
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy="entree",fetch=FetchType.LAZY)
    private Collection<Detail_Entree> detailsE ;

	public Entree() {
		super();
	}

	public Long getId_entree() {
		return id_entree;
	}

	public void setId_entree(Long id_entree) {
		this.id_entree = id_entree;
	}

	public String getRef_entree() {
		return ref_entree;
	}

	public void setRef_entree(String ref_entree) {
		this.ref_entree = ref_entree;
	}

	public Date getDate_entree() {
		return date_entree;
	}

	public void setDate_entree(Date date_entree) {
		this.date_entree = date_entree;
	}

	public Double getPrixTotal_entree() {
		return prixTotal_entree;
	}

	public void setPrixTotal_entree(Double prixTotal_entree) {
		this.prixTotal_entree = prixTotal_entree;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Collection<Detail_Entree> getDetailsE() {
		return detailsE;
	}

	public void setDetailsE(Collection<Detail_Entree> detailsE) {
		this.detailsE = detailsE;
	}

}

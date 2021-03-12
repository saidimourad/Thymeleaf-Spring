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
public class Sortie implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sortie;
	private String ref_sortie;
	@Temporal(TemporalType.DATE)
	private Date date_sortie;
	private Double prixTotal_sortie;
	@ManyToOne
	@JoinColumn(name = "id_magasin")
	private Magasin magasin;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private Client client;
	
	@OneToMany(mappedBy="sortieD",fetch=FetchType.LAZY)
    private Collection<Detail_Sortie> detail_sortie ;

	public Long getId_sortie() {
		return id_sortie;
	}

	public void setId_sortie(Long id_sortie) {
		this.id_sortie = id_sortie;
	}

	public String getRef_sortie() {
		return ref_sortie;
	}

	public void setRef_sortie(String ref_sortie) {
		this.ref_sortie = ref_sortie;
	}

	public Date getDate_sortie() {
		return date_sortie;
	}

	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}

	public Double getPrixTotal_sortie() {
		return prixTotal_sortie;
	}

	public void setPrixTotal_sortie(Double prixTotal_sortie) {
		this.prixTotal_sortie = prixTotal_sortie;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Detail_Sortie> getDetail_sortie() {
		return detail_sortie;
	}

	public void setDetail_sortie(Collection<Detail_Sortie> detail_sortie) {
		this.detail_sortie = detail_sortie;
	}

	public Sortie() {
		super();
	}
}

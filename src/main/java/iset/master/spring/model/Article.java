package iset.master.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.FieldResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity


public class Article implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_art;
	@NotNull
	@Size(min=3, max=50)
	private String designation_art;
	private String unite_art;
	@NotNull
  //  @Min(1)
	private BigDecimal qte_stock;
	@NotNull
    //@Min(1)
	@DecimalMin("1")
    private BigDecimal prix_art;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private Categorie categorie;
	
	
	@OneToMany(mappedBy="articleE",fetch=FetchType.LAZY)
    private Collection<Detail_Entree> detailsE ;
    
    
	@OneToMany(mappedBy="articleS",fetch=FetchType.LAZY)
    private Collection<Detail_Sortie> detailsS ;
	
	public Article() {
		super();
	}

	public Long getId_art() {
		return id_art;
	}

	public void setId_art(Long id_art) {
		this.id_art = id_art;
	}

	public String getDesignation_art() {
		return designation_art;
	}

	public void setDesignation_art(String designation_art) {
		this.designation_art = designation_art;
	}

	public BigDecimal getQte_stock() {
		return qte_stock;
	}

	public void setQte_stock(BigDecimal qte_stock) {
		this.qte_stock = qte_stock;
	}

	public BigDecimal getPrix_art() {
		return prix_art;
	}

	public void setPrix_art(BigDecimal prix_art) {
		this.prix_art = prix_art;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Collection<Detail_Entree> getDetailsE() {
		return detailsE;
	}

	public void setDetailsE(Collection<Detail_Entree> detailsE) {
		this.detailsE = detailsE;
	}

	public Collection<Detail_Sortie> getDetailsS() {
		return detailsS;
	}

	public void setDetailsS(Collection<Detail_Sortie> detailsS) {
		this.detailsS = detailsS;
	}

	public String getUnite_art() {
		return unite_art;
	}

	public void setUnite_art(String unite_art) {
		this.unite_art = unite_art;
	}
	
}

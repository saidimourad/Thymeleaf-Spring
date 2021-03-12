package iset.master.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Detail_Sortie implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_DetailS")
	private Long id_DetailS;
	private Double qteSortie;
	private Double prixSortie;
	
	@ManyToOne
    @JoinColumn (name="id_art")
	private Article articleS;
	
	@ManyToOne
	@JoinColumn (name="id_sortie")
	private Sortie sortieD;

	public Long getId_DetailS() {
		return id_DetailS;
	}

	public void setId_DetailS(Long id_DetailS) {
		this.id_DetailS = id_DetailS;
	}

	public Double getQteSortie() {
		return qteSortie;
	}

	public void setQteSortie(Double qteSortie) {
		this.qteSortie = qteSortie;
	}

	public Double getPrixSortie() {
		return prixSortie;
	}

	public void setPrixSortie(Double prixSortie) {
		this.prixSortie = prixSortie;
	}

	public Article getArticleS() {
		return articleS;
	}

	public void setArticleS(Article articleS) {
		this.articleS = articleS;
	}

	public Sortie getSortieD() {
		return sortieD;
	}

	public void setSortieD(Sortie sortieD) {
		this.sortieD = sortieD;
	}

	public Detail_Sortie() {
		super();
	}
}

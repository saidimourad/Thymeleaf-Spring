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
public class Detail_Entree implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detaile")
	private int id_detaile;
	private Double qteEntre;
	private Double prixEntre;
	
	
    @ManyToOne
    @JoinColumn (name="id_art")
    private Article articleE;


@ManyToOne
@JoinColumn (name="id_entree")
private Entree entree;


public int getId_detaile() {
	return id_detaile;
}


public void setId_detaile(int id_detaile) {
	this.id_detaile = id_detaile;
}


public Double getQteEntre() {
	return qteEntre;
}


public void setQteEntre(Double qteEntre) {
	this.qteEntre = qteEntre;
}


public Double getPrixEntre() {
	return prixEntre;
}


public void setPrixEntre(Double prixEntre) {
	this.prixEntre = prixEntre;
}


public Article getArticleE() {
	return articleE;
}


public void setArticleE(Article articleE) {
	this.articleE = articleE;
}


public Entree getEntree() {
	return entree;
}


public void setEntree(Entree entree) {
	this.entree = entree;
}


public Detail_Entree() {
	super();
}

}

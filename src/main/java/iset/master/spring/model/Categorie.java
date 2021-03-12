package iset.master.spring.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String designation_cat;
	@OneToMany (mappedBy="categorie", fetch=FetchType.LAZY)
	private Collection <Article> article;
	public Categorie() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation_cat() {
		return designation_cat;
	}
	public void setDesignation_cat(String designation_cat) {
		this.designation_cat = designation_cat;
	}
	public Collection<Article> getArticle() {
		return article;
	}
	public void setArticle(Collection<Article> article) {
		this.article = article;
	}

	
}

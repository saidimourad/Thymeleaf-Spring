package iset.master.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iset.master.spring.model.Article;
import iset.master.spring.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	@Query ("select a from Categorie a where a.designation_cat like :x ")
	public Page<Categorie> chercherParMotCle (@Param ("x") String mc,	Pageable pageable);
	
} 

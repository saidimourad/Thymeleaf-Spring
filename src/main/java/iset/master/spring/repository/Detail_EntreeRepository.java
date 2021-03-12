package iset.master.spring.repository;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iset.master.spring.model.Article;
import iset.master.spring.model.Detail_Entree;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
public interface Detail_EntreeRepository extends JpaRepository<Detail_Entree, Long> {
	
	@Query ("select d from Detail_Entree d where d.entree.id_entree= :x ")
	public List<Detail_Entree> findByentree (@Param ("x") Long id);
	
	
	//@Query ("select d from Detail_Entree d where d.articleE.id_art= :x ")
	@Query ("select d from Detail_Entree d where d.entree.id_entree= :x ")
	public List<Detail_Entree> findByDetailEntree (@Param ("x") Long id);
	
	@Query ("select d from Detail_Entree d where d.articleE.id_art= :x ")
		//@Query ("select d from Detail_Entree d where d.entree.id_entree= :x ")
		public List<Detail_Entree> findByDetailAEntree (@Param ("x") Long id);


}

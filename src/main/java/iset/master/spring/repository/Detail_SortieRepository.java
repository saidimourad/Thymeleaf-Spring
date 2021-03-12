package iset.master.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iset.master.spring.model.Detail_Entree;
import iset.master.spring.model.Detail_Sortie;



public interface Detail_SortieRepository extends JpaRepository<Detail_Sortie, Long> {
	
	
	//@Query ("select d from Detail_Sortie d where d.articleS.id_art= :x ")
	@Query ("select d from Detail_Sortie d where d.sortieD.id_sortie= :x ")
	public List<Detail_Sortie> findByDetailSortie (@Param ("x") Long id);
	
	@Query ("select d from Detail_Sortie d where d.articleS.id_art= :x ")
		//@Query ("select d from Detail_Sortie d where d.sortieD.id_sortie= :x ")
		public List<Detail_Sortie> findByDetailASortie (@Param ("x") Long id);

}

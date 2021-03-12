package iset.master.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iset.master.spring.model.Entree;
import iset.master.spring.model.Sortie;

public interface SortieRepository extends JpaRepository<Sortie, Long>{
	
	@Query ("select s from Sortie s where s.ref_sortie like :x ")
	public Page<Sortie> chercherSortie(@Param ("x") String mc,	Pageable pageable);
	
	@Query ("select max(s.id_sortie) FROM Sortie s  ")
	public int maxSortie();
}

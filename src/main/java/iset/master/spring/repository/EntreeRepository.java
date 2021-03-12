package iset.master.spring.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iset.master.spring.model.Entree;

public interface EntreeRepository extends JpaRepository<Entree, Long>{
	
	@Query ("select e from Entree e where e.ref_entree like :x ")
	public Page<Entree> chercherEntree(@Param ("x") String mc,	Pageable pageable);
	
	@Query ("select max(e.id_entree) FROM Entree e  ")
	public int maxEntree();
	

}

package iset.master.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import iset.master.spring.model.Magasin;

public interface MagasinRepository extends JpaRepository<Magasin, Long> {

}

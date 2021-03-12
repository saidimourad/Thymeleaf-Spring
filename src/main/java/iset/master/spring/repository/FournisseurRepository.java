package iset.master.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import iset.master.spring.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}

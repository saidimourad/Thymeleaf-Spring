package iset.master.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iset.master.spring.model.Client;
import iset.master.spring.model.Detail_Entree;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

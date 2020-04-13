package br.com.testapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testapi.entities.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long>{
	
	Viagem findByLocalDeDestino(String localDeDestino);
}

package br.com.sor.app.gateway.database.repository;

import br.com.sor.app.gateway.database.MercadoriaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoriaRepository extends JpaRepository<MercadoriaData, Integer> {

}

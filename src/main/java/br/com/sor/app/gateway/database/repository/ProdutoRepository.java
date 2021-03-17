package br.com.sor.app.gateway.database.repository;

import br.com.sor.app.gateway.database.ProdutoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoData, Integer> {

}

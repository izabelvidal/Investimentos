package br.com.inter.Investimentos.repository;

import br.com.inter.Investimentos.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<CompraModel, Integer> {
}

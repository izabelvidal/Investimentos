package br.com.inter.Investimentos.repository;

import br.com.inter.Investimentos.model.InvestidorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestidorRepository extends JpaRepository<InvestidorModel, Integer> {
}

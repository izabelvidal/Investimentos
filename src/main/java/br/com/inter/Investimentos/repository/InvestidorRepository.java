package br.com.inter.Investimentos.repository;

import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.model.InvestidorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvestidorRepository extends JpaRepository<InvestidorModel, Integer> {

    @Query("SELECT i FROM InvestidorModel i WHERE i.cpf = :#{#cpf}")
    Optional<InvestidorModel> findbyCpf(@Param("cpf") String cpf);
}

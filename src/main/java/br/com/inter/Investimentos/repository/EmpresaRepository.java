package br.com.inter.Investimentos.repository;

import br.com.inter.Investimentos.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {

    @Query("SELECT e FROM EmpresaModel e WHERE e.status = :#{#status}")
    Optional<List<EmpresaModel>> findbyStatus(@Param("status") String status);
}

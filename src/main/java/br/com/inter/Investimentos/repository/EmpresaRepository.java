package br.com.inter.Investimentos.repository;

import br.com.inter.Investimentos.model.domain.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {

//    @Query("SELECT e FROM Empresa e WHERE e.status = :#{status}")
//    List<EmpresaModel> findbyStatus(@Param("status") String status);
    List<EmpresaModel> findByStatus(String status);

    Optional<EmpresaModel> findByTicket(String ticket);
}

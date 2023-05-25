package it.cgmconsulting.mostracanina_corduafra.repository;

import it.cgmconsulting.mostracanina_corduafra.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProprietarioRepository extends JpaRepository<Proprietario,Integer> {


    Optional<Proprietario> findById(Integer id);

  /*  @Query(value = "SELECT it.cgmconsulting.mostracanina_corduafra.payload.response.PropietarioResponse ( " +
            "p.id, " +
            "p.nome, " +
            "p.cognome )" +
            "FROM Proprietario p " +
            "WHERE p.nome_cane = :nomeCane")
    Optional<Proprietario> getProprietario(@Param("nomeCane")String nomeCane);

*/
}

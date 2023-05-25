package it.cgmconsulting.mostracanina_corduafra.repository;

import it.cgmconsulting.mostracanina_corduafra.entity.Cane;
import it.cgmconsulting.mostracanina_corduafra.entity.Proprietario;
import it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse;
import it.cgmconsulting.mostracanina_corduafra.payload.response.ProprietarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CaneRepository extends JpaRepository<Cane, String> {

    @Query(value = "SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse (" +
            "c.codiceCane, " +
            "c.nome, " +
            "c.dataNascita )" +
            "FROM Cane c " +
            "ORDER BY dataNascita  ")
    List<CaneResponse> getCane();

    Boolean existsByCodiceCane(String codiceCane);

    
    Optional<Cane> findById(String s);

    /* @Query(value = "SELECT p.nome, p.cognome, p.id_proprietario\n" +
            "FROM proprietario p, Cane c\n" +
            "WHERE p.id_proprietario=c.id_proprietario\n" +
            "AND c.codice_cane = ' :codiceCane '", nativeQuery = true)
   List<Proprietario> getProrpietario(@Param( "codiceCane") String codiceCane);
*/

    @Query(value = "SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.ProprietarioResponse(" +
            "p.idProprietario, " +
            "p.nome, " +
            "p.cognome )" +
            "FROM Proprietario p " +
            "INNER JOIN Cane c ON p.idProprietario = c.proprietario.idProprietario " +
            "WHERE c.nomeCane= :nomeCane  ")
    List<ProprietarioResponse> getProrpietario(@Param( "nomeCane") String codiceCane);





   /* @Query(value = "SELECT c.codice_cane, c.nome,c.data_nascita " +
            "FROM cane c " +
            "WHERE c.data_nascita IN ( SELECT MIN(data_nascita) FROM cane )", nativeQuery = true)
    List<Cane> getCaneVecchio();*/

    @Query(value = " SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse(" +
            "c.codiceCane, " +
            "c.nome, " +
            "c.dataNascita )" +
            "FROM  Cane c " +
            "WHERE c.dataNascita IN (SELECT Min (dataNascita) FROM Cane )" )
            List<CaneResponse> getCaneVecchio();



/*
    @Query(value = " SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse(" +
            "c.codiceCane," +
            "c.nome," +
            "(SELECT ROUND(AVG(v.voto ),2) " +
            "FROM Voti v " +
            "WHERE v.votiId.cane.codiceCane = c.codiceCane) AS average)" +
            "FROM Cane c " +
            ""
    )
    List<CaneResponse> getMedia(@Param("nomeMostra")String nomeMostra);
/**/
}

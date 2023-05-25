package it.cgmconsulting.mostracanina_corduafra.repository;

import it.cgmconsulting.mostracanina_corduafra.entity.Razza;
import it.cgmconsulting.mostracanina_corduafra.entity.Voti;
import it.cgmconsulting.mostracanina_corduafra.entity.VotiId;
import it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface VotiRepository  extends JpaRepository<Voti, VotiId> {

 @Query(value = "SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse(" +
         "c.codiceCane, " +
         "c.nome, " +
         "AVG(v.voto) AS average) " +
         "FROM Voti v " +
         "INNER JOIN Cane c ON c.codiceCane = v.votiId.cane.codiceCane " +
         "INNER JOIN MostraCanina m ON (m.mostraCaninaId.nomeMostra=v.votiId.mostraCanina.mostraCaninaId.nomeMostra " +
         "AND m.mostraCaninaId.anno = v.votiId.mostraCanina.mostraCaninaId.anno) " +
         "WHERE m.mostraCaninaId.nomeMostra=:nomeMostra AND m.mostraCaninaId.anno=:anno "+
         "GROUP BY c.codiceCane, c.nome " +
         "ORDER BY average DESC")
  List<CaneResponse> getVincitore(@Param("nomeMostra")String nomeMostra, @Param("anno") int anno);




 @Query(value = "SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.CaneDetailResponse(" +
         "((ABS((c.peso -r.pesoStandard)/r.pesoStandard))+ ABS((c.altezza-r.altezzaStandard)/r.altezzaStandard))) AS discostamento " +
         "FROM Razza r " +
         "INNER JOIN Cane c ON c.razza.codiceRazza=r.codiceRazza " +
         "WHERE c.codiceCane= :codiceCane ")
    float getDiscostamento(@Param("codiceCane") String codiceCane );






  @Query(value = "SELECT r.codice_razza " +
          "FROM razza r " +
          "WHERE r.codice_razza NOT IN (SELECT c.codice_razza " +
          "FROM voti v, cane c " +
          "WHERE v.codice_cane=c.codice_cane )",nativeQuery = true)
    List<Byte> getRazza();




}

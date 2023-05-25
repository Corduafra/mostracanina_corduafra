package it.cgmconsulting.mostracanina_corduafra.repository;

import it.cgmconsulting.mostracanina_corduafra.entity.Giudice;
import it.cgmconsulting.mostracanina_corduafra.payload.response.GiudiceResponse;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface GiudiceRepository  extends JpaRepository<Giudice,Integer> {
/*
    @Query(value = "SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.GiudiceResponse(" +
            "g.nome, " +
            "g.cognome, " +
            "(SELECT ROUND(AVG(v.voto),2) FROM Voti v " +
            "WHERE v.votiId.giudice.idGiudice=g.idGiudice) as media)" +
            "FROM Giudice g " +
            "INNER JOIN " +
            "WHERE v.nomeMostra = :nomeMostra AND v.anno = :anno")
    List<GiudiceResponse> getGiudice(@Param("nomeMostra") String nomeMostra, @Param("anno")LocalDate anno);
*/

    /*
    SELECT g.nome, g.cognome, avg(v.voto)
FROM voti v, giudice g
WHERE v.id_giudice=g.id_giudice
AND v.nome_mostra='ALANO GRAN PRIX' AND v.anno=2021
GROUP BY g.nome, g.cognome
     */


  /*  @Query(value = " SELECT g.nome, g.cognome, g.id_giudice, AVG(v.voto) as media " +
            "FROM voti v, giudice g\n" +
            "WHERE v.id_giudice=g.id_giudice\n" +
            "AND v.nome_mostra= :nomeMostra AND v.anno= :anno " +
            "GROUP BY g.nome, g.cognome ", nativeQuery = true)
    List<Giudice> getGiudice(@Param("nomeMostra") String nomeMostra, @Param("anno") Integer  anno);
*/





/*
    @Query(value = "SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.GiudiceResponse(" +
            "g.nome, " +
            "g,cognome, " +
            "COALESCE(AVG(v.voto),0.0) "
             +
            " )" +
            "FROM Voti v " +
            "INNER JOIN Giudice g ON g.idGiudice=v.votiId.giudice.idGiudice " +
            "INNER JOIN MostraCanina m ON ( v.votiId.mostraCanina.mostraCaninaId.nomeMostra = m.mostraCaninaId.nomeMostra AND v.votiId.mostraCanina.mostraCaninaId.anno = m.mostraCaninaId.anno) " +
            " " +
            " WHERE v.votiId.mostraCanina.mostraCaninaId.nomeMostra = :nomeMostra " +
            " AND v.votiId.mostraCanina.mostraCaninaId.anno= :anno " +
            "GROUP BY g.nome, g.cognome ")
    List<GiudiceResponse> getGiudice(@Param("nomeMostra") String nomeMostra, @Param("anno") int anno);

*/
@Query(value="SELECT new it.cgmconsulting.mostracanina_corduafra.payload.response.GiudiceResponse(" +
        "" +"g.idGiudice, g.nome, g.cognome, AVG(v.voto) AS average)" +
        " " +
        "FROM Voti v " +
        "" +"INNER JOIN Giudice g ON g.idGiudice=v.votiId.giudice.idGiudice " +
        "INNER JOIN MostraCanina m ON (m.mostraCaninaId.nomeMostra=v.votiId.mostraCanina.mostraCaninaId.nomeMostra AND m.mostraCaninaId.anno = v.votiId.mostraCanina.mostraCaninaId.anno) " +
        "WHERE m.mostraCaninaId.nomeMostra=:nomeMostra AND m.mostraCaninaId.anno=:anno " +
        "GROUP BY g.idGiudice, g.nome, g.cognome " +"ORDER BY average " )
List<GiudiceResponse> getGiudice(@Param("nomeMostra") String nomeMostra, @Param("anno") int anno);




}

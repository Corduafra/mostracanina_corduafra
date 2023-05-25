package it.cgmconsulting.mostracanina_corduafra.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class VotiId  implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_giudice",nullable = false)
    private Giudice giudice;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codice_cane",nullable = false)
    private Cane cane;

    @ManyToOne
    @JoinColumns({ // informazione aggiuntiva
            @JoinColumn(name="nome_mostra", referencedColumnName = "nomeMostra",nullable = false),
            @JoinColumn(name="anno", referencedColumnName = "anno",nullable = false,columnDefinition = "YEAR")
    })
    private MostraCanina mostraCanina;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotiId votiId = (VotiId) o;
        return Objects.equals(giudice, votiId.giudice) && Objects.equals(cane, votiId.cane) && Objects.equals(mostraCanina, votiId.mostraCanina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(giudice, cane, mostraCanina);
    }
}

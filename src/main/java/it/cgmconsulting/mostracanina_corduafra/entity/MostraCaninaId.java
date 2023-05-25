package it.cgmconsulting.mostracanina_corduafra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor
public class MostraCaninaId implements Serializable {

    @Column(nullable = false, length = 100)
    private String nomeMostra;

    @Column(nullable = false,columnDefinition = "YEAR",length = 4)
    private int anno;

    public MostraCaninaId(String nomeMostra, int anno) {
        this.nomeMostra = nomeMostra;
        this.anno = anno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MostraCaninaId that = (MostraCaninaId) o;
        return Objects.equals(nomeMostra, that.nomeMostra) && Objects.equals(anno, that.anno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMostra, anno);
    }
}

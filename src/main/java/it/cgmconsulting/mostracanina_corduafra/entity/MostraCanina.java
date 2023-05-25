package it.cgmconsulting.mostracanina_corduafra.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
public class MostraCanina {


    @EmbeddedId
    private MostraCaninaId mostraCaninaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MostraCanina that = (MostraCanina) o;
        return Objects.equals(mostraCaninaId, that.mostraCaninaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mostraCaninaId);
    }
}

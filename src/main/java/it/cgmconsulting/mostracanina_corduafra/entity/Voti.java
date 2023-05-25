package it.cgmconsulting.mostracanina_corduafra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
@Check( constraints = "voto>=0 AND voto <=10")
public class Voti {
    @EmbeddedId
    private VotiId votiId;





    @Column(precision = 1,columnDefinition = "DECIMAL (3,1)")
    private float voto;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voti voti = (Voti) o;
        return Objects.equals(votiId, voti.votiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votiId);
    }
}

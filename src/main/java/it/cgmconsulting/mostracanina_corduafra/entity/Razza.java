package it.cgmconsulting.mostracanina_corduafra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
public class Razza {

    @Id
    @Column(nullable = false)
    private byte codiceRazza;

    @Column(nullable = false,length = 100)
    private String nomeRazza;

    @Column(nullable = false,precision = 2,columnDefinition = "DECIMAL (5,2)")
    private float pesoStandard;

    @Column(nullable = false)
    private byte altezzaStandard;

    public Razza(byte codiceRazza, String nomeRazza) {
        this.codiceRazza = codiceRazza;
        this.nomeRazza = nomeRazza;
    }

    public Razza(byte codiceRazza) {
        this.codiceRazza = codiceRazza;
    }

    public Razza(String nomeRazza, float pesoStandard, byte altezzaStandard) {
        this.nomeRazza = nomeRazza;
        this.pesoStandard = pesoStandard;
        this.altezzaStandard = altezzaStandard;
    }

    public Razza(byte codiceRazza, String nomeRazza, float pesoStandard, byte altezzaStandard) {
        this.codiceRazza = codiceRazza;
        this.nomeRazza = nomeRazza;
        this.pesoStandard = pesoStandard;
        this.altezzaStandard = altezzaStandard;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Razza razza = (Razza) o;
        return codiceRazza == razza.codiceRazza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceRazza);
    }
}

package it.cgmconsulting.mostracanina_corduafra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity @Getter @Setter @NoArgsConstructor
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProprietario;

    @Column(nullable = false,length = 100)
    private String nome;

    @Column(nullable = false,length = 100)
    private String cognome;


    public Proprietario(int idProprietario, String nome, String cognome) {
        this.idProprietario = idProprietario;
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietario that = (Proprietario) o;
        return idProprietario == that.idProprietario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProprietario);
    }
}

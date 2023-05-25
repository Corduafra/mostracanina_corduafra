package it.cgmconsulting.mostracanina_corduafra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
public class Giudice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGiudice;

    @Column(length = 100,nullable = false)
    private String nome;

    @Column(length = 100,nullable = false)
    private String cognome;

    public Giudice(int idGiudice, String nome, String cognome) {
        this.idGiudice = idGiudice;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Giudice(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giudice giudice = (Giudice) o;
        return idGiudice == giudice.idGiudice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGiudice);
    }
}

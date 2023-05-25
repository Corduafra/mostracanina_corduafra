package it.cgmconsulting.mostracanina_corduafra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
public class Cane {

    @Id
    @Column(length = 10)
    private String codiceCane;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date dataNascita;

    @Column(nullable = false)
    private byte altezza;

    @Column(nullable = false,precision = 2,columnDefinition = "DECIMAL (5,2)")
    private float peso;

    @OneToOne
    @JoinColumn(name = "id_proprietario",nullable = false)
    private Proprietario proprietario;

    @OneToOne
    @JoinColumn(name = "codice_razza",nullable = false)
    private Razza razza;

    public Cane(String codiceCane, String nome, Date dataNascita) {
        this.codiceCane = codiceCane;
        this.nome = nome;
        this.dataNascita = dataNascita;
    }

    public Cane(String nome, Date dataNascita, byte altezza, float peso) {
        this.nome = nome;
        this.dataNascita = dataNascita;
        this.altezza = altezza;
        this.peso = peso;
    }

    public Cane(String codiceCane, String nome, Date dataNascita, byte altezza, float peso, Proprietario proprietario, Razza razza) {
        this.codiceCane = codiceCane;
        this.nome = nome;
        this.dataNascita = dataNascita;
        this.altezza = altezza;
        this.peso = peso;
        this.proprietario = proprietario;
        this.razza = razza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cane cane = (Cane) o;
        return Objects.equals(codiceCane, cane.codiceCane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceCane);
    }
}

package it.cgmconsulting.mostracanina_corduafra.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CaneResponse {

    private String codiceCane;
    private String nome;
    private Date dataNascita;
    private float peso;
    private double average;

    public CaneResponse(String codiceCane, String nome, Date dataNascita) {
        this.codiceCane = codiceCane;
        this.nome = nome;
        this.dataNascita = dataNascita;
    }

    public CaneResponse(String codiceCane, String nome, double average) {
        this.codiceCane = codiceCane;
        this.nome = nome;
        this.average = average;
    }
}

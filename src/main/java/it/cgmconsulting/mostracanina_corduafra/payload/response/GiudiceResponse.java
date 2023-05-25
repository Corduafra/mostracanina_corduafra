package it.cgmconsulting.mostracanina_corduafra.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GiudiceResponse {

    private int idGiudice;
    private String nome;
    private String cognome;
    private double average;
}




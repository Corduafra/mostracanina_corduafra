package it.cgmconsulting.mostracanina_corduafra.payload.response;

import it.cgmconsulting.mostracanina_corduafra.entity.Cane;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProprietarioResponse {

    private int idProprietario;
    private String nome;
    private String cognome;
    private Cane nomeCane;

    public ProprietarioResponse(int idProprietario, String nome, String cognome) {
        this.idProprietario = idProprietario;
        this.nome = nome;
        this.cognome = cognome;
    }
}

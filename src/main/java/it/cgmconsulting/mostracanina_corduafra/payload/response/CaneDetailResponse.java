package it.cgmconsulting.mostracanina_corduafra.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CaneDetailResponse {


    private byte altezza;
    private float peso;
    private float discostamento;


    public CaneDetailResponse(float discostamento) {
        this.discostamento = discostamento;
    }
}

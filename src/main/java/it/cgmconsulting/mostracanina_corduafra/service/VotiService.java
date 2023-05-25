package it.cgmconsulting.mostracanina_corduafra.service;

import it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse;
import it.cgmconsulting.mostracanina_corduafra.repository.VotiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VotiService {

    @Autowired
    VotiRepository votiRepository;

    public List<CaneResponse> getVincitore(String nomeMostra, int anno){
        return votiRepository.getVincitore(nomeMostra,anno);
    }

    public float getDiscostamento(String codiceCane){
        return votiRepository.getDiscostamento(codiceCane);
    }








}

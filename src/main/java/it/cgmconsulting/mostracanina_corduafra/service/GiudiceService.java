package it.cgmconsulting.mostracanina_corduafra.service;

import it.cgmconsulting.mostracanina_corduafra.entity.Giudice;
import it.cgmconsulting.mostracanina_corduafra.payload.response.GiudiceResponse;
import it.cgmconsulting.mostracanina_corduafra.repository.GiudiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GiudiceService {

    @Autowired
    GiudiceRepository giudiceRepository;




    public List<GiudiceResponse> getGiudice(String nomeMostra, int anno){
        return giudiceRepository.getGiudice(nomeMostra,anno);


    }
}

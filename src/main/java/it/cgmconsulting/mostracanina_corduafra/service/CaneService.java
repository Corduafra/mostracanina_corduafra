package it.cgmconsulting.mostracanina_corduafra.service;

import it.cgmconsulting.mostracanina_corduafra.entity.Cane;
import it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse;
import it.cgmconsulting.mostracanina_corduafra.payload.response.ProprietarioResponse;
import it.cgmconsulting.mostracanina_corduafra.repository.CaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaneService {

    @Autowired
    CaneRepository caneRepository;

    public List<CaneResponse> getCaneVecchio(){
        return caneRepository.getCaneVecchio();
    }


    public List<CaneResponse> getCane(){
        return caneRepository.getCane();
    }

    public boolean existsByCodiceCane(String codiceCane){
        return caneRepository.existsByCodiceCane(codiceCane);
    }


    public List<ProprietarioResponse> getProprietario(String codiceCane){
        return caneRepository.getProrpietario(codiceCane);
    }
}

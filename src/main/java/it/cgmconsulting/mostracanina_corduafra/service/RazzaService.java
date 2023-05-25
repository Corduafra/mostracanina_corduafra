package it.cgmconsulting.mostracanina_corduafra.service;

import it.cgmconsulting.mostracanina_corduafra.entity.Razza;
import it.cgmconsulting.mostracanina_corduafra.repository.VotiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RazzaService {

    @Autowired
    VotiRepository votiRepository;

     public List<Byte> getRazza(){
         return votiRepository.getRazza();

     }





     }

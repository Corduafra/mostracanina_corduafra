package it.cgmconsulting.mostracanina_corduafra.controller;


import it.cgmconsulting.mostracanina_corduafra.entity.Cane;
import it.cgmconsulting.mostracanina_corduafra.entity.Proprietario;
import it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse;
import it.cgmconsulting.mostracanina_corduafra.payload.response.ProprietarioResponse;
import it.cgmconsulting.mostracanina_corduafra.service.CaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("cane")

public class CaneController {

    @Autowired
    CaneService caneService;


    @GetMapping("/cane") //ok
    public ResponseEntity<?> getCani(){
        List<CaneResponse> responses= caneService.getCane();

        if(responses.isEmpty())
            return new ResponseEntity<>("non ci sono cani registrati", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(responses,HttpStatus.OK);
    }

    @GetMapping("/{codiceCane}")  //ok
    public ResponseEntity<?> getPadrone(@PathVariable String codiceCane){

        if(!caneService.existsByCodiceCane(codiceCane))
            return new ResponseEntity<>("cane inesisteste",HttpStatus.NOT_FOUND);

        List<ProprietarioResponse> proprietario = caneService.getProprietario(codiceCane);



        return new ResponseEntity<>(proprietario,HttpStatus.OK);
    }

    @GetMapping("/vecchio") // ok
    public ResponseEntity<?> getCaneVecchio(){

        List<CaneResponse> responses= caneService.getCaneVecchio();

        return new ResponseEntity<>(responses,HttpStatus.OK);

    }








}

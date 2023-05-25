package it.cgmconsulting.mostracanina_corduafra.controller;

import it.cgmconsulting.mostracanina_corduafra.entity.Razza;
import it.cgmconsulting.mostracanina_corduafra.service.RazzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("razza")
public class RazzaController {

    @Autowired
    RazzaService razzaService;


    @GetMapping("/razza_non_partecipe") //ok
    public ResponseEntity<?> getRazzaNonInclusa(){
        List<Byte> razza= razzaService.getRazza();

        if(razza.isEmpty())
            return new ResponseEntity<>("partecipano tutte le razze", HttpStatus.OK);

        return new ResponseEntity<>(razza,HttpStatus.OK);

    }
}

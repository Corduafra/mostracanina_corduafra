package it.cgmconsulting.mostracanina_corduafra.controller;

import it.cgmconsulting.mostracanina_corduafra.entity.Giudice;
import it.cgmconsulting.mostracanina_corduafra.payload.response.GiudiceResponse;
import it.cgmconsulting.mostracanina_corduafra.service.GiudiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("giudice")
public class GiudiceController {
    @Autowired
    GiudiceService giudiceService;



    @GetMapping("/{nomeConcorso}/{anno}")
    public ResponseEntity<?> getGuidici(@PathVariable @NotBlank String nomeConcorso, @PathVariable int anno) {
        List<GiudiceResponse> responses = giudiceService.getGiudice(nomeConcorso, anno);
        int size = responses.size();


        if (responses.isEmpty())
            return new ResponseEntity<>("non ci sono giudici", HttpStatus.NOT_FOUND);




        GiudiceResponse giudiceResponse=responses.get(0);
        double media= giudiceResponse.getAverage();
        int j=0,f=0;
        for (int i = 0; i <size ; i++) {
            GiudiceResponse giudiceResponsei=responses.get(i);
            if(media>giudiceResponsei.getAverage()){
                media= giudiceResponsei.getAverage();
                j=i;
            }
            else if(media==giudiceResponsei.getAverage()){
                f++;

            }

        }
        List<GiudiceResponse> responses1=new ArrayList<>() ;
        for (int i = 0; i <f ; i++) {
                 responses1.add(i,responses.get(i));

        }


        return new ResponseEntity(responses1,HttpStatus.OK);


    }












    }





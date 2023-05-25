package it.cgmconsulting.mostracanina_corduafra.controller;

import it.cgmconsulting.mostracanina_corduafra.entity.Cane;
import it.cgmconsulting.mostracanina_corduafra.payload.response.CaneResponse;
import it.cgmconsulting.mostracanina_corduafra.repository.CaneRepository;
import it.cgmconsulting.mostracanina_corduafra.service.VotiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("voti")
public class VotiController {

    @Autowired
    VotiService votiService;
    @Autowired
    CaneRepository caneRepository;


    @GetMapping("/vincitore/{mostraCane}/{anno}")
    public ResponseEntity<?> getVincitore(@PathVariable String nomeMostra, int anno) {

        List<CaneResponse> responses = votiService.getVincitore(nomeMostra, anno);


        double media = responses.get(0).getAverage();
        int f = 0;
        for (int i = 1; i < responses.size(); i++) {
            CaneResponse caneResponse = responses.get(i);
            if (media == caneResponse.getAverage())
                f++;
            else
                break;
        }

        if (f == 0) {

            return new ResponseEntity<>(responses.get(0) + "is the winner ", HttpStatus.OK);
        } else {
            List<CaneResponse> caneResponses = new ArrayList<>();
            for (int i = 0; i < f; i++) {
                caneResponses.add(i, responses.get(i));
            }


            System.out.println("calcolo discostamento: ");

            Optional<Cane> cane = caneRepository.findById(caneResponses.get(0).getCodiceCane());

            float discostamento = votiService.getDiscostamento(cane.get().getCodiceCane());
            float decimal = 0;

            for (int i = 1; i <= f; i++) {
                Optional<Cane> cane1 = caneRepository.findById(caneResponses.get(i).getCodiceCane());
                decimal = votiService.getDiscostamento(cane1.get().getCodiceCane());
                if (discostamento < decimal) {
                    return new ResponseEntity<>("the winner is" + caneResponses.get(i - 1), HttpStatus.OK);
                }


                else {
                    discostamento = decimal;


                }
            }
            // return new ResponseEntity<>("the winner is ",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

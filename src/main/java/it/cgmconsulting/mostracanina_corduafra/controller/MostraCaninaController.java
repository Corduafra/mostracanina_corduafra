package it.cgmconsulting.mostracanina_corduafra.controller;

import it.cgmconsulting.mostracanina_corduafra.service.CaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mostra_canina")
public class MostraCaninaController {

    @Autowired
    CaneService caneService;






}

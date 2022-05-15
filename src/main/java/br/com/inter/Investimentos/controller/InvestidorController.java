package br.com.inter.Investimentos.controller;

import br.com.inter.Investimentos.service.InvestidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/investidor")
public class InvestidorController {

    @Autowired
    private InvestidorService service;
}

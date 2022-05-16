package br.com.inter.Investimentos.controller;

import br.com.inter.Investimentos.model.CompraModel;
import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.service.CompraService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/compra")
public class CompraController {

    @Autowired
    private CompraService service;

    @ApiOperation(value = "Realiza uma nova compra")
    @PostMapping("/insert")
    public ResponseEntity<CompraModel> insert(@RequestBody CompraModel obj){
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
}

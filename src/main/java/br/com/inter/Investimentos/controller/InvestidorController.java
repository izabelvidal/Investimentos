package br.com.inter.Investimentos.controller;

import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.model.InvestidorModel;
import br.com.inter.Investimentos.service.InvestidorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/investidor")
public class InvestidorController {

    @Autowired
    private InvestidorService service;

    @ApiOperation(value = "Cria um novo usuario na base de dados")
    @PostMapping("/insert")
    public ResponseEntity<InvestidorModel> insert(@RequestBody InvestidorModel obj){
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Delete o usuario do id da base de dados")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Retorna todos os usuarios cadastrados")
    @GetMapping("/list")
    public ResponseEntity<List<InvestidorModel>> findAll(){
        List<InvestidorModel> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
}

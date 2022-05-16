package br.com.inter.Investimentos.controller;

import br.com.inter.Investimentos.model.CompraModel;
import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.service.CompraService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "Retorna todas compras realizadas")
    @GetMapping("/list/all")
    public ResponseEntity<List<CompraModel>> findAll(){
        List<CompraModel> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation("Retorna compra do id informado")
    @GetMapping("/list/{id}")
    public ResponseEntity<CompraModel> findById(@PathVariable Integer id){
        CompraModel obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}

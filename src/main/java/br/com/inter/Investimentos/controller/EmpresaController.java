package br.com.inter.Investimentos.controller;

import br.com.inter.Investimentos.model.domain.EmpresaModel;
import br.com.inter.Investimentos.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @PostMapping("/insert")
    public ResponseEntity<EmpresaModel> insert(@RequestBody EmpresaModel obj){
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/price/{id}")
    public ResponseEntity<Void> updatePreco(@PathVariable Integer id, @RequestParam Double preco){
        service.updatePreco(id, preco);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/status/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Integer id, @RequestParam String status){
        service.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<EmpresaModel>> findAll(){
        List<EmpresaModel> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/list/status")
    public ResponseEntity<Optional<List<EmpresaModel>>> findByStatus(@RequestParam String status){
        Optional<List<EmpresaModel>> obj = service.findByStatus(status);
        return ResponseEntity.ok().body(obj);
    }
}

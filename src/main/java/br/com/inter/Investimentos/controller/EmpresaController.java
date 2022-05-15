package br.com.inter.Investimentos.controller;

import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.service.EmpresaService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Cria uma nova empresa na base de dados")
    @PostMapping("/insert")
    public ResponseEntity<EmpresaModel> insert(@RequestBody EmpresaModel obj){
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Delete a empresa do id da base de dados")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza o preco da empresa do id passado por parametro")
    @PutMapping("/update/price/{id}")
    public ResponseEntity<Void> updatePreco(@PathVariable Integer id, @RequestParam Double preco){
        service.updatePreco(id, preco);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Atualiza o status da empresa do id passado por parametro")
    @PutMapping("/update/status/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Integer id, @RequestParam String status){
        service.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Retorna todas empresas cadastradas")
    @GetMapping("/list/all")
    public ResponseEntity<List<EmpresaModel>> findAll(){
        List<EmpresaModel> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value = "Retorna uma lista de empresas de acordo com o status passado por parametro")
    @GetMapping("/list/status")
    public ResponseEntity<Optional<List<EmpresaModel>>> findByStatus(@RequestParam String status){
        Optional<List<EmpresaModel>> obj = service.findByStatus(status);
        return ResponseEntity.ok().body(obj);
    }
}

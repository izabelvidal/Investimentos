package br.com.inter.Investimentos.service;

import br.com.inter.Investimentos.model.domain.EmpresaModel;
import br.com.inter.Investimentos.repository.EmpresaRepository;
import br.com.inter.Investimentos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    public EmpresaModel insert(EmpresaModel obj) {
        obj = repository.save(obj);
        return obj;
    }

    public void delete(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }else {
            throw new ObjectNotFoundException("Pessoa não localizada para deletar");
        }
    }

    public List<EmpresaModel> findByStatus(String status){
        return repository.findByStatus(status);
    }

    public List<EmpresaModel> findAll(){
        return repository.findAll();
    }

    public EmpresaModel findById(Integer id){
        Optional<EmpresaModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + EmpresaModel.class.getName()));
    }

    public EmpresaModel findByAcao(String acao){
        Optional<EmpresaModel> obj = repository.findByAcao(acao);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Ação: " + acao + ", Tipo: " + EmpresaModel.class.getName()));
    }

    public EmpresaModel updateStatus(Integer id, String status){
        EmpresaModel obj = findById(id);
        obj.setStatus(status);
        return repository.save(obj);
    }

    public EmpresaModel updatePreco(String acao, Double preco){
        EmpresaModel obj = findByAcao(acao);
        obj.setPreco(preco);
        return repository.save(obj);
    }

}

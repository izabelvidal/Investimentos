package br.com.inter.Investimentos.service;

import br.com.inter.Investimentos.model.EmpresaModel;
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
        obj.setStatus("ATIVA");
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

    public Optional<List<EmpresaModel>> findByStatus(String status){
        return repository.findbyStatus(status);
    }

    public List<EmpresaModel> findAll(){
        return repository.findAll();
    }

    public EmpresaModel findById(Integer id){
        Optional<EmpresaModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + EmpresaModel.class.getName()));
    }

    public EmpresaModel findByAcao(String ticket){
        Optional<EmpresaModel> obj = repository.findByTicket(ticket);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Ação: " + ticket + ", Tipo: " + EmpresaModel.class.getName()));
    }

    public EmpresaModel updateStatus(Integer id, String status){
        EmpresaModel obj = findById(id);
        obj.setStatus(status);
        return repository.save(obj);
    }

    public EmpresaModel updatePreco(Integer id, Double preco){
        EmpresaModel obj = findById(id);
        obj.setPreco(preco);
        return repository.save(obj);
    }

}

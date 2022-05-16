package br.com.inter.Investimentos.service;

import br.com.inter.Investimentos.model.InvestidorModel;
import br.com.inter.Investimentos.repository.InvestidorRepository;
import br.com.inter.Investimentos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestidorService {

    @Autowired
    private InvestidorRepository repository;

    public List<InvestidorModel> findAll() {
        return repository.findAll();
    }

    public InvestidorModel findByCpf(String cpf){
        Optional<InvestidorModel > obj = repository.findbyCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! CPF: " + cpf + ", Tipo: " + InvestidorModel.class.getName()));
    }

    public InvestidorModel insert(InvestidorModel obj) {
        obj = repository.save(obj);
        return obj;
    }

    public InvestidorModel find(Integer id) {
        Optional<InvestidorModel > obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + InvestidorModel.class.getName()));
    }

    public void delete(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }else {
            throw new ObjectNotFoundException("Pessoa não localizada para deletar");
        }
    }
}

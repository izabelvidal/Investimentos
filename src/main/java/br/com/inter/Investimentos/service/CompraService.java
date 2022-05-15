package br.com.inter.Investimentos.service;

import br.com.inter.Investimentos.model.CompraModel;
import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.model.InvestidorModel;
import br.com.inter.Investimentos.repository.CompraRepository;
import br.com.inter.Investimentos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    @Autowired
    private InvestidorService investidorService;

    @Autowired
    private EmpresaService empresaService;

    public List<CompraModel> findAll() {
        return repository.findAll();
    }

    public CompraModel find(Integer id) {
        Optional<CompraModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + InvestidorModel.class.getName()));
    }

    public CompraModel insert(CompraModel obj){
        realizaCompra(obj);
        return repository.save(obj);
    }

    private void realizaCompra(CompraModel compra){
        List<EmpresaModel>  empresas = empresaService.findAll();
        EmpresaModel empresa = selecionaEmpresa(empresas);
        contagemVendas(empresa);
    }

    private EmpresaModel selecionaEmpresa(List<EmpresaModel> empresas){
        Random rand = new Random();
        int randomIndex = rand.nextInt(empresas.size());
        EmpresaModel randomElement = empresas.get(randomIndex);
        return randomElement;
    }

    private EmpresaModel contagemVendas(EmpresaModel empresa){
        Integer acoesVendidas = empresa.getAcoesVendidas();
        acoesVendidas += 1;
        empresa.setAcoesVendidas(acoesVendidas);
        return empresa;
    }
}

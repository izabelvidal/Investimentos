package br.com.inter.Investimentos.service;

import br.com.inter.Investimentos.model.CompraModel;
import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.model.InvestidorModel;
import br.com.inter.Investimentos.repository.CompraRepository;
import br.com.inter.Investimentos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
                "Objeto não encontrado! Id: " + id + ", Tipo: " +CompraModel.class.getName()));
    }

    public CompraModel insert(CompraModel obj){
        InvestidorModel investidor = investidorService.findByCpf(obj.getInvestidor().getCpf());
        obj.setInvestidor(investidor);
        CompraModel compra = realizaCompra(obj);
        return repository.save(compra);
    }

    private CompraModel realizaCompra(CompraModel compra){
        List<EmpresaModel>  empresas = empresaService.findAll();
        EmpresaModel empresa = selecionaEmpresa(empresas);
        contagemVendas(empresa);
        compra.setTroco(troco(compra.getInvestimento(), empresa));

        return compra;
    }

    private EmpresaModel selecionaEmpresa(List<EmpresaModel> empresas){
        Random rand = new Random();
        Integer randomIndex = rand.nextInt(empresas.size());
        EmpresaModel randomElement = empresaService.findById(randomIndex);
        return randomElement;
    }

    private EmpresaModel contagemVendas(EmpresaModel empresa){
        Integer acoesVendidas = empresa.getAcoesVendidas();
        acoesVendidas += 1;
        empresaService.updateAcoesVendida(empresa.getId(), acoesVendidas);
        return empresa;
    }

    private Double troco(Double investimento, EmpresaModel empresa){
        Double troco = investimento % empresa.getPreco();
        if (troco == 0){
            return null;
        }
        return troco;
    }
}

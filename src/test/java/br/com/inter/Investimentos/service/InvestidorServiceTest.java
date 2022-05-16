package br.com.inter.Investimentos.service;

import br.com.inter.Investimentos.model.InvestidorModel;
import br.com.inter.Investimentos.repository.InvestidorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvestidorServiceTest {

    @InjectMocks
    private InvestidorService service;

    @Mock
    private InvestidorRepository repository;

    @Test
    void dadoInvestidorValido_deveInserirInvestidorNaBaseDeDados(){
        InvestidorModel mock = investidorMock();
        when(repository.save(any(InvestidorModel.class))).thenReturn(mock);

        InvestidorModel model = service.insert(mock);

        assertNotNull(model);
        assertEquals(model.getCpf(), mock.getCpf());

    }

    private InvestidorModel investidorMock(){
        InvestidorModel model = new InvestidorModel();
        model.setCpf("01234567890");
        return model;
    }

}
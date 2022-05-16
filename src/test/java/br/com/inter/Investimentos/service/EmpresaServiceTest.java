package br.com.inter.Investimentos.service;

import br.com.inter.Investimentos.model.EmpresaModel;
import br.com.inter.Investimentos.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {

    @InjectMocks
    private EmpresaService service;

    @Mock
    private EmpresaRepository repository;

    @Test
    void dadosIdValido_deveRetornarEmpresaModel() throws Exception{
        Optional<EmpresaModel> mock = empresaMock();
        when(repository.findById(1)).thenReturn(mock);

        EmpresaModel model = service.findById(1);

        assertNotNull(model);
        assertEquals(model.getAcao(), mock.get().getAcao());
        assertEquals(model.getTicket(), mock.get().getTicket());
        assertEquals(model.getStatus(), mock.get().getStatus());
    }

    private Optional<EmpresaModel> empresaMock() {
        EmpresaModel model = new EmpresaModel();
        model.setAcao("Inter");
        model.setTicket("BIDI11");
        model.setStatus("ATIVA");
        return Optional.of(model);
    }
}
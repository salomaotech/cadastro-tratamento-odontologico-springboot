package br.com.salomaotech.cadastro.model.cliente;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CadastroModelTest {

    @Test
    public void testGetId() {

        CadastroModel cadastroModel = new CadastroModel();
        assertEquals(true, cadastroModel.getId() == 0L);

    }

    @Test
    public void testSetId() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setId(1);
        assertEquals(true, cadastroModel.getId() == 1L);

    }

    @Test
    public void testGetDataInicio() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDataInicio(LocalDate.now());
        assertEquals(true, LocalDate.now().equals(cadastroModel.getDataInicio()));

    }

    @Test
    public void testSetDataInicio() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDataInicio(LocalDate.now());
        assertEquals(true, LocalDate.now().equals(cadastroModel.getDataInicio()));

    }

    @Test
    public void testGetSituacao() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setSituacao("Concluido");
        assertEquals(true, cadastroModel.getSituacao().equals("Concluido"));

    }

    @Test
    public void testSetSituacao() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setSituacao("Concluido");
        assertEquals(true, cadastroModel.getSituacao().equals("Concluido"));

    }

    @Test
    public void testGetDentes() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDentes("27");
        assertEquals(true, cadastroModel.getDentes().equals("27"));

    }

    @Test
    public void testSetDentes() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setDentes("27");
        assertEquals(true, cadastroModel.getDentes().equals("27"));

    }

    @Test
    public void testGetProcedimento() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setProcedimento("Limpeza");
        assertEquals(true, cadastroModel.getProcedimento().equals("Limpeza"));

    }

    @Test
    public void testSetProcedimento() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setProcedimento("Limpeza");
        assertEquals(true, cadastroModel.getProcedimento().equals("Limpeza"));

    }

    @Test
    public void testGetAnotacoes() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setAnotacoes("Paciente reclamou de dor");
        assertEquals(true, cadastroModel.getAnotacoes().equals("Paciente reclamou de dor"));

    }

    @Test
    public void testSetAnotacoes() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setAnotacoes("Paciente reclamou de dor");
        assertEquals(true, cadastroModel.getAnotacoes().equals("Paciente reclamou de dor"));

    }

    @Test
    public void testGetValor() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setValor("100");
        assertEquals(true, cadastroModel.getValor().equals("100"));

    }

    @Test
    public void testSetValor() {

        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setValor("100");
        assertEquals(true, cadastroModel.getValor().equals("100"));

    }

}

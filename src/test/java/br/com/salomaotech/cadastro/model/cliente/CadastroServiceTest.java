package br.com.salomaotech.cadastro.model.cliente;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CadastroServiceTest {

    @Autowired
    CadastroRepository cadastroRepository;

    /**
     * Testa o método adicionar da classe CadastroService
     */
    @Test
    public void testAdicionar() {

        /* cadastro model */
        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setProcedimento("Teste");

        /* serviço de cadastro */
        CadastroService cadastroService = new CadastroService(cadastroRepository);

        /* testa se conseguiu adicionar */
        assertEquals(true, cadastroService.adicionar(cadastroModel));

    }

    @Test
    public void testAtualizar() {

        /* cadastro model */
        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setProcedimento("Teste");

        /* serviço de cadastro */
        CadastroService cadastroService = new CadastroService(cadastroRepository);

        /* adiciona */
        cadastroService.adicionar(cadastroModel);

        /* pega o id */
        long id = cadastroService.getId();

        /* agora verifica se consegue atualizar com o id de cadastro */
        assertEquals(true, cadastroService.atualizar(id, cadastroModel));

    }

    @Test
    public void testDeletar() {

        /* cadastro model */
        CadastroModel cadastroModel = new CadastroModel();
        cadastroModel.setProcedimento("Teste");

        /* serviço de cadastro */
        CadastroService cadastroService = new CadastroService(cadastroRepository);

        /* adiciona */
        cadastroService.adicionar(cadastroModel);

        /* pega o id */
        long id = cadastroService.getId();

        /* agora verifica se consegue deletar com o id de cadastro */
        assertEquals(true, cadastroService.deletar(id));

    }

}

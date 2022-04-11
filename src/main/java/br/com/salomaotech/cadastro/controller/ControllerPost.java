package br.com.salomaotech.cadastro.controller;

import br.com.salomaotech.cadastro.model.cliente.CadastroModel;
import static java.util.Objects.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import br.com.salomaotech.cadastro.model.cliente.CadastroRepository;
import br.com.salomaotech.cadastro.model.cliente.CadastroService;
import br.com.salomaotech.cadastro.model.sistema.FormataNumero;

/**
 * Lida com os endpoints de Post
 *
 * @author @salomaotech
 */
@Controller
public class ControllerPost {

    @Autowired
    CadastroRepository cadastroRepository;

    /* mapeia a rota para adicionar um registro */
    @PostMapping("/adicionar")
    public String postAdiciona(CadastroModel cadastroModel) {

        /* serviço */
        CadastroService cadastroService = new CadastroService(cadastroRepository);

        /* formata o valor corretamente com as casas decimais */
        cadastroModel.setValor(FormataNumero.formatarNumero(cadastroModel.getValor()).toString());

        /* valida se conseguiu adicionar */
        if (cadastroService.adicionar(cadastroModel)) {

            /* exibe os dados cadastrados */
            return "redirect:/pagina_cadastro/" + cadastroService.getId();

        } else {

            /* exibe página de erro */
            return "redirect:/pagina_erro404/";
        }

    }

    /* mapeia a rota para atualizar um registro */
    @PostMapping("/adicionar/{id}")
    public String postAtualiza(@PathVariable("id") long id, CadastroModel cadastroModel) {

        /* serviço */
        CadastroService cadastroService = new CadastroService(cadastroRepository);

        /* formata o valor corretamente com as casas decimais */
        cadastroModel.setValor(FormataNumero.formatarNumero(cadastroModel.getValor()).toString());

        /* valida se conseguiu atualizar */
        if (cadastroService.atualizar(id, cadastroModel)) {

            /* exibe os dados cadastrados */
            return "redirect:/pagina_cadastro/" + id;

        } else {

            /* exibe página de erro */
            return "redirect:/pagina_erro404/";

        }

    }

    /* mapeia a rota para deletar um registro */
    @PostMapping("/deletar/{id}")
    public String postDeleta(@PathVariable("id") long id, WebRequest request) {

        /* serviço */
        CadastroService cadastroService = new CadastroService(cadastroRepository);

        /* valida se confirmou que deseja excluir */
        if (!isNull(request.getParameter("confirma_deletar"))) {

            /* valida se conseguiu deletar */
            if (cadastroService.deletar(id)) {

                /* chama a página de resultados */
                return "redirect:/pagina_resultados";

            } else {

                /* exibe página de erro */
                return "redirect:/pagina_erro404/";

            }

        } else {

            /* exibe a página de deletar */
            return "redirect:/pagina_deleta/" + id;

        }

    }

}

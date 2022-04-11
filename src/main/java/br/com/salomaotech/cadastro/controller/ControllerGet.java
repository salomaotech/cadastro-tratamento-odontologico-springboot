package br.com.salomaotech.cadastro.controller;

import br.com.salomaotech.cadastro.model.cliente.CadastroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import br.com.salomaotech.cadastro.model.cliente.CadastroRepository;
import br.com.salomaotech.cadastro.model.sistema.ValidaStringIsEmpty;
import br.com.salomaotech.cadastro.model.sistema.FormataNumero;
import br.com.salomaotech.cadastro.model.sistema.Paginador;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.isNull;
import org.springframework.web.context.request.WebRequest;

/**
 * Lida com os endpoints do Get
 *
 * @author @salomaotech
 */
@Controller
public class ControllerGet {

    @Autowired
    CadastroRepository cadastroRepository;

    /* mapeia a rota para a página PaginaErro404 */
    @GetMapping("/pagina_erro404")
    public ModelAndView getErro404() {

        /* retorna a página */
        return new ModelAndView("PaginaErro404");

    }

    /* mapeia a rota para a página PaginaCadastro */
    @GetMapping("/pagina_cadastro")
    public ModelAndView getCadastra() {

        /* nova ModelAndView */
        ModelAndView model = new ModelAndView("PaginaCadastro");

        /* popula com os dados vazios */
        model.addObject("cadastro", new CadastroModel());

        /* retorna a página */
        return model;

    }

    /* mapeia a rota para a página PaginaCadastro */
    @GetMapping("/pagina_cadastro/{id}")
    public ModelAndView getAtualiza(@PathVariable("id") long id) {

        /* valida se o cadastro associado ao ID existe no banco de dados */
        if (this.cadastroRepository.findById(id).isPresent()) {

            /* nova ModelAndView */
            ModelAndView model = new ModelAndView("PaginaCadastro");

            /* cadastro model */
            CadastroModel cadastro = cadastroRepository.getById(id);

            /* popula com os dados encontrados no banco de dados */
            model.addObject("cadastro", cadastro);

            /* retorna a página com os dados já populados */
            return model;

        } else {

            /* retorna a página de erro */
            return new ModelAndView("PaginaErro404");

        }

    }

    /* mapeia a rota para a página PaginaDeleta */
    @GetMapping("/pagina_deleta/{id}")
    public ModelAndView getDeleta(@PathVariable("id") long id) {

        /* valida se o cadastro associado ao ID existe no banco de dados */
        if (this.cadastroRepository.findById(id).isPresent()) {

            /* nova ModelAndView */
            ModelAndView model = new ModelAndView("PaginaDeleta");

            /* popula com os dados encontrados no banco de dados */
            model.addObject("cadastro", cadastroRepository.getById(id));

            /* retorna a página com os dados já populados */
            return model;

        } else {

            /* retorna a página de erro */
            return new ModelAndView("PaginaErro404");

        }

    }

    /* mapeia a rota para pesquisa avançada */
    @GetMapping("/pagina_busca_avancada")
    public ModelAndView getPesquisaAvancada() {

        /* nova ModelAndView */
        ModelAndView model = new ModelAndView("PaginaBuscaAvancada");

        /* retorna a página com os dados já populados */
        return model;

    }

    /* mapeia a rota para a página PaginaResultados */
    @GetMapping({"/", "/pagina_resultados"})
    public ModelAndView getResultados(WebRequest request) {

        /* nova ModelAndView */
        ModelAndView model = new ModelAndView("PaginaResultados");

        /* tipo de pesquisa */
        int tipoPesquisa = 0;

        /* paginador */
        Paginador paginador = new Paginador();

        /* resultados */
        List resultados = new ArrayList();

        /* valores monetários */
        BigDecimal valor = new BigDecimal("0");

        /* filtros de busca */
        String dataInicio = request.getParameter("dataInicio");
        String dataConclusao = request.getParameter("dataConclusao");
        String situacao = request.getParameter("situacao");

        /* está usando os filtros */
        if (!request.getParameterMap().isEmpty()) {

            /* filtra por: situacao */
            if (ValidaStringIsEmpty.isEmpty(dataInicio) & !ValidaStringIsEmpty.isEmpty(situacao)) {

                tipoPesquisa = 1;

            }

            /* filtra por: inicio, situacao */
            if (!ValidaStringIsEmpty.isEmpty(dataInicio) & !ValidaStringIsEmpty.isEmpty(situacao)) {

                tipoPesquisa = 2;

            }

            /* filta por: inicio, conclusao, situacao */
            if (!ValidaStringIsEmpty.isEmpty(dataInicio) & !ValidaStringIsEmpty.isEmpty(dataConclusao) & !ValidaStringIsEmpty.isEmpty(situacao)) {

                tipoPesquisa = 3;

            }

        }

        /* valida o tipo de pesquisa */
        switch (tipoPesquisa) {

            case 0:
                /* não usa filtros */
                paginador = new Paginador(50, request.getParameter("pagina"), this.cadastroRepository.count());
                resultados = cadastroRepository.findAllList(paginador.getPaginadorOrdenadoAsc("data_inicio"));
                valor = cadastroRepository.findAllSaldo();
                break;

            case 1:
                /* filtra por: situacao */
                paginador = new Paginador(50, request.getParameter("pagina"), this.cadastroRepository.findByHistoricoCount(situacao));
                resultados = cadastroRepository.findAllList(situacao, paginador.getPaginadorOrdenadoAsc("data_inicio"));
                valor = cadastroRepository.findAllSaldo(situacao);
                break;

            case 2:
                /* filtra por: inicio, situacao */
                paginador = new Paginador(50, request.getParameter("pagina"), this.cadastroRepository.findByHistoricoCount(dataInicio, situacao));
                resultados = cadastroRepository.findByHistorico(dataInicio, situacao, paginador.getPaginadorOrdenadoAsc("data_inicio"));
                valor = cadastroRepository.findByHistoricoSaldo(dataInicio, situacao);
                break;

            case 3:
                /* filta por: inicio, conclusao, situacao */
                paginador = new Paginador(50, request.getParameter("pagina"), this.cadastroRepository.findByHistoricoCount(dataInicio, dataConclusao, situacao));
                resultados = cadastroRepository.findByHistorico(dataInicio, dataConclusao, situacao, paginador.getPaginadorOrdenadoAsc("data_inicio"));
                valor = cadastroRepository.findByHistoricoSaldo(dataInicio, dataConclusao, situacao);
                break;
            default:

        }

        /* popula com os dados encontrados no banco de dados */
        model.addObject("cadastros", resultados);

        /* itera os resultados para formatar os dados antes de exibir na model */
        for (Iterator it = resultados.iterator(); it.hasNext();) {

            /* cast */
            CadastroModel cadastro = (CadastroModel) it.next();

            /* formata o valor para moeda brasileira R$ */
            cadastro.setValor(FormataNumero.formatarNumeroParaBr(cadastro.getValor()));

        }

        /* valida entradas */
        if (isNull(valor)) {

            /* valor padrão */
            valor = new BigDecimal("0");

        }

        /* popula com os dados encontrados no banco de dados */
        model.addObject("numero_paginas", paginador.getArrayListNumeroPaginas());
        model.addObject("pagina", request.getParameter("pagina"));
        model.addObject("query", request.getParameter("query"));
        model.addObject("saldo", FormataNumero.formatarNumeroParaBr(valor.toString()));

        /* retorna a página com os dados já populados */
        return model;

    }

}

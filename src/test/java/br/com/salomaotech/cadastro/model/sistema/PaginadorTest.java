package br.com.salomaotech.cadastro.model.sistema;

import static java.util.Objects.isNull;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaginadorTest {

    @Test
    public void testGetPaginador() {

        /* propriedades */
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";
        long numeroRegistrosTabela = 1000;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* testa se não é nulo */
        assertEquals(true, !isNull(paginador.getPaginador()));

    }

    @Test
    public void getPaginadorOrdenadoAsc() {

        /* propriedades */
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";
        long numeroRegistrosTabela = 1000;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* esperado e testado */
        String esperado = "nome_coluna: ASC";
        String testado = paginador.getPaginadorOrdenadoAsc("nome_coluna").getSort().toString();

        /* testa se a ordenação */
        assertEquals(true, testado.equals(esperado));

    }

    @Test
    public void getPaginadorOrdenadoDesc() {

        /* propriedades */
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";
        long numeroRegistrosTabela = 1000;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* esperado e testado */
        String esperado = "nome_coluna: DESC";
        String testado = paginador.getPaginadorOrdenadoDesc("nome_coluna").getSort().toString();

        /* testa se a ordenação */
        assertEquals(true, testado.equals(esperado));

    }

    @Test
    public void testGetArrayListNumeroPaginas() {

        /* propriedades */
        long numeroRegistrosTabela = 1000;
        int numeroItensPorPagina = 10;
        String numeroPaginaAtual = "0";

        /* resultado esperado */
        int esperado = 100;

        /* paginador */
        Paginador paginador = new Paginador(numeroItensPorPagina, numeroPaginaAtual, numeroRegistrosTabela);

        /* testa se o calculo para gerar o número de páginas está correto */
        assertEquals(true, (paginador.getArrayListNumeroPaginas().size() - 1) == esperado);

    }

}

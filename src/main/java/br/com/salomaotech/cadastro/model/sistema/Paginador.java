package br.com.salomaotech.cadastro.model.sistema;

import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * Constroe um paginador para o Repository
 *
 * @author @salomaotech
 */
public class Paginador {

    private int numeroItensPorPagina;
    private int numeroPaginaAtual;
    private long numeroRegistrosTabela;

    /**
     * Construtor
     */
    public Paginador() {

    }

    /**
     * Construtor
     *
     * @param numeroItensPorPagina Número de itens por página
     * @param numeroPaginaAtual Número da página atual
     * @param numeroRegistrosTabela Número de registros da tabela
     */
    public Paginador(int numeroItensPorPagina, String numeroPaginaAtual, long numeroRegistrosTabela) {

        /* página atual */
        int paginaAtual;

        /* excessão */
        try {

            paginaAtual = Integer.parseInt(numeroPaginaAtual);

        } catch (java.lang.NumberFormatException ex) {

            paginaAtual = 0;

        }

        /* popula */
        this.numeroItensPorPagina = numeroItensPorPagina;
        this.numeroRegistrosTabela = numeroRegistrosTabela;
        this.numeroPaginaAtual = paginaAtual;

    }

    /**
     * Retorna o paginador
     *
     * @return Página atual
     */
    public Pageable getPaginador() {

        return PageRequest.of(this.numeroPaginaAtual, this.numeroItensPorPagina);

    }

    /**
     * Retorna o paginador ordenado por Direction.ASC
     *
     * @param nomeColuna Nome da coluna
     * @return Página atual
     */
    public Pageable getPaginadorOrdenadoAsc(String nomeColuna) {

        return PageRequest.of(this.numeroPaginaAtual, this.numeroItensPorPagina, Sort.by(Direction.ASC, nomeColuna));

    }

    /**
     * Retorna o paginador ordenado por Direction.DESC
     *
     * @param nomeColuna Nome da coluna
     * @return Página atual
     */
    public Pageable getPaginadorOrdenadoDesc(String nomeColuna) {

        return PageRequest.of(this.numeroPaginaAtual, this.numeroItensPorPagina, Sort.by(Direction.DESC, nomeColuna));

    }

    /**
     * Retorna o ArrayList com o número de páginas
     *
     * @return Número de páginas
     */
    public ArrayList getArrayListNumeroPaginas() {

        /* número de páginas calculadas */
        int numeroPaginasCalculado = Math.round(this.numeroRegistrosTabela / this.numeroItensPorPagina);

        /* ArrayList com o número de páginas calculadas */
        ArrayList arrayListPaginas = new ArrayList();

        /* itera */
        for (int i = 0; i <= numeroPaginasCalculado; i++) {

            /* popula array */
            arrayListPaginas.add(i);

        }

        /* retorno */
        return arrayListPaginas;

    }

}

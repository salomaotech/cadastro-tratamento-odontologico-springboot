package br.com.salomaotech.cadastro.model.cliente;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositório do banco de dados do Spring
 *
 * @author @salomaotech
 */
@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, Long> {

    /**
     * Lista todos os registros, filtros: nenhum
     *
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model", nativeQuery = true)
    List<CadastroModel> findAllList(Pageable pageable);

    /**
     * Retorna a soma de todos os valores, filtros: nenhum
     *
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model", nativeQuery = true)
    BigDecimal findAllListSaldo();

    /**
     * Lista todos os registros, filtros: situacao
     *
     * @param situacao
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE situacao LIKE %?", nativeQuery = true)
    List<CadastroModel> findByHistorico(String situacao, Pageable pageable);

    /**
     * Retorna o número de registros, filtros: situacao
     *
     * @param situacao
     * @return
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE situacao LIKE %?", nativeQuery = true)
    long findByHistoricoCount(String situacao);

    /**
     * Retorna a soma de todos os valores, filtros: situacao
     *
     * @param situacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE situacao LIKE %?", nativeQuery = true)
    BigDecimal findByHistoricoSaldo(String situacao);

    /**
     * Lista todos os registros, filtros: inicio, fim, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE data_inicio BETWEEN ? AND ? AND (situacao LIKE %?)", nativeQuery = true)
    List<CadastroModel> findByHistorico(String inicio, String fim, String situacao, Pageable pageable);

    /**
     * Retorna o número de registros, filtros: inicio, fim, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @return
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE data_inicio BETWEEN ? AND ? AND (situacao LIKE %?)", nativeQuery = true)
    long findByHistoricoCount(String inicio, String fim, String situacao);

    /**
     * Retorna a soma de todos os valores, filtros: inicio, fim, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE data_inicio BETWEEN ? AND ? AND (situacao LIKE %?)", nativeQuery = true)
    BigDecimal findByHistoricoSaldo(String inicio, String fim, String situacao);

}

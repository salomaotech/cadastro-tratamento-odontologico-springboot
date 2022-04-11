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
     * Não usa filtros apenas pagina os dados
     *
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model", nativeQuery = true)
    List<CadastroModel> findAllList(Pageable pageable);

    /**
     * Não usa filtros apenas soma todos os valores
     *
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model", nativeQuery = true)
    BigDecimal findAllSaldo();

    /**
     * Usa os filtros: situacao
     *
     * @param situacao
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE situacao LIKE %?", nativeQuery = true)
    List<CadastroModel> findAllList(String situacao, Pageable pageable);

    /**
     * Usa os filtros: situacao
     *
     * @param situacao
     * @return
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE situacao LIKE %?", nativeQuery = true)
    long findByHistoricoCount(String situacao);

    /**
     * Usa os filtros: situacao
     *
     * @param situacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE situacao LIKE %?", nativeQuery = true)
    BigDecimal findAllSaldo(String situacao);

    /**
     * Usa os filtros: inicio, situacao
     *
     * @param inicio
     * @param situacao
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE data_inicio = ? AND situacao LIKE %?", nativeQuery = true)
    List<CadastroModel> findByHistorico(String inicio, String situacao, Pageable pageable);

    /**
     * Usa os filtros: inicio, situacao
     *
     * @param inicio
     * @param situacao
     * @return
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE data_inicio = ? AND situacao LIKE %?", nativeQuery = true)
    long findByHistoricoCount(String inicio, String situacao);

    /**
     * Usa os filtros: inicio, situacao
     *
     * @param inicio
     * @param situacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE data_inicio = ? AND situacao LIKE %?", nativeQuery = true)
    BigDecimal findByHistoricoSaldo(String inicio, String situacao);

    /**
     * Usa os filtros: inicio, fim, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model WHERE (data_inicio >= ? AND data_conclusao <= ?) AND situacao LIKE %?", nativeQuery = true)
    List<CadastroModel> findByHistorico(String inicio, String fim, String situacao, Pageable pageable);

    /**
     * Usa os filtros: inicio, fim, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @return
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE (data_inicio >= ? AND data_conclusao <= ?) AND situacao LIKE %?", nativeQuery = true)
    long findByHistoricoCount(String inicio, String fim, String situacao);

    /**
     * Usa os filtros: inicio, fim, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE (data_inicio >= ? AND data_conclusao <= ?) AND situacao LIKE %?", nativeQuery = true)
    BigDecimal findByHistoricoSaldo(String inicio, String fim, String situacao);

}

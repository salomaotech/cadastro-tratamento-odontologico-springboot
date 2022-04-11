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
     * Lista todos os resultados, filtros: Nenhum
     *
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM cadastro_model", nativeQuery = true)
    List<CadastroModel> findAllList(Pageable pageable);

    /**
     * Lista todos os resultados, filtros: data, situacao
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
     * Conta o número de registros, filtros: data, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @return
     */
    @Query(value = "SELECT COUNT(id) FROM cadastro_model WHERE data_inicio BETWEEN ? AND ? AND (situacao LIKE %?)", nativeQuery = true)
    long findByHistoricoCount(String inicio, String fim, String situacao);

    /**
     * Retorna a soma de todos os valores, filtros: data, situacao
     *
     * @param inicio
     * @param fim
     * @param situacao
     * @return
     */
    @Query(value = "SELECT SUM(valor) FROM cadastro_model WHERE data_inicio BETWEEN ? AND ? AND (situacao LIKE %?)", nativeQuery = true)
    BigDecimal findByHistoricoSaldo(String inicio, String fim, String situacao);

}

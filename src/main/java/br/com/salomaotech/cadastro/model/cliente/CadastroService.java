package br.com.salomaotech.cadastro.model.cliente;

import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;
    private long id;

    /**
     * Construtor
     *
     * @param cadastroRepository Repositório
     */
    public CadastroService(CadastroRepository cadastroRepository) {

        this.cadastroRepository = cadastroRepository;

    }

    /**
     * Adiciona
     *
     * @param cadastroModel Modelo
     * @return True para ok
     */
    public boolean adicionar(CadastroModel cadastroModel) {

        /* trata erro */
        try {

            /* informa qual id se está trabalhando */
            this.id = cadastroRepository.save(cadastroModel).getId();

            /* retorno */
            return true;

        } catch (java.lang.NullPointerException ex) {

            /* retorno */
            return false;

        }

    }

    /**
     * Atualiza
     *
     * @param id ID do cadastro
     * @param cadastroModel Modelo
     * @return True para ok
     */
    public boolean atualizar(long id, CadastroModel cadastroModel) {

        /* trata erro */
        try {

            /* valida se o ID do registro existe no banco de dados */
            if (cadastroRepository.findById(id).isPresent()) {

                /* informa qual id se está trabalhando */
                this.id = id;

                /* atualiza */
                cadastroRepository.save(cadastroModel);

                /* retorno */
                return true;

            }

        } catch (java.lang.NullPointerException ex) {

        }

        /* retorno */
        return false;

    }

    /**
     * Deleta
     *
     * @param id ID do cadastro
     * @return True para ok
     */
    public boolean deletar(long id) {

        /* trata erro */
        try {

            /* valida se o ID do registro existe no banco de dados */
            if (cadastroRepository.findById(id).isPresent()) {

                /* informa qual id se está trabalhando */
                this.id = id;

                /* deleta */
                cadastroRepository.deleteById(id);

                /* retorno */
                return true;

            }

        } catch (java.lang.NullPointerException ex) {

        }

        /* retorno */
        return false;

    }

    /**
     * Retorna o ID
     *
     * @return id
     */
    public long getId() {

        return id;

    }

}

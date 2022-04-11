package br.com.salomaotech.cadastro.model.sistema;

/**
 * Validador de Strings
 *
 * @author @salomaotech
 */
public class ValidaStringIsEmpty {

    /**
     * True a String é sem valor
     *
     * @param valor Valor a ser analisado
     * @return
     */
    public static boolean isEmpty(String valor) {

        try {

            /* retorno */
            return valor.isEmpty();

        } catch (java.lang.NullPointerException ex) {

            /* retorno */
            return true;

        }

    }

}

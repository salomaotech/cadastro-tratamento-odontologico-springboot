package br.com.salomaotech.cadastro.model.sistema;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Formatador de numeros
 *
 * @author @salomaotech
 */
public class FormataNumero {

    /**
     * Converte para BigDecimal
     *
     * @param numero Número a ser formatado
     * @return Retorna o valor no formato BigDecimal
     */
    public static BigDecimal formatarNumero(String numero) {

        /* excessão */
        try {

            /* converte todas as virgulas para ponto */
            numero = numero.replace(",", ".");

            /* valida se o número contém parte decimal */
            if (numero.contains(".")) {

                /* pega a parte decimal */
                String decimal = numero.substring(numero.lastIndexOf("."), numero.length());

                /* pega o número sem a parte decimal */
                numero = numero.substring(0, numero.lastIndexOf("."));

                /* remove todos os pontos do número para torna-lo inteiro */
                numero = numero.replace(".", "");

                /* adiciona a parte decimal que faltava */
                numero += decimal;

            }

            /* retorno */
            return new BigDecimal(numero);

        } catch (java.lang.NumberFormatException | java.lang.NullPointerException | java.lang.ClassCastException ex) {

            /* retorno */
            return new BigDecimal("0");

        }

    }

    /**
     * Cifrar
     *
     * @param numero Número a ser cifrado
     * @return Número no formato R$ 299,99
     */
    public static String formatarNumeroParaBr(String numero) {

        /* trata excessão */
        try {

            /* BigDecimal */
            BigDecimal valor = formatarNumero(numero);

            /* formata o numero */
            NumberFormat nf = NumberFormat.getCurrencyInstance();

            /* retorno */
            return nf.format(valor);

        } catch (java.lang.NumberFormatException ex) {

            /* retorno */
            return "";

        }

    }

}

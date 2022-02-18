package com.vilelapinheiro;

import java.util.regex.Pattern;

public class Questao2 {
    /**
     * Verifica se uma dada senha corresponde a um critério necessário.
     *
     * @param senha String contendo senha (inserida pelo usuário)
     * @return o número de caracteres que faltam para a senha ser aceita
     * @author Leonardo Vilela Pinheiro
     */
    public static int funcDesafio2(final String senha) {
        final int
                CARACTERES = 6,
                DIGITOS = 1,
                MINUSCULA = 1,
                MAIUSCULO = 1,
                ESPECIAL = 1;

        final int contadorCaracteres = senha.length();
        int contadorDigitos = 0;
        int contadorMinusculas = 0;
        int contadorMaiusculas = 0;
        int contadorEspeciais = 0;

        var pDigitos = Pattern.compile("[0-9]").asMatchPredicate();
        var pMaiusculas = Pattern.compile("[A-Z]").asMatchPredicate();
        var pMinusculas = Pattern.compile("[a-z]").asMatchPredicate();
        var pEspeciais = Pattern.compile("[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+]").asMatchPredicate();


        for (int i = 0; i < senha.length(); i++) {
            final char letraAtual = senha.charAt(i);
            final String stringDaLetraAtual = letraAtual + "";

            if (pDigitos.test(stringDaLetraAtual)) {
                // é um dígito
                contadorDigitos++;
            } else if (pMaiusculas.test(stringDaLetraAtual)) {
                contadorMaiusculas++;
            } else if (pMinusculas.test(stringDaLetraAtual)) {
                contadorMinusculas++;
            } else if (pEspeciais.test(stringDaLetraAtual)) {
                contadorEspeciais++;
            }
        }

        final int faltamCaracteres = Math.max(CARACTERES - contadorCaracteres, 0);
        final int faltamDigitos = Math.max(DIGITOS - contadorDigitos, 0);
        final int faltamMaiusculas = Math.max(MAIUSCULO - contadorMaiusculas, 0);
        final int faltamMinusculas = Math.max(MINUSCULA - contadorMinusculas, 0);
        final int faltamEspeciais = Math.max(ESPECIAL - contadorEspeciais, 0);

        final int faltamTipos = faltamDigitos + faltamMaiusculas + faltamMinusculas + faltamEspeciais;

        return Math.max(faltamTipos, faltamCaracteres);
    }
}

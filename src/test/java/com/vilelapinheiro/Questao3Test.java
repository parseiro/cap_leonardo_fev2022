package com.vilelapinheiro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Questao3Test {

    /**
     * Testa se a função particionadora está funcionando corretamente.
     * @author Leonardo Vilela Pinheiro
     */
    @Test
    void testarParticionamentoTamanho() {
        var triplets = List.of(
                new Triplet<>("Leonardo", 1, List.of("l", "e", "o", "n", "a", "r", "d", "o")),
                new Triplet<>("Leonardo", 2, List.of("le", "eo", "on", "na", "ar", "rd", "do")),
                new Triplet<>("Leonardo", 3, List.of("leo", "eon", "ona", "nar", "ard", "rdo"))
        );

        for (var triplet : triplets) {

            String palavra = triplet.getValue1();
            var size = triplet.getValue2();
            var partes = new ArrayList<>(triplet.getValue3());

            List<String> lista = Questao3.particionar(palavra, size);

            Collections.sort(partes);
            Collections.sort(lista);

            Assertions.assertThat(lista).isEqualTo(partes);
        }
    }


    /**
     * Testa se a contagem de anagramas está correta de acordo com alguns exemplos
     * @author Leonardo Vilela Pinheiro
     */
    @Test
    void testarContagemDeAnagramasDePalavras() {
        var tuplas = List.of(
                new Pair<>("ovo", 2),
                new Pair<>("ifailuhkqq", 3),
                new Pair<>("Leonardo", 2)
        );

        for (var tupla : tuplas) {
            String palavra = tupla.getValue1();
            int anagramas = tupla.getValue2();
            Assertions.assertThat(Questao3.contarAnagramas(palavra)).isEqualTo(anagramas);
        }
    }
}
package com.vilelapinheiro;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Questao2Test {
    /**
     * Aplica casos em forma de testes unitários automáticos
     *
     * @author Leonardo Vilela Pinheiro
     */
    @Test
    void testarResultadosEspeterados() {
        List<Pair<String, Integer>> expectedResults = List.of(
                new Pair<>("Ya3", 3), // minimum 6, lacks 1 special
                new Pair<>("Ya34", 2), // minimum 6, lacks 1 special
                new Pair<>("Ya34$", 1), // minimum 6
                new Pair<>("a34$", 2), // minimum 6, lacks 1 uppercase
                new Pair<>("Y34", 3), // minimum 6, lacks 1 owercase
                new Pair<>("Ya$$$", 1), // minimum 6, lacks 1 digit
                new Pair<>("Ya$!$!", 1), // lacks digit
                new Pair<>("Y#$!$!", 2), // lacks digit and lowercase
                new Pair<>("", 6), // minimium 6, lacks everything
                new Pair<>("123456", 3), // lacks 1 lowercase, 1 uppercase and 1 special
                new Pair<>("12345a", 2), // lacks 1 uppercase and 1 special
                new Pair<>("Ya3@$!", 0), // acceptable
                new Pair<>("aY(+1k", 0) // acceptable
        );

        for (var pair : expectedResults) {
            int result = Questao2.funcDesafio2(pair.getValue1());

            assertThat(result).isEqualTo(pair.getValue2());
        }
    }
}
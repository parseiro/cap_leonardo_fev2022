package com.vilelapinheiro;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Questao1Test {
    @Test
    void testarPiramide() {
        for (int i = 1; i < 25; i++) {
            final String piramide = Questao1.funcDesafio1(i);

            String[] array = piramide.split("\n");

            for (int n = 0; n < array.length; n++) {
                // n is the number of lines which were generated
                // n+1 is the number of stars in nth line
                final String currentLine = array[n];
                final String onlyStars = currentLine.trim();
                final int quantosStarsNaLinha = onlyStars.length();
//                System.err.println("Linha numero " + n + ": " + array[n] + " - encontrei " + quantosStarsNaLinha + " asteriscos");

                assertThat(quantosStarsNaLinha).isEqualTo(n + 1);

                if (n == i) {
                    // I'm at the last line, there must be no trailing space
                    assertThat(currentLine.length()).isEqualTo(onlyStars.length());
                }
            }
        }
    }

    @Test
    void testarPiramideNInvalido() {

        assertThatThrownBy(() -> Questao1.funcDesafio1(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Questao1.funcDesafio1(-1))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
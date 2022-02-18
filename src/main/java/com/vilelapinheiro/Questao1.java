package com.vilelapinheiro;

public class Questao1 {
    public static void main(String... args) {
        String piramide = funcDesafio1(6);
        System.out.println(piramide);
    }

    /**
     * Imprime uma pirâmite de asteriscos, com alinhamento à direita.
     * A primeira linha sempre terá um único asterisco. A última linha terá n asteriscos.
     *
     * @param n número de asteriscos na última linha
     * @throws IllegalArgumentException if n < 1
     * @author Leonardo Vilela Pinheiro
     */
    public static String funcDesafio1(int n) {
        if (n < 1) throw new IllegalArgumentException();

        StringBuilder piramide = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            piramide.append(" ".repeat(n - i));
            piramide.append("*".repeat(i));
            piramide.append("\n");
        }

        return piramide.toString();
    }
}

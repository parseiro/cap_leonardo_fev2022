package com.vilelapinheiro;

import com.google.common.base.Splitter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Questao3 {
    private static final boolean DEBUG = false;

    /**
     * @param palavra String a ser verificada
     * @return o número de pares de substrings que são anagramas
     * @author Leonardo Vilela Pinheiro
     */
    public static int contarAnagramas(String palavra) {
        var listaTotal = new ArrayList<String>();

        palavra = palavra.toLowerCase();

        final int length = palavra.length();

        for (int partitionSize = 1; partitionSize <= 1+length/2; partitionSize++) {
            var list = particionar(palavra, partitionSize);

            listaTotal.addAll(list);
        }

        var listaOrganizada = listaTotal.stream()
                .map(String::toCharArray)
                .peek(Arrays::sort)
                .map(String::new)
                .collect(Collectors.toList());

        var substringsContadas = listaOrganizada.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var listaDosAnagramas = substringsContadas.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                ;

        int size = listaDosAnagramas.size();

        if (DEBUG) {
            System.out.println("Palavra: " + palavra);
            System.out.println("Substrings simples encontradas: " + listaOrganizada);
            System.out.println("Substrings com contagem: " + substringsContadas);
            System.out.println("Anagramas: " + listaDosAnagramas);
            System.out.println("Total: " + size + " anagramas");
        }

        return size;
    }

    /**
     * @param palavra String a ser verificada
     * @param partitionSize tamanho dos pedaços desejados
     * @return uma lista com substrings exatamente com o tamanho pré-definido
     * @author Leonardo Vilela Pinheiro
     */
    public static List<String> particionar(String palavra, int partitionSize) {
        palavra = palavra.toLowerCase();

        var list = new ArrayList<String>();

        for (int startPosition = 0; startPosition < partitionSize; startPosition++) {

            Iterable<String> pieces = Splitter.fixedLength(partitionSize).split(palavra.substring(startPosition));

            pieces.forEach(s -> {
                if (DEBUG) System.out.println("Adicionando a substring: " + s);
                list.add(s);
            });
        }

        list.removeIf(s -> s.length() != partitionSize);
        return list;
    }
}

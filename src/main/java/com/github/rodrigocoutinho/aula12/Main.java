/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rodrigocoutinho.aula12;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    /**
     *
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(final String[] args) throws FileNotFoundException,
            IOException {
        String tipo;
        try {
            if (args[0].equals("-h")) {
                tipo = args[1];
                Relatorio.gerarHTML(Arquivo.ler(tipo));
            } else {
                tipo = args[0];
                Relatorio.gerarJSON(Arquivo.ler(tipo));
            }
            System.exit(1);
        } catch (Exception erro) {
            System.exit(0);
        }

    }

}

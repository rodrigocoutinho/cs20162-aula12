/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rodrigocoutinho.aula12;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {

    /**
     * Metodo recebe um link local ou online e retorna uma lista da leitura
     * feita.
     *
     * @param caminho local ou link do arquivo onde esta armazenado a lista.
     * @return a leitura do arquivo
     * @throws FileNotFoundException
     * @throws MalformedURLException
     * @throws IOException
     */
    public static List<String> ler(final String caminho)
            throws FileNotFoundException, MalformedURLException, IOException,
            NullPointerException {
        try {
            List<String> linhas = new ArrayList<>();
            Scanner leitor = new Scanner(new FileReader(caminho));
            while (leitor.hasNextLine()) {
                linhas.add(leitor.nextLine());
            }
            return linhas;

        } catch (Exception e) {
            URL oracle = new URL(caminho);
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));) {
                List<String> tests = new ArrayList();

                String line = br.readLine();

                while (line != null) {
                    tests.add(line);
                    line = br.readLine();
                }

                br.close();
                return tests;
            }
        }
    }
}

/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rodrigocoutinho.aula12;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class RelatorioTest {
    
    @Test
    public void testConstrutor(){
        Relatorio relatorio = new Relatorio();
    }

    /**
     *
     * @throws java.lang.Exception
     */
    @Test(expected = NullPointerException.class)
    public void testGerarHTMLErro() throws Exception {
        List<String> linhas = null;
        Relatorio.gerarHTML(linhas);
    }

    @Test(expected = NullPointerException.class)
    public void testGeraJsonErro() throws Exception {
        List<String> linhas = null;
        Relatorio.gerarJSON(linhas);
    }

    @Test
    public void relatorioHtml() throws IOException, URISyntaxException, Exception {
        List<String> testeArq = new ArrayList<>();
        testeArq.add("a + b; a=1, b=2; 3");
        testeArq.add("5 / (6 - 5);;5");
        testeArq.add("5 / (6 - 5);;4");
        String diretorio = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(diretorio + "/teste.txt");
        Files.write(file, testeArq, Charset.forName("UTF-8"));

        List<String> linhas = testeArq;
        Relatorio.gerarHTML(linhas);

        file = Paths.get(diretorio + "/relatorio.html");
        Files.delete(file);
        file = Paths.get(diretorio + "/teste.txt");
        Files.delete(file);
    }

    @Test
    public void relatorioJSON() throws IOException, URISyntaxException, Exception {
        List<String> testeArq = new ArrayList<>();
        testeArq.add("a + b; a=1, b=2; 3");
        testeArq.add("5 / (6 - 5);;5");
        testeArq.add("5 / (6 - 5);;4");
        String diretorio = new File(Main.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath())
                .getParent();
        Path file = Paths.get(diretorio + "/teste3.txt");
        Files.write(file, testeArq, Charset.forName("UTF-8"));

        List<String> linhas = testeArq;
        Relatorio.gerarJSON(linhas);

        file = Paths.get(diretorio + "/relatorio.json");
        Files.delete(file);
        file = Paths.get(diretorio + "/teste3.txt");
        Files.delete(file);
    }
    /**
     *
     */
    @Test
    public void testHtml() {
        List<String> linhas;
        linhas = new ArrayList();
        linhas.add("1 + 1;;2");
        linhas.add("5 * 5;;24");
        int numLinhas = linhas.size();
        String codigo;
        codigo = "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"UTF-8\">\n"
                + "<title>Relatório de Testes</title>\n</head>\n<body>\n"
                + "<h1>Resultado geral</h1>\n<table>\n<tr>\n"
                + "<td><b>Tempo total</b></td>\n<td>0.0</td>\n</tr>\n<tr>\n"
                + "<td><b>Tempo médio</b></td>\n<td>0.0</td>\n</tr>\n<tr>\n"
                + "<td><b>Total de testes</b></td>\n<td>2</td>\n</tr>\n<tr>\n"
                + "<td><b>Corretos</b></td>\n<td>1</td>\n</tr>\n<tr>\n"
                + "<td><b>Falhas</b></td>\n<td>1</td>\n</tr>\n</table>\n\n"
                + "<h1>Relatório detalhado dos testes</h1>\n<table>\n<tr>\n"
                + "<th>Expressão</th>\n<th>Esperado</th>\n<th>Obtido</th>\n"
                + "</tr>\n<tr>\n<td>1 + 1</td>\n<td>2.0</td>\n<td>2.0</td>\n"
                + "</tr>\n<tr><tr>\n<td>5 * 5</td>\n<td>24.0</td>\n"
                + "<td>25.0</td>\n</tr>\n<tr></tr>\n</table>\n</body>\n\n"
                + "</html>";
        assertEquals(codigo, Relatorio.html(numLinhas, linhas));
    }

    /**
     *
     */
    @Test
    public void testJson() {
        ArrayList<String> linhas;
        linhas = new ArrayList();
        linhas.add("1 + 1;;2");
        linhas.add("5 * 5;;24");
        int numLinhas = linhas.size();
        String codigo;
        codigo = "\"tempoTotal\": 0.0,\n\"tempoMedio\": 0.0,\n\"total\": 2,\n"
                + "\"sucesso\": 1,\n\"falha\": 1,\n\"testes\": [\n"
                + "{\"expressao\": \"1 + 1\",\n\"esperado\": 2.0,\n"
                + "\"obtido\": 2.0}\n,\n{\"expressao\": \"5 * 5\",\n"
                + "\"esperado\": 24.0,\n\"obtido\": 25.0}\n]";
        assertEquals(codigo, Relatorio.json(numLinhas, linhas));
    }
}

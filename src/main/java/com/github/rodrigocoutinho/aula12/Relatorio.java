/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rodrigocoutinho.aula12;

import static com.github.rodrigocoutinho.aula12.Calcular.parser;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Pattern;

public class Relatorio {

    /**
     *
     * @param linhas
     */
    public static void gerarHTML(final List linhas) {
        Formatter arquivo;
        int numLinhas = linhas.size();
        try {
            arquivo = new Formatter("relatorio.html");
            arquivo.format(html(numLinhas, linhas));
            arquivo.close();
        } catch (Exception excessao) {

        }
    }

    /**
     *
     * @param numLinhas
     * @param linhas
     * @return
     */
    public static String json(final int numLinhas,
            final List<String> linhas) {
        String total, parte1, parte2 = "", expressao;
        float tempoTotal = 0, tempoMedio = 0, esperado, obtido;
        int totalTestes = numLinhas, sucesso = 0, falha = 0;

        for (int cont = 0; cont < numLinhas; cont++) {

            String aux = (String) linhas.get(cont);
            String[] parsers = aux.split(Pattern.quote(";"));
            expressao = parsers[0];
            esperado = Float.parseFloat(parsers[2]);
            obtido = parser(expressao);

            if (esperado == obtido) {
                sucesso++;
            } else {
                falha++;
            }

            parte2 += "{\"expressao\": \"" + expressao + "\",\n"
                    + "\"esperado\": " + esperado + ",\n" + "\"obtido\": "
                    + obtido + "" + "}\n";
            if (cont < numLinhas - 1) {
                parte2 += ",\n";
            }
        }

        parte1 = "\"tempoTotal\": " + tempoTotal + ",\n\"tempoMedio\": "
                + tempoMedio + ",\n\"total\": " + totalTestes
                + ",\n\"sucesso\": " + sucesso + ",\n\"falha\": "
                + falha + ",\n\"testes\": [\n";

        total = parte1 + parte2 + "]";

        return total;
    }

    /**
     *
     * @param numLinhas
     * @param linhas
     * @return
     */
    public static String html(final int numLinhas, final List linhas) {
        String parte1, parte2, parte3, parte4, parte5, parte6, parte7 = "",
                total, expressao;
        float tempoTotal = 0, tempoMedio = 0, esperado, obtido;
        int totalTestes = numLinhas, corretos = 0, falhas = 0;

        for (int cont = 0; cont < numLinhas; cont++) {
            String aux = (String) linhas.get(cont);
            String[] parsers = aux.split(Pattern.quote(";"));
            expressao = parsers[0];
            esperado = Float.parseFloat(parsers[2]);
            obtido = parser(expressao);
            if (esperado == obtido) {
                corretos++;
            } else {
                falhas++;
            }
            parte7 += "<tr>" + "\n" + "<td>" + expressao + "</td>\n"
                    + "<td>" + esperado + "</td>\n"
                    + "<td>" + obtido + "</td>\n"
                    + "</tr>\n<tr>";
        }

        parte1 = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Relatório de Testes</title>\n" + "</head>\n"
                + "<body>\n" + "<h1>Resultado geral</h1>\n" + "<table>\n"
                + "<tr>\n" + "<td><b>Tempo total</b></td>\n" + "<td>";
        parte2 = "</td>\n" + "</tr>\n" + "<tr>\n"
                + "<td><b>Tempo médio</b></td>\n" + "<td>";
        parte3 = "</td>\n" + "</tr>\n" + "<tr>\n"
                + "<td><b>Total de testes</b></td>\n" + "<td>";
        parte4 = "</td>\n" + "</tr>\n" + "<tr>\n"
                + "<td><b>Corretos</b></td>\n" + "<td>";
        parte5 = "</td>\n" + "</tr>\n" + "<tr>\n" + "<td><b>Falhas</b></td>\n"
                + "<td>";
        parte6 = "</td>\n" + "</tr>\n" + "</table>\n" + "\n"
                + "<h1>Relatório detalhado dos testes</h1>\n" + "<table>\n"
                + "<tr>\n" + "<th>Expressão</th>\n" + "<th>Esperado</th>\n"
                + "<th>Obtido</th>\n" + "</tr>\n";
        total = parte1 + tempoTotal + parte2 + tempoMedio + parte3
                + totalTestes + parte4 + corretos + parte5 + falhas + parte6
                + parte7;

        total += "</tr>\n" + "</table>\n" + "</body>\n" + "\n" + "</html>";

        return total;
    }

    /**
     *
     * @param ler
     */
    static void gerarJSON(List<String> ler) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

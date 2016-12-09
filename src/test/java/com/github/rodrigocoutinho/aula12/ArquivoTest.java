/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rodrigocoutinho.aula12;

import static com.github.rodrigocoutinho.aula12.Arquivo.ler;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ArquivoTest {

    /**
     * Testa o arquivo metodo que lê o arquivo online.
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    @Test
    public void testArquivoOnline() throws MalformedURLException, IOException {
        ler("http://m.uploadedit.com/ba3s/1481289280351.txt");
    }

    /**
     * Inicializa a classe.
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    @Test
    public void testArq() throws MalformedURLException, IOException {
        Arquivo novoarquivo = new Arquivo();
    }

    /**
     * Testa e compara os dois modos de leitura
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    @Test
    public void testComparandoLeitura() throws MalformedURLException, IOException {
        List<String> testando = new ArrayList();
        testando.add("5/2 );;3");
        Assert.assertEquals(ler("http://m.uploadedit.com/ba3s/1481289280351.txt"),
                ler("test2.txt"));
    }

    /**
     * Testa a leitura de um arquivo local.
     *
     * @throws MalformedURLException
     * @throws NullPointerException
     * @throws IOException
     */
    @Test
    public void testandoLer() throws MalformedURLException, NullPointerException, IOException {
        ler("test2.txt");

    }

    /**
     * Testa a leitura quando um arquivo não é encontrado.
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    @Test(expected = IOException.class)
    public void testLocalDoArquivoNaoEcontrado() throws MalformedURLException,
            IOException {

        ler("c:\\naoecontrado\\gg.txt");
    }

}

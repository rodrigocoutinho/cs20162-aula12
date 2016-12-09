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

    @Test
    public void obterArquivoOnline() throws MalformedURLException, IOException {
        ler("http://m.uploadedit.com/ba3s/1481289280351.txt");
    }

    @Test
    public void testArq () throws MalformedURLException, IOException{
        Arquivo novoarquivo = new Arquivo();
    }
    
    @Test
    public void testComparandoLeitura() throws MalformedURLException, IOException{
        List<String> testando = new ArrayList();
        testando.add("5/2 );;3");
        Assert.assertEquals(ler("http://m.uploadedit.com/ba3s/1481289280351.txt"),
                ler("test2.txt"));
    }
    

    @Test
    public void testandoLer() throws MalformedURLException, NullPointerException, IOException {
        ler("test2.txt");

    }

    @Test(expected = IOException.class)
    public void testLocalDoArquivoNaoEcontrado() throws MalformedURLException,
            IOException {

        ler("c:\\naoecontrado\\gg.txt");
    }

}

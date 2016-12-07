/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rodrigocoutinho.aula12;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shakaw
 */
public class CalcularTest {

    /**
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testParserNullArgs() {
        assertEquals(1, Calcular.parser(null), 0);
    }

    /**
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testParserExpressaoVazia() {
        assertEquals(1, Calcular.parser(" "), 0);
    }

    /**
     *
     */
    @Test
    public void testParser() {
        assertEquals(2.0f, Calcular.parser("1 + 1"), 0.0);
        assertEquals(5.0f, Calcular.parser("10 / 2"), 0.0);
    }

}

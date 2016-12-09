/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rodrigocoutinho.aula12;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;

import java.util.List;

public final class Calcular {

    /**
     * Recebe uma expressao e retorna o resultado.
     *
     * @param expressao expressão matematica a ser processada.
     * @return retorna o resultado da expressão matematica.
     */
    public static float parser(final String expressao) {
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor();

        return resultado;
    }
}

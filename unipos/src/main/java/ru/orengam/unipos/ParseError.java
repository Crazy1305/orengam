/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos;

/**
 *
 * @author vadim.shakirov
 */
public class ParseError extends Exception {

    public ParseError(Throwable fillInStackTrace) {
        super(fillInStackTrace);
    }

    public ParseError() {
    }
    
}

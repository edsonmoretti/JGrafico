/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

/**
 *
 * @author Edson Moretti
 */
public class JGraficoException extends Exception {

    /**
     * Creates a new instance of <code>JGraficoException</code> without detail
     * message.
     */
    protected JGraficoException() {
    }

    /**
     * Constructs an instance of <code>JGraficoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public JGraficoException(String msg) {
        super(msg);
    }
}

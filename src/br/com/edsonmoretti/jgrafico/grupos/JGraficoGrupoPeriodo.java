/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico.grupos;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Edson
 */
public final class JGraficoGrupoPeriodo extends TreeMap<Date, Number> {

    private String titulo;

    public JGraficoGrupoPeriodo(String titulo) {
        this.titulo = titulo;
    }

    public JGraficoGrupoPeriodo(Map<? extends Date, ? extends Number> m) {
        super(m);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void adicionar(Date data, Number valor) {
        this.put(data, valor);
    }

    public void remover(Date data, Number valor) {
        this.remove(data, valor);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico.grupos;

import java.awt.Color;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Edson Moretti
 */
public final class JGraficoPontoXY extends TreeMap<Number, Number> {

    private String titulo;

    public JGraficoPontoXY(Map<? extends Number, ? extends Number> map, String titulo) {
        super(map);
        setTitulo(titulo);
    }

    public JGraficoPontoXY(String titulo) {
        this.titulo = titulo;
    }

    public void limpar() {
        this.clear();
    }

    public Number adicionar(Number posicaoX, Number posicaoY) {
        return super.put(posicaoX, posicaoY); //To change body of generated methods, choose Tools | Templates.
    }

    public Number add(Number posicaoX, Number PosicaoY) {
        return super.put(posicaoX, PosicaoY); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return @deprecated Use o getTitulo();
     */
    public String getDescricao() {
        return titulo;
    }

}

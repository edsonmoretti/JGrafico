/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico.grupos;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Edson Moretti
 */
public final class JGraficoGrupo extends TreeMap<String, Number> {

    private String titulo;

    public JGraficoGrupo(Map<? extends String, ? extends Number> map, String titulo) {
        super(map);
        setTitulo(titulo);
    }

    public JGraficoGrupo(String titulo) {
        this.titulo = titulo;
    }

    public void limpar() {
        this.clear();
    }

    public Number adicionar(String chaveDescricao, Number valor) {
        return super.put(chaveDescricao, valor); //To change body of generated methods, choose Tools | Templates.
    }

    public Number add(String chaveDescricao, Number valor) {
        return super.put(chaveDescricao, valor); //To change body of generated methods, choose Tools | Templates.
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico.Testes;

/**
 *
 * @author Edson Moretti
 */
class GraficoPizzaTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        br.com.edsonmoretti.jgrafico.JGraficoPizza demo = new br.com.edsonmoretti.jgrafico.JGraficoPizza("Edson Moretti - JGrafico");
        demo.setTituloDoGrafico("Titulo do Grafico");
        demo.adicionarDado("Produto 1", 4);
        demo.adicionarDado("Produto 2", 10);
        demo.adicionarDado("Produto 3", 10);
        demo.adicionarDado("Produto 4", 4);
        demo.adicionarDado("Produto 5", 13);
        demo.exibirLegendas(true);
        demo.exibirTooltip(true);
        demo.centralizaNaTela();
        demo.setVisible(true);
    }

}

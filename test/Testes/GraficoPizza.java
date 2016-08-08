/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import org.jfree.util.Rotation;

/**
 *
 * @author Edson Moretti
 */
class GraficoPizza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        br.com.edsonmoretti.jgrafico.JGraficoPizza demo = new br.com.edsonmoretti.jgrafico.JGraficoPizza("Edson Moretti - www.edsonmoretti.com.br");
        demo.setTituloDoGrafico("Titulo do Grafico");
        demo.adicionarDado("Produto 1", 4);
        demo.adicionarDado("Produto 2", 10);
        demo.adicionarDado("Produto 3", 10);
        demo.adicionarDado("Produto 4", 4);
        demo.adicionarDado("Produto 5", 13);
        demo.exibirLegendas(true);
        demo.exibirTooltip(true);
        demo.adicionarDado("Produto 6", 20);
        demo.adicionarDadoEDestacar("Produto 7", 21, 0.10);
        demo.adicionarDestaqueDoGraficoPizza("Produto 6", 0.1);
        demo.setGirar(true, Rotation.CLOCKWISE, 1.0f);
        demo.setVisible(true);
    }

}

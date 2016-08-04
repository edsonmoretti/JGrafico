/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico.Testes;

import br.com.edsonmoretti.jgrafico.JGraficoBarra;
import br.com.edsonmoretti.jgrafico.JGraficoGrupo;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author Edson Moretti
 */
public class GraficoBarraTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JGraficoBarra demo = new JGraficoBarra("Edson Moretti - JGrafico");
        demo.setTituloDoGrafico("Titulo do Gráfico Barra");

        JGraficoGrupo g1 = new JGraficoGrupo("Janeiro");
        g1.add("Produto1", 30);
        g1.add("Produto2", 40);
        g1.add("Produto3", 50);
        JGraficoGrupo g2 = new JGraficoGrupo("Fevereiro");
        g2.add("Produto1", 50);
        g2.add("Produto2", 40);
        g2.add("Produto3", 30);
        JGraficoGrupo g3 = new JGraficoGrupo("Março");
        g3.add("Produto1", 40);
        g3.add("Produto2", 50);
        g3.add("Produto3", 30);

        demo.adicionar(g1);
        demo.adicionar(g2);
        demo.adicionar(g3);

        demo.setOrientacao(PlotOrientation.HORIZONTAL);
//        demo.setOrientacao(PlotOrientation.VERTICAL);
        demo.exibirLegendas(true);
        demo.exibirTooltip(true);
        demo.centralizaNaTela();
        demo.setVisible(true);
    }

}

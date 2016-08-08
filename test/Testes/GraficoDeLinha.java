/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.com.edsonmoretti.jgrafico.JGraficoDeLinha;
import br.com.edsonmoretti.jgrafico.grupos.JGraficoGrupo;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author Edson Moretti
 */
public class GraficoDeLinha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JGraficoDeLinha demo = new JGraficoDeLinha("Edson Moretti - www.edsonmoretti.com.br");
        demo.setTituloDoGrafico("Titulo do Gráfico DeLinha - Crescimento de Vendas");

        JGraficoGrupo g1 = new JGraficoGrupo("Vendas do produto 1");
        g1.add("1. Janeiro", 2050);
        g1.add("2. Fevereiro", 2200);
        g1.add("3. Março", 2200);
        g1.add("4. Abril", 2100);
        g1.add("5. Maio", 1900);
        g1.add("6. Junho", 3000);

        JGraficoGrupo g2 = new JGraficoGrupo("Vendas do produto 2");
        g2.add("1. Janeiro", 1000);
        g2.add("2. Fevereiro", 1200);
        g2.add("3. Março", 2200);
        g2.add("4. Abril", 1300);
        g2.add("5. Maio", 2500);
        g2.add("6. Junho", 2500);
        demo.adicionar(g1);
        demo.adicionar(g2);
        demo.setSize(700, 500);
        demo.setOrientacao(PlotOrientation.VERTICAL);
//        demo.setOrientacao(PlotOrientation.HORIZONTAL);
        demo.exibirLegendas(true);
        demo.exibirTooltip(true);
        demo.setVisible(true);
    }

}

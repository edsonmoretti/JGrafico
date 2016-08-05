/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico.Testes;

import br.com.edsonmoretti.jgrafico.JGraficoGrupoXY;
import br.com.edsonmoretti.jgrafico.JGraficoPontosXY;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Edson Moretti
 */
public class GraficoPontosXY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JGraficoPontosXY demo = new JGraficoPontosXY("Titulo da Janela");
        demo.setTituloDoGrafico("Titulo de Grafico");
        JGraficoGrupoXY grupo = new JGraficoGrupoXY("Edson");
        grupo.add(1, 10);
        grupo.add(2, 20);
        grupo.add(3, 30);
        grupo.add(4, 40);
        JGraficoGrupoXY grupo2 = new JGraficoGrupoXY("Daniel");
        grupo2.add(1, 45);
        grupo2.add(2, 50);
        grupo2.add(3, 60);
        grupo2.add(4, 70);
        JGraficoGrupoXY grupo3 = new JGraficoGrupoXY("Heleno");
        grupo3.add(1, -10);
        grupo3.add(2, -20);
        grupo3.add(3, -30);
        grupo3.add(4, -40);

        demo.adicionar(grupo, grupo2, grupo3);
        demo.setTamanho(800, 700);
        demo.setExibirLegendas(true);
        demo.setExibirTooltips(true);
        demo.setRotuloX("Dias");
        demo.setRotuloY("Qtd Estoque");
        demo.setVisible(true);
    }

}

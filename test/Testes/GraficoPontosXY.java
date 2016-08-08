/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.com.edsonmoretti.jgrafico.grupos.JGraficoPontoXY;
import br.com.edsonmoretti.jgrafico.JGraficoPontosXY;

/**
 *
 * @author Edson Moretti
 */
public class GraficoPontosXY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JGraficoPontosXY demo = new JGraficoPontosXY("Edson Moretti - www.edsonmoretti.com.br");
        demo.setTituloDoGrafico("Titulo de Grafico");
        JGraficoPontoXY grupo = new JGraficoPontoXY("Edson");
        grupo.add(1, 10);
        grupo.add(2, 20);
        grupo.add(3, 30);
        grupo.add(4, 40);
        JGraficoPontoXY grupo2 = new JGraficoPontoXY("Daniel");
        grupo2.add(1, 45);
        grupo2.add(2, 50);
        grupo2.add(3, 60);
        grupo2.add(4, 70);
        JGraficoPontoXY grupo3 = new JGraficoPontoXY("Heleno");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.com.edsonmoretti.jgrafico.JGraficoPeriodoLinha;
import br.com.edsonmoretti.jgrafico.grupos.JGraficoGrupoPeriodo;
import java.util.Date;
import org.jfree.data.time.Day;

/**
 *
 * @author Edson
 */
public class GraficoPeriodoLinha {
    
    public static void main(String[] args) {
        JGraficoPeriodoLinha demo = new JGraficoPeriodoLinha("Edson Moretti - www.edsonmoretti.com.br");
        JGraficoGrupoPeriodo grupo = new JGraficoGrupoPeriodo("Media");
        grupo.adicionar(new Date(), 10);
        grupo.adicionar(new Day(6, 8, 2016).getStart(), 20);
        grupo.adicionar(new Day(4, 8, 2016).getStart(), 11);
        grupo.adicionar(new Day(3, 8, 2016).getStart(), 11);
        grupo.adicionar(new Day(2, 8, 2016).getStart(), 11);
        grupo.adicionar(new Day(1, 8, 2016).getStart(), 11);
        JGraficoGrupoPeriodo grupo2 = new JGraficoGrupoPeriodo("Excedido");
        grupo2.adicionar(new Date(), 10);
        grupo2.adicionar(new Day(6, 8, 2016).getStart(), 12);
        grupo2.adicionar(new Day(4, 8, 2016).getStart(), 13);
        grupo2.adicionar(new Day(3, 8, 2016).getStart(), 11);
        grupo2.adicionar(new Day(2, 8, 2016).getStart(), 11);
        grupo2.adicionar(new Day(1, 8, 2016).getStart(), -11);

        demo.adicionar(grupo);
        demo.adicionar(grupo2);

        demo.setRotuloInferior("setInformacaoInferior ou setInformacaoInferior");
        demo.setRotuloLateralEsquerdo("setInformacaoInferior ou setInformacaoInferior");
        demo.setExibirLegendas(true);
//        demo.setExibirTooltips(true);
//        demo.setExibirCliqueXY(true);
        
//        demo.setExibirAno(true);
        demo.setExibirDiaDaSemana(true);
        demo.setExibirNumeroDoDiaNoMes(true);
        demo.setVisible(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Edson Moretti
 */
public class JGraficoDeLinha extends JGraficoBarra {

    public JGraficoDeLinha(String titulo) {
        super(titulo);
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart lineChart = ChartFactory.createLineChart(
                getTituloDoGrafico(),
                getDescricaoInferior(),
                getDescricaoLateralEsquerda(),
                getDataSet(),
                getOrientacao(),
                isExibirLegendas(),
                isExibirTooltips(),
                false
        );
        return lineChart;
    }

}

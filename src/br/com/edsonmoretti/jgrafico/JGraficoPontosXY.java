/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.HashMap;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.RefineryUtilities;

/**
 * A demo scatter plot.
 */
public class JGraficoPontosXY extends JGrafico {

    private String rotuloX = "X";
    private String rotuloY = "Y";
    private PlotOrientation orientacao = PlotOrientation.VERTICAL;
    private String mensagemSemDados = "Não há dados.";
    private boolean exibitLinhaEixoX = true;
    private boolean exibirLinhaEixoY = true;
    private DefaultXYDataset dataset = new DefaultXYDataset();

    public JGraficoPontosXY(String titulo) {
        super(titulo);
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart chart = ChartFactory.createScatterPlot(getTituloDoGrafico(), rotuloX, rotuloY, dataset, orientacao, isExibirLegendas(), isExibirTooltips(), false);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setNoDataMessage(mensagemSemDados);
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setDomainZeroBaselineVisible(exibirLinhaEixoY);
        plot.setRangeZeroBaselineVisible(exibitLinhaEixoX);

        plot.setDomainGridlineStroke(new BasicStroke(0.0f));
        plot.setDomainMinorGridlineStroke(new BasicStroke(0.0f));
        plot.setDomainGridlinePaint(Color.blue);
        plot.setRangeGridlineStroke(new BasicStroke(0.0f));
        plot.setRangeMinorGridlineStroke(new BasicStroke(0.0f));
        plot.setRangeGridlinePaint(Color.blue);

        plot.setDomainMinorGridlinesVisible(true);
        plot.setRangeMinorGridlinesVisible(true);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesOutlinePaint(0, Color.black);
        renderer.setUseOutlinePaint(true);
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);

        domainAxis.setTickMarkInsideLength(2.0f);
        domainAxis.setTickMarkOutsideLength(2.0f);

        domainAxis.setMinorTickCount(2);
        domainAxis.setMinorTickMarksVisible(true);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickMarkInsideLength(2.0f);
        rangeAxis.setTickMarkOutsideLength(2.0f);
        rangeAxis.setMinorTickCount(2);
        rangeAxis.setMinorTickMarksVisible(true);
        return chart;
    }

    private static final int X = 0;
    private static final int Y = 1;
    private HashMap<String, HashMap<Number, Number>> valores = new HashMap<>();

    private void atualizarDataSet() {
        for (String serie : valores.keySet()) {
            double[][] ponto = new double[2][valores.get(serie).size()];
            int posicao = 0;
            for (Number x : valores.get(serie).keySet()) {
                double y = valores.get(serie).get(x).doubleValue(); //pega o Y ligado ao X
                ponto[X][posicao] = x.doubleValue();
                ponto[Y][posicao] = y;
                posicao++; //posicao esquerda da matriz
            }
            dataset.addSeries(serie, ponto);
        }
    }

    public void adicionar(JGraficoGrupoXY... grupos) {
        for (JGraficoGrupoXY jGraficoGrupoXY : grupos) {
            adicionar(jGraficoGrupoXY);
        }
    }

    public void adicionar(JGraficoGrupoXY grupo) {
        for (Number posicaoX : grupo.keySet()) {
            adicionar(grupo.getDescricao(), posicaoX, grupo.get(posicaoX));
        }
    }

    public void adicionar(String serieDados, Number valorX, Number valorY) {
        if (valores.containsKey(serieDados)) {
            valores.get(serieDados).put(valorX, valorY);
        } else {
            valores.put(serieDados, new HashMap<>());
            valores.get(serieDados).put(valorX, valorY);
        }
        atualizarDataSet();
    }

    @Override
    public JPanel criarJPanel() {
        JFreeChart chart = criarGrafico();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public void setOrientacao(PlotOrientation orientacao) {
        this.orientacao = orientacao;
    }

    public String getRotuloX() {
        return rotuloX;
    }

    public void setRotuloX(String rotuloX) {
        this.rotuloX = rotuloX;
    }

    public String getRotuloY() {
        return rotuloY;
    }

    public void setRotuloY(String rotuloY) {
        this.rotuloY = rotuloY;
    }

    public PlotOrientation getOrientacao() {
        return orientacao;
    }

    public String getMensagemSemDados() {
        return mensagemSemDados;
    }

    public void setMensagemSemDados(String mensagemSemDados) {
        this.mensagemSemDados = mensagemSemDados;
    }

    public boolean isExibitLinhaEixoX() {
        return exibitLinhaEixoX;
    }

    public void setExibitLinhaEixoX(boolean exibitLinhaEixoX) {
        this.exibitLinhaEixoX = exibitLinhaEixoX;
    }

    public boolean isExibirLinhaEixoY() {
        return exibirLinhaEixoY;
    }

    public void setExibirLinhaEixoY(boolean exibirLinhaEixoY) {
        this.exibirLinhaEixoY = exibirLinhaEixoY;
    }

}

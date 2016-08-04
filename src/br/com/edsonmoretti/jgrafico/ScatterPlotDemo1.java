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
public class ScatterPlotDemo1 extends JGrafico {

    private String rotuloX = "X";
    private String rotuloY = "Y";
    private PlotOrientation orientacao = PlotOrientation.VERTICAL;
    private String mensagemSemDados = "Não há dados.";
    private boolean exibitLinhaEixoX = true;
    private boolean exibirLinhaEixoY = true;
    private DefaultXYDataset dataset = new DefaultXYDataset();

    public ScatterPlotDemo1(String titulo) {
        super(titulo);
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart chart = ChartFactory.createScatterPlot(getTitle(), rotuloX, rotuloY, dataset, orientacao, isExibirLegendas(), isExibirTooltips(), false);

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

    public static void main(String[] args) {
        ScatterPlotDemo1 demo = new ScatterPlotDemo1("Titulo");
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

//        demo.criar
        
        demo.adicionar(grupo, grupo2, grupo3);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setTamanho(800, 700);
        demo.setExibirLegendas(true);
        demo.setExibirTooltips(true);
        demo.setRotuloX("Dias");
        demo.setRotuloY("Qtd Estoque");
        demo.get();
        demo.setVisible(true);
    }

    private static final int X = 0;
    private static final int Y = 1;
    private HashMap<String, HashMap<Number, Number>> valores = new HashMap<>();

    public void get() {
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

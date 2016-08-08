/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

/**
 *
 * @author Edson Moretti
 */
import br.com.edsonmoretti.jgrafico.grupos.JGraficoGrupoPeriodo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.ui.RectangleInsets;

/**
 * In this demo, the {@link PeriodAxis} class is used to display both date and
 * day-of-the-week labels on a bar chart.
 */
public class JGraficoPeriodoBarra extends JGrafico {

    private TimeSeriesCollection timeseries = new TimeSeriesCollection();
    private String rotuloInferior;
    private String rotuloLateralEsquerdo;
    private PlotOrientation orientacao = PlotOrientation.VERTICAL;
    private boolean exibirCliqueXY;
    private boolean exibirAno;
    private boolean exibirMes;
    private boolean exibirDiaDaSemana;
    private boolean exibirNumeroDoDiaNoMes;

    public JGraficoPeriodoBarra(String title) {
        super(title);
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart chart = ChartFactory.createXYBarChart(
                getTituloDoGrafico(),
                rotuloInferior,
                true,
                rotuloLateralEsquerdo,
                timeseries,
                getOrientacao(),
                isExibirLegendas(),
                isExibirTooltips(),
                false);
        XYPlot plot = (XYPlot) chart.getPlot();

        plot.setDomainCrosshairVisible(isExibirCliqueXY());
        plot.setRangeCrosshairVisible(isExibirCliqueXY());

        PeriodAxis domainAxis = new PeriodAxis(getRotuloInferior());
//        domainAxis.setAutoRangeTimePeriodClass(Day.class);

        int i = getInformacaoFooterCount();
        PeriodAxisLabelInfo[] infoDeBaixo = new PeriodAxisLabelInfo[i];
        i = 0;
        if (exibirNumeroDoDiaNoMes) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        }
        if (exibirDiaDaSemana) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("E"), new RectangleInsets(2, 2, 2, 2), new Font("SansSerif", Font.BOLD, 10), Color.blue, false, new BasicStroke(0.0f), Color.lightGray);
        }
        if (exibirMes) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM"));
        }
        if (exibirAno) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("YYYY"));
        }
        domainAxis.setLabelInfo(infoDeBaixo);
        plot.setDomainAxis(domainAxis);
        ChartUtilities.applyCurrentTheme(chart);
        return chart;
    }

    public int getInformacaoFooterCount() {
        int i = 0;
        if (exibirNumeroDoDiaNoMes) {
            i++;
        }
        if (exibirDiaDaSemana) {
            i++;
        }
        if (exibirMes) {
            i++;
        }
        if (exibirAno) {
            i++;
        }
        return i;
    }

    public void adicionar(JGraficoGrupoPeriodo grupo) {
        TimeSeries ts = new TimeSeries(grupo.getTitulo());
        for (Date date : grupo.keySet()) {
            ts.add(new Day(date), grupo.get(date));
        }
        timeseries.addSeries(ts);
    }

    public void limpar() {
        timeseries.removeAllSeries();
    }

    public boolean isExibirAno() {
        return exibirAno;
    }

    public void setExibirAno(boolean exibirAno) {
        this.exibirAno = exibirAno;
    }

    public boolean isExibirMes() {
        return exibirMes;
    }

    public void setExibirMes(boolean exibirMes) {
        this.exibirMes = exibirMes;
    }

    public boolean isExibirDiaDaSemana() {
        return exibirDiaDaSemana;
    }

    public void setExibirDiaDaSemana(boolean exibirDiaDaSemana) {
        this.exibirDiaDaSemana = exibirDiaDaSemana;
    }

    public boolean isExibirNumeroDoDiaNoMes() {
        return exibirNumeroDoDiaNoMes;
    }

    public void setExibirNumeroDoDiaNoMes(boolean exibirNumeroDoDiaNoMes) {
        this.exibirNumeroDoDiaNoMes = exibirNumeroDoDiaNoMes;
    }

    public String getDescricaoInferior() {
        return rotuloInferior;
    }

    public String getDescricaoLateralEsquerda() {
        return rotuloLateralEsquerdo;
    }

    public String getRotuloInferior() {
        return rotuloInferior;
    }

    public void setDescricaoInferior(String rotuloInferior) {
        this.rotuloInferior = rotuloInferior;
    }

    public String getDescricaoLateralEsquerdo() {
        return rotuloLateralEsquerdo;
    }

    public void setRotuloInferior(String rotuloInferior) {
        this.rotuloInferior = rotuloInferior;
    }

    public String getRotuloLateralEsquerdo() {
        return rotuloLateralEsquerdo;
    }

    public void setRotuloLateralEsquerdo(String rotuloLateralEsquerdo) {
        this.rotuloLateralEsquerdo = rotuloLateralEsquerdo;
    }

    public PlotOrientation getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(PlotOrientation orientacao) {
        this.orientacao = orientacao;
    }

    public boolean isExibirCliqueXY() {
        return exibirCliqueXY;
    }

    public void setExibirCliqueXY(boolean exibirCliqueXY) {
        this.exibirCliqueXY = exibirCliqueXY;
    }

    public TimeSeriesCollection getTimeseries() {
        return timeseries;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.Year;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Edson
 */
public class JGraficoPeriodoLinha extends JGraficoPeriodoBarra {

    public JGraficoPeriodoLinha(String title) {
        super(title);
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart chart = ChartFactory.createXYLineChart(
                getTituloDoGrafico(),
                getRotuloInferior(),
                "teste",
                getTimeseries(),
                getOrientacao(),
                isExibirLegendas(),
                isExibirTooltips(),
                false
        );
        XYPlot plot = (XYPlot) chart.getPlot();

        plot.setDomainCrosshairVisible(isExibirCliqueXY());
        plot.setRangeCrosshairVisible(isExibirCliqueXY());

        PeriodAxis domainAxis = new PeriodAxis(getRotuloInferior());
//        domainAxis.setAutoRangeTimePeriodClass(Day.class);

        int i = getInformacaoFooterCount();
        PeriodAxisLabelInfo[] infoDeBaixo = new PeriodAxisLabelInfo[i];
        i = 0;
        if (isExibirNumeroDoDiaNoMes()) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d"));
        }
        if (isExibirDiaDaSemana()) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("E"), new RectangleInsets(2, 2, 2, 2), new Font("SansSerif", Font.BOLD, 10), Color.blue, false, new BasicStroke(0.0f), Color.lightGray);
        }
        if (isExibirMes()) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM"));
        }
        if (isExibirAno()) {
            infoDeBaixo[i++] = new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("YYYY"));
        }
        domainAxis.setLabelInfo(infoDeBaixo);
        plot.setDomainAxis(domainAxis);
        ChartUtilities.applyCurrentTheme(chart);
        return chart;
    }

}

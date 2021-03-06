/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import br.com.edsonmoretti.jgrafico.grupos.JGraficoGrupo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Edson Moretti
 */
public class JGraficoBarra extends JGrafico {

    private final DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    private String descricaoLateralEsquerda;
    private String descricaoInferior;
    private PlotOrientation orientacao = PlotOrientation.VERTICAL;
    private JGraficoTipoDimensao tipoDimensao = JGraficoTipoDimensao._2D;

    public JGraficoBarra(String titulo, JGraficoTipoDimensao tipo) {
        this(titulo);
        tipoDimensao = tipo;
    }

    public JGraficoBarra(String titulo) {
        super(titulo);
    }

    public void adicionar(JGraficoGrupo grupo) {
        for (String descricaoDoDado : grupo.keySet()) {
            dataSet.addValue(grupo.get(descricaoDoDado), grupo.getTitulo(), descricaoDoDado);
        }
    }

    public void limparDados() {
        dataSet.clear();
    }

    public void setOrientacao(PlotOrientation orientacao) {
        this.orientacao = orientacao;
    }

    public PlotOrientation getOrientacao() {
        return orientacao;
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart c;
        if (tipoDimensao == JGraficoTipoDimensao._2D) {
            c = ChartFactory.createBarChart(
                    getTituloDoGrafico(),
                    descricaoInferior,
                    descricaoLateralEsquerda,
                    dataSet,
                    orientacao,
                    isExibirLegendas(),
                    isExibirTooltips(),
                    false
            );
        } else {
            c = ChartFactory.createBarChart3D(
                    getTituloDoGrafico(),
                    descricaoInferior,
                    descricaoLateralEsquerda,
                    dataSet,
                    orientacao,
                    isExibirLegendas(),
                    isExibirTooltips(),
                    false
            );

        }
        return c;
    }

    private JPanel createDemoPanel() {
        JFreeChart chart = criarGrafico();
        return new ChartPanel(chart);
    }

    public String getDescricaoLateralEsquerda() {
        return descricaoLateralEsquerda;
    }

    public void setDescricaoLateralEsquerda(String descricaoLateralEsquerda) {
        this.descricaoLateralEsquerda = descricaoLateralEsquerda;
    }

    public void setScore(String descricaoLateralEsquerda) {
        this.descricaoLateralEsquerda = descricaoLateralEsquerda;
    }

    public String getDescricaoInferior() {
        return descricaoInferior;
    }

    public void setDescricaoInferior(String descricaoInferior) {
        this.descricaoInferior = descricaoInferior;
    }

    public void setCategoria(String descricaoInferior) {
        this.descricaoInferior = descricaoInferior;
    }

    public DefaultCategoryDataset getDataSet() {
        return dataSet;
    }

    @Override
    public void setVisible(boolean bln) {
        if (dataSet.getRowCount() <= 0) {
            try {
                throw new JGraficoException("Nenhum dado inserido. Use o metodo adicionarDado;");
            } catch (JGraficoException ex) {
                Logger.getLogger(JGraficoBarra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setContentPane(createDemoPanel());
        super.setVisible(bln); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Edson Moretti
 */
public final class JGraficoPizza extends JGrafico {

    private final DefaultPieDataset dados = new DefaultPieDataset();

    public JGraficoPizza(String titulo) {
        super(titulo);
        setSize(500, 500);
    }

    public void adicionarDado(String descricao, Number valor) {
        dados.setValue(descricao, valor);
    }

    public void limparDados() {
        dados.clear();
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart c = ChartFactory.createPieChart(getTituloDoGrafico(),
                dados,
                isExibirLegendas(),
                isExibirTooltips(),
                false
        );
        return c;
    }

    private JPanel createDemoPanel() {
        JFreeChart chart = criarGrafico();
        return new ChartPanel(chart);
    }

    @Override
    public void setVisible(boolean bln) {
        if (dados.getItemCount() <= 0) {
            try {
                throw new JGraficoException("Nenhum dado inserido. Use o metodo adicionarDado;");
            } catch (JGraficoException ex) {
                Logger.getLogger(JGraficoPizza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setContentPane(createDemoPanel());
        super.setVisible(bln); //To change body of generated methods, choose Tools | Templates.
    }

}

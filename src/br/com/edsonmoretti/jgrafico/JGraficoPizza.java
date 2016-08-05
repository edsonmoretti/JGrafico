/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Edson Moretti
 */
public final class JGraficoPizza extends JGrafico {

    private final DefaultPieDataset dados = new DefaultPieDataset();
    private boolean girar;
    private Rotation direcao = Rotation.CLOCKWISE;
    private float foregroundAlpha = 1.0f;
    private final HashMap<String, Double> oqueDestacarDaPizza = new HashMap<>();
    private JGraficoTipoDimensao tipo = JGraficoTipoDimensao._2D;

    public JGraficoPizza(String titulo, JGraficoTipoDimensao tipoDimensao) {
        this(titulo);
        this.tipo = tipoDimensao;
    }

    public JGraficoPizza(String titulo) {
        super(titulo);
        setSize(500, 500);
    }

    public void adicionarDadoEDestacar(String descricao, Number valor, Double percentualDaDistanciaDoCentro) {
        adicionarDado(descricao, valor);
        adicionarDestaqueDoGraficoPizza(descricao, percentualDaDistanciaDoCentro);

    }

    public void adicionarDado(String descricao, Number valor) {
        dados.setValue(descricao, valor);
    }

    public void limparDados() {
        dados.clear();
    }

    @Override
    public JFreeChart criarGrafico() {
        JFreeChart c;
        if (tipo == JGraficoTipoDimensao._3D) {
            c = ChartFactory.createPieChart3D(getTituloDoGrafico(),
                    dados,
                    isExibirLegendas(),
                    isExibirTooltips(),
                    false
            );
        } else {
            c = ChartFactory.createPieChart(getTituloDoGrafico(),
                    dados,
                    isExibirLegendas(),
                    isExibirTooltips(),
                    false
            );
        }
        PiePlot plot = (PiePlot) c.getPlot();
        if (girar) {
            plot.setDirection(direcao);
            plot.setForegroundAlpha(foregroundAlpha);
            final Rotator rotator = new Rotator(plot);
            rotator.start();
        }
        if (!oqueDestacarDaPizza.isEmpty()) {
            for (String descricao : oqueDestacarDaPizza.keySet()) {
                plot.setExplodePercent(descricao, oqueDestacarDaPizza.get(descricao));
            }
        }
        return c;
    }

    public void adicionarDestaqueDoGraficoPizza(String descricaoDoDado, double percentualDaDistanciaDoCentro) {
        oqueDestacarDaPizza.put(descricaoDoDado, percentualDaDistanciaDoCentro);
    }

    public void removeDestaqueDoGraficoPizza(String descricaoDoDado) {
        oqueDestacarDaPizza.remove(descricaoDoDado);
    }

    public void limparDestaquesDoGraficoPizza() {
        oqueDestacarDaPizza.clear();
    }

    public void setGirar(boolean girar, Rotation direcao, float foregroundAlpha) {
        setGirar(girar);
        this.direcao = direcao;
        this.foregroundAlpha = foregroundAlpha;
    }

    public void setGirar(boolean girar) {
        this.girar = girar;
    }

    public void setRotacionar(boolean girar) {
        this.girar = girar;
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
        setContentPane(criarJPanel());
        super.setVisible(bln); //To change body of generated methods, choose Tools | Templates.
    }

}

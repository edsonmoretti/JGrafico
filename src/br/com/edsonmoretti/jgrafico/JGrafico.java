/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Edson Moretti
 */
public class JGrafico extends ApplicationFrame {

    private String tituloDoGrafico;
    private boolean exibirLegendas;
    private boolean exibirTooltips;

    public JGrafico(String titulo) {
        super(titulo);
        setSize(500, 500);
    }

    public void setTituloDoGrafico(String titulo) {
        this.tituloDoGrafico = titulo;
    }

    public JPanel criarJPanel() {
        JFreeChart chart = criarGrafico();
        return new ChartPanel(chart);
    }

    public JFreeChart criarGrafico() {
        try {
            throw new JGraficoException("Metodo privado apenas para assinatura. Metodo criar gráfico deve ser substituido abaixo da superclass");
        } catch (JGraficoException ex) {
            Logger.getLogger(JGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void salvarComoPNG(File f, int largura, int altura) throws IOException {
        ChartUtilities.saveChartAsPNG(f, criarGrafico(), largura == 0 ? getSize().width : largura, altura == 0 ? getSize().height : altura);
    }

    public void salvarComoJPEG(File f, int largura, int altura) throws IOException {
        ChartUtilities.saveChartAsJPEG(f, criarGrafico(), largura == 0 ? getSize().width : largura, altura == 0 ? getSize().height : altura);
    }

    public BufferedImage criarBufferedImage(int largura, int altura) {
        return criarGrafico().createBufferedImage(largura == 0 ? getSize().width : largura, altura == 0 ? getSize().height : altura);
    }

    public ImageIcon criarImageIcon(int largura, int altura) {
        return new ImageIcon(criarBufferedImage(largura, altura));
    }

    public Image criarImage(int largura, int altura) {
        return criarImageIcon(largura, altura).getImage();
    }

    public void setTamanho(int width, int height) {
        super.setSize(width, height); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isExibirLegendas() {
        return exibirLegendas;
    }

    public void setExibirLegendas(boolean exibirLegendas) {
        this.exibirLegendas = exibirLegendas;
    }

    public boolean isExibirTooltips() {
        return exibirTooltips;
    }

    public String getTituloDoGrafico() {
        return tituloDoGrafico == null ? getTitle() : tituloDoGrafico;
    }

    public void setExibirTooltips(boolean exibirTooltips) {
        this.exibirTooltips = exibirTooltips;
    }

    public void exibirLegendas(boolean exibirLegendas) {
        this.exibirLegendas = exibirLegendas;
    }

    public void exibirTooltip(boolean exibirTooltips) {
        this.exibirTooltips = exibirTooltips;
    }

    public void setIcone(Image image) {
        super.setIconImage(image); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIcon(Image image) {
        super.setIconImage(image); //To change body of generated methods, choose Tools | Templates.
    }

    public void setImageIcon(Image image) {
        super.setIconImage(image); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVisible(boolean b) {
        JDialog j = new JDialog((Frame) null, getTitle(), true);
        j.setResizable(isResizable());
        j.setSize(getSize());
        j.setPreferredSize(getPreferredSize());
        j.add(criarJPanel());
        j.setLocationRelativeTo(null);
        j.setIconImage(getIconImage());
        j.setVisible(true);
    }

}

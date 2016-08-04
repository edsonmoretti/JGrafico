/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.jgrafico;

import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.Timer;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;

/**
 *
 * @author Edson
 */
public class Rotator extends Timer implements ActionListener {

    /**
     * The plot.
     */
    private PiePlot plot;

    /**
     * The angle.
     */
    private int angle = 270;

    /**
     * Constructor.
     *
     * @param plot the plot.
     */
    Rotator(final PiePlot plot) {
        super(100, null);
        this.plot = plot;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        this.plot.setStartAngle(this.angle);
        this.angle = this.angle + 1;
        if (this.angle == 360) {
            this.angle = 0;
        }
    }

}

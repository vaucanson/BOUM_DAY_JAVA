/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame.popup;

import entity.Model;
import java.awt.GridLayout;
import view.frame.popup.StylePopUpFrame;
import view.panel.popup.LaunchBatchWorkshopPopUpPanel;

/**
 *
 * @author badaroux
 */
public class LaunchBatchWorkshopPopUpFrame extends StylePopUpFrame {

    private LaunchBatchWorkshopPopUpPanel lbw;
    private static LaunchBatchWorkshopPopUpFrame instance;
    private Model model;
    
    public LaunchBatchWorkshopPopUpFrame(Model model) 
    {
        super();
        setModel(model);

        lbw = new LaunchBatchWorkshopPopUpPanel(this);
        this.add(lbw);
        this.setBounds(700, 300, 500, 400);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    
    
    public static LaunchBatchWorkshopPopUpFrame getInstance()
    {
        if (instance == null || !instance.isVisible())
        {
            synchronized (LaunchBatchWorkshopPopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new LaunchBatchWorkshopPopUpFrame();
            }
        } 
        return instance;
    }

    private LaunchBatchWorkshopPopUpFrame() {
        new LaunchBatchWorkshopPopUpPanel(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


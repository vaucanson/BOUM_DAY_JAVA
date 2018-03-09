/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;

import entity.Batch;
import java.awt.GridLayout;
import javax.swing.JPanel;
import view.panel.HomePanel;


public class MainFrame extends javax.swing.JFrame {

    private JPanel mainPanel;
    private Batch currentBatch;


    
    
    public MainFrame() {
        initComponents();
        setLayout(new GridLayout(1, 1, 10, 0));
        mainPanel = new HomePanel(this);
        add(mainPanel);
    }

    public void changePanel(JPanel panel)
    {
        mainPanel = panel;
        this.setContentPane(mainPanel);
        this.validate();  
    }
    
    
    public Batch getCurrentBatch() {
    return currentBatch;
}

    public void setCurrentBatch(Batch batch) {
        this.currentBatch = batch;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainFrame");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("MainFrame"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

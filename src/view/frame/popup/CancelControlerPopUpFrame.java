/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame.popup;

import entity.Batch;
import entity.Press;
import view.panel.popup.CancelControlerPopUpPanel;

public class CancelControlerPopUpFrame extends StylePopUpFrame {

   private CancelControlerPopUpPanel ccpup = new CancelControlerPopUpPanel(this);
   private static CancelControlerPopUpFrame instance;
   private Press press;

   
    private CancelControlerPopUpFrame(Press p) {
       super();
       add(ccpup);
       press = p;
    }
 
    public static CancelControlerPopUpFrame getInstance(Press p)
    {
        
        if (instance == null || !instance.isVisible())
        {
            synchronized (CancelControlerPopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new CancelControlerPopUpFrame(p);
            }
        } 
        return instance;
    }
    
    public  Press getPress() {
    return press;
    }

    public void setPress(Press p) {
        this.press = p;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

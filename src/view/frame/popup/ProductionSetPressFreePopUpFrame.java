package view.frame.popup;

import java.awt.GridLayout;
import view.panel.popup.ProductionSetPressFreePopUpPanel;

/**
 *
 * @author mattar
 */
public class ProductionSetPressFreePopUpFrame extends StylePopUpFrame {

    ProductionSetPressFreePopUpPanel fpppu = new ProductionSetPressFreePopUpPanel(this);
    private static ProductionSetPressFreePopUpFrame instance;
    
    private ProductionSetPressFreePopUpFrame() {
        super();
        fpppu = new ProductionSetPressFreePopUpPanel(this);
        this.add(fpppu);
       
    }

    public static ProductionSetPressFreePopUpFrame getInstance()
    {
        if (instance == null || !instance.isVisible())
        {
            synchronized (ProductionSetPressFreePopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new ProductionSetPressFreePopUpFrame();
            }
        } 
        return instance;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

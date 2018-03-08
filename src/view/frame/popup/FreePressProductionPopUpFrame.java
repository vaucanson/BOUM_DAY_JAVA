package view.frame.popup;

import java.awt.GridLayout;
import view.panel.popup.FreePressProductionPopUpPanel;

/**
 *
 * @author mattar
 */
public class FreePressProductionPopUpFrame extends StylePopUpFrame {

    FreePressProductionPopUpPanel fpppu = new FreePressProductionPopUpPanel(this);
    private static FreePressProductionPopUpFrame instance;
    
    private FreePressProductionPopUpFrame() {
        super();
        fpppu = new FreePressProductionPopUpPanel(this);
        this.add(fpppu);
       
    }

    public static FreePressProductionPopUpFrame getInstance()
    {
        if (instance == null || !instance.isVisible())
        {
            synchronized (FreePressProductionPopUpFrame.class)
            {
                if (instance == null || !instance.isVisible())
                    instance = new FreePressProductionPopUpFrame();
            }
        } 
        return instance;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

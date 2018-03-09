/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

/**
 *
 * @author boilleau
 */
public class ApplicationPanel extends StylePanel {

    /**
     * Creates new form ApplicationHeadOfPanel
     */
    public ApplicationPanel() {
        initComponents();
        this.initTabs();
    }
    
    /**
     * Initialisation de tous les onglets avec les panels qui vont dedans
     */
    private void initTabs()
    {
        this.panelTabbed.addTab("Gestion des modèles", new ApplicationModelManagementPanel());
        this.panelTabbed.addTab("Gestion des presses", new ApplicationPressManagementPanel());
        this.panelTabbed.addTab("Gestion des purges", new ApplicationPurgeManagementPanel());
        this.panelTabbed.addTab("Gestion des seuils", new ApplicationLimitManagementPanel());
        this.panelTabbed.addTab("Gestion des intervalles de tolérance", new ApplicationToleranceManagementPanel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabbed = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        panelTabbed.getAccessibleContext().setAccessibleName("Gestion des Modèles");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane panelTabbed;
    // End of variables declaration//GEN-END:variables
}
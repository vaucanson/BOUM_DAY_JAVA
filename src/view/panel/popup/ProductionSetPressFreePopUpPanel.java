
package view.panel.popup;

import entity.Batch;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.PressNonBusyTableModel;
import view.panel.StylePanel;

/**
 *
 * @author badaroux
 */
public class ProductionSetPressFreePopUpPanel extends StylePanel {

    private JFrame parent;
    private PressNonBusyTableModel fptm = new PressNonBusyTableModel();

    public ProductionSetPressFreePopUpPanel(JFrame frame) {
        initComponents();
        this.setVisible(true);
        this.parent = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePressBatch = new javax.swing.JTable();
        buttonValidate = new javax.swing.JButton();
        labTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        tablePressBatch.setModel(fptm);
        jScrollPane1.setViewportView(tablePressBatch);

        buttonValidate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonValidate.setText("Désaffecter un lot");
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitle.setText("DESAFFECTACTION DES LOTS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(buttonValidate, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
        ConfirmStart();
    }//GEN-LAST:event_buttonValidateActionPerformed
    
    /**
     * cette méthode stocke d'abord la celulle selectionné au travers d'une ligne et d'une colonne. Nous vérifions que cette opération est bien effectuée avant de 
     * demander au responsable de production s'il veut toujours libérer la presse. S'il dit oui, le lot sera passé en état 3.
     */
    private void ConfirmStart() {
        int row = tablePressBatch.getSelectedRow();
        int column = tablePressBatch.getSelectedColumn();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Merci de selectionner une cellule lot", "Selection de lot", JOptionPane.OK_OPTION);
        } else {

            System.out.println(row);
            if (JOptionPane.showConfirmDialog(null, "Libérer la presse ?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

             
               if (tablePressBatch.getValueAt(row, column).getClass() == Batch.class)
               {
                   fptm.launch((Batch) tablePressBatch.getValueAt(row, column));
                    JOptionPane.showMessageDialog(null, "La presse a bien été libérée");
                    fptm.fireTableDataChanged();
                } 
                    else 
                {
                    fptm.launch((Batch) tablePressBatch.getValueAt(row, column+1));
                    JOptionPane.showMessageDialog(null, "La presse a bien été libérée");
                    fptm.fireTableDataChanged();
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonValidate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labTitle;
    private javax.swing.JTable tablePressBatch;
    // End of variables declaration//GEN-END:variables
}

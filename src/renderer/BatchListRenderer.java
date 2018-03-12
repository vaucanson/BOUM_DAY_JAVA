package renderer;

import entity.Batch;
import entity.Press;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author mattar
 */
public class BatchListRenderer implements ListCellRenderer<Batch> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Batch> list, Batch batch, int index, boolean isSelected, boolean cellHasFocus) {
               
        JLabel lab = new JLabel("Lot n°" + batch.getId() + " || Modèle : " + batch.getModel().getName() + " || Quantité : " + batch.getPiecesNumber());
        lab.setOpaque(true);
        
        list.setBorder(null);
        
        
        if (isSelected)
       {
           lab.setForeground(Color.red);
       }
        
        return lab;
    }

    
}

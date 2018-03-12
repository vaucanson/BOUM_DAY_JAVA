package renderer;

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
public class PressListRenderer implements ListCellRenderer<Press> {



    @Override
    public Component getListCellRendererComponent(JList<? extends Press> list, Press press, int index, boolean isSelected, boolean cellHasFocus) {
       
        
        JLabel lab = new JLabel("Presse n°" + Integer.toString(press.getId()));
        lab.setOpaque(true);
       
        if (isSelected)
       {
           lab.setForeground(Color.red);
       }
        
        return lab;
    }

    
}

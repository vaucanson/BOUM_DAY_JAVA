package tool;

import javax.swing.JOptionPane;

/**
 * message type : le premier chiffre représente le type de popup (1 = message simple, 2 = question)
 * le deuxième chiffre représente la gravité, de 1 à 5.
 * 
 */
public abstract class MessageTool 
{
    public static void popup(String title, String message, int messageType)
    {
        switch (messageType)
        {
            case 11: JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null);
                break;
            case 12: JOptionPane.showMessageDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null);
                break;
            case 13: JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 14: JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, null);
                break;
            case 15: JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE, null);
                break;
            case 21: JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                break;
            case 22: JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
                break;
            case 23: JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 24: JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                break;
            case 25: JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null);
                break;
            default: JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null);
        }
        
    }
}

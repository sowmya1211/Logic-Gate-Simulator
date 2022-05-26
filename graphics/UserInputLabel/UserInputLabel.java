package graphics.UserInputLabel;

import java.awt.*;
import javax.swing.JTextField;

public class UserInputLabel extends JTextField
{
    public UserInputLabel()
    {
       this.setBounds(270, 45, 100, 25);
       this.setFont(new Font("Consolas", Font.BOLD, 15));
       this.setForeground(new Color(125, 125, 125));
       this.setBackground(Color.WHITE);
       this.setCaretColor(Color.WHITE);
       this.setOpaque(true);
       this.setHorizontalAlignment(JTextField.CENTER);
       this.setEditable(true);
       this.setVisible(false);    
    } 
}

package graphics.FirstScreenButton;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.border.Border;
public class NANDbutton extends JButton
{
 public NANDbutton()
 {
    this.setBounds(100, 200, 150, 50);
    this.setText("NAND");  

    this.setFocusable(false);
	this.setHorizontalTextPosition(JButton.LEFT);
	this.setVerticalTextPosition(JButton.BOTTOM);
	this.setFont(new Font("Times New Roman",Font.BOLD,25));
	this.setIconTextGap(-15);
	this.setForeground(Color.BLACK);
	this.setBackground(Color.lightGray);

    Border border=BorderFactory.createEtchedBorder();
	this.setBorder(border);
 }    
}

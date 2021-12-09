package graphics.FirstScreenButton;
import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.border.Border;
public class ANDbutton extends JButton
{
 public ANDbutton()
 {
    this.setBounds(100, 100, 150, 50);
    this.setText("AND");  

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

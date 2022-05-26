package graphics.PinButtons;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Pin extends JButton
{
 public Pin()
 { 
    this.setFocusable(false);
	this.setHorizontalTextPosition(JButton.CENTER);
	this.setVerticalTextPosition(JButton.CENTER);
	this.setFont(new Font("Times New Roman",Font.BOLD,10));
	this.setIconTextGap(-15);
	this.setForeground(Color.BLACK);
	this.setBackground(Color.white);

    Border border=BorderFactory.createEmptyBorder();
	this.setBorder(border);
 }    
}
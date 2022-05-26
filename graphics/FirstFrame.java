package graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import graphics.FirstScreenButton.*;

public class FirstFrame extends JFrame implements ActionListener
{
    JLabel titleLabel; //Label for the title
	//Creating 6 different objects for FirstScreenButton class for 6 different gates
    FirstScreenButton andbutton = new FirstScreenButton();
	FirstScreenButton orbutton = new FirstScreenButton();
	FirstScreenButton notbutton = new FirstScreenButton();
	FirstScreenButton nandbutton = new FirstScreenButton();
	FirstScreenButton norbutton = new FirstScreenButton();
	FirstScreenButton exorbutton = new FirstScreenButton();

    public FirstFrame()
    {	
		//Setting specifications for the frame
        this.setTitle("Logic Gate Simulator"); //Sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //To exit from application on clicking X
        this.setResizable(false); //To prevent frame from being resized
        this.setSize(750,500); 
        this.setVisible(true); //To make frame visible
        this.getContentPane().setBackground(new Color(0x123456)); 
		this.setLayout(null);

		//Setting specifications for the title label
		titleLabel = new JLabel(); 
		titleLabel.setText("CHOOSE A GATE"); 
		titleLabel.setHorizontalTextPosition(JLabel.CENTER); 
		titleLabel.setVerticalTextPosition(JLabel.TOP); 
		titleLabel.setForeground(Color.BLACK); 
		titleLabel.setFont(new Font("Times New Roman",Font.BOLD,20)); 
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		titleLabel.setOpaque(true);
		titleLabel.setVerticalAlignment(JLabel.CENTER); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER); 
		titleLabel.setBounds(200, 30, 350, 30); 

		//Setting text and position for the buttons
		andbutton.setBounds(100, 100, 150, 50);
        andbutton.setText("AND");
		orbutton.setBounds(300, 100, 150, 50);
        orbutton.setText("OR");
		notbutton.setBounds(500, 100, 150, 50);
        notbutton.setText("NOT");  
		nandbutton.setBounds(100, 200, 150, 50);
        nandbutton.setText("NAND");
		norbutton.setBounds(300, 200, 150, 50);
		norbutton.setText("NOR"); 
		exorbutton.setBounds(500, 200, 150, 50);
		exorbutton.setText("EX-OR");

		//Adding action listeners to the buttons- What action must be taken if button is clicked
		andbutton.addActionListener(this);
		orbutton.addActionListener(this);
		notbutton.addActionListener(this);
		nandbutton.addActionListener(this);
		norbutton.addActionListener(this);
		exorbutton.addActionListener(this);
		
		//Adding all components to the frame
		this.add(titleLabel);
		this.add(andbutton);
        this.add(orbutton);
		this.add(notbutton);
		this.add(nandbutton);
		this.add(norbutton);
		this.add(exorbutton);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
    {
		if(e.getSource()==andbutton) 
        {
			andbutton.setEnabled(false);
			this.setVisible(false);
			new NewWindow("AND");  //Invoking NewWindow if AND is clicked
		}	
        if(e.getSource()==orbutton) 
        {
			orbutton.setEnabled(false);
			this.setVisible(false);
			new NewWindow("OR");  //Invoking NewWindow if OR is clicked
		}	
		if(e.getSource()==notbutton) 
        {
			notbutton.setEnabled(false);
			this.setVisible(false);
			new NewNOTWindow("NOT");  //Invoking NewNOTWindow if NOT is clicked
		}	
		if(e.getSource()==nandbutton) 
        {
			nandbutton.setEnabled(false);
			this.setVisible(false);
			new NewWindow("NAND");   //Invoking NewWindow if NAND is clicked
		}
		if(e.getSource()==norbutton) 
        {
			norbutton.setEnabled(false);
			this.setVisible(false);
			new NewWindow("NOR");   //Invoking NewWindow if NOR is clicked
		}
		if(e.getSource()==exorbutton) 
        {
			exorbutton.setEnabled(false);
			this.setVisible(false);
			new NewWindow("EXOR");   //Invoking NewWindow if EXOR is clicked
		}
	}    
}


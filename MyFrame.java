package graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.Border;
import graphics.FirstScreenButton.*;
public class MyFrame extends JFrame implements ActionListener
{
    JLabel titleLabel;
	/*JButton ANDbutton;
    JButton ORbutton,NOTbutton;*/
  //JFrame frame = new JFrame();//creates a frame

    ANDbutton andbutton = new ANDbutton();
	ORbutton orbutton = new ORbutton();
	NOTbutton notbutton = new NOTbutton();
	NANDbutton nandbutton = new NANDbutton();
	NORbutton norbutton = new NORbutton();
	EXORbutton exorbutton = new EXORbutton();
    public MyFrame()
    {	
		//Border border = BorderFactory.createLineBorder(Color.green,3);
        this.setTitle("Logic Gate Simulator"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
        this.setResizable(false); //prevent frame from being resized
        this.setSize(420,420); //sets the x-dimension, and y-dimension of frame
        this.setVisible(true); //make frame visible
        
        ImageIcon image = new ImageIcon("img.jpg"); //create an ImageIcon
        this.setIconImage(image.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0x123456)); //change color of background
		
		titleLabel = new JLabel(); //create a label
		titleLabel.setText("CHOOSE A GATE"); //set text of label
		titleLabel.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
		titleLabel.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
		titleLabel.setForeground(new Color(000000)); //set font color of text
		titleLabel.setFont(new Font("Times New Roman",Font.PLAIN,20)); //set font of text
		//titleLabelsetBackground(Color.black); //set background color
		titleLabel.setOpaque(false);//display background color
		//titleLabelsetBorder(border); //sets border of label (not image+text)
		titleLabel.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
		titleLabel.setBounds(150, 65, 250, 20); //set x,y position within frame as well as dimension

		andbutton.addActionListener(this);
		orbutton.addActionListener(this);
		notbutton.addActionListener(this);
		nandbutton.addActionListener(this);
		norbutton.addActionListener(this);
		exorbutton.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(750,500);
		this.setVisible(true);
		this.add(andbutton);
        this.add(orbutton);
		this.add(notbutton);
		this.add(nandbutton);
		this.add(norbutton);
		this.add(exorbutton);
		this.add(titleLabel);
		//this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
    {
		if(e.getSource()==andbutton) 
        {
			System.out.println("Choice 1- AND implementation");
			andbutton.setEnabled(false);
			System.out.println("AND chosen");
			NewWindow window = new NewWindow();
		}	
        if(e.getSource()==orbutton) 
        {
			System.out.println("Choice 2- OR implementation");
			orbutton.setEnabled(false);
			System.out.println("OR chosen");
		}	
		if(e.getSource()==notbutton) 
        {
			System.out.println("Choice 3- NOT implementation");
			notbutton.setEnabled(false);
			System.out.println("NOT chosen");
		}	
		if(e.getSource()==nandbutton) 
        {
			System.out.println("Choice 4- NAND implementation");
			nandbutton.setEnabled(false);
			System.out.println("NAND chosen");
		}
		if(e.getSource()==norbutton) 
        {
			System.out.println("Choice 5- NOR implementation");
			norbutton.setEnabled(false);
			System.out.println("NOR chosen");
		}
		if(e.getSource()==exorbutton) 
        {
			System.out.println("Choice 6- EXOR implementation");
			exorbutton.setEnabled(false);
			System.out.println("EXOR chosen");
		}
	}    
}


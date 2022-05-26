package graphics;

import exceptions.*;
import gates.*;
import graphics.PinButtons.*;
import graphics.UserInputLabel.*;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewWindow extends JFrame implements ActionListener 
{
    JLabel opLabel = new JLabel();    //Label that is shown in the top- Tells what the user must do
    JLabel ipLabel[] = new JLabel[8]; //Label that is shown in the sides- Tells what the user has given as input
    JLabel IC;     //Label that has main IC body
    
    Pin pins[] = new Pin[14];   //Buttons for 14 pins 
    UserInputLabel userip1 = new UserInputLabel(); //Text field to get input value 1 for gates
    UserInputLabel userip2 = new UserInputLabel(); //Text field to get input value 2 for gates
    JButton submit = new JButton(); //Button to submit input values
    JButton back = new JButton();  //Back button
   
    JPanel topPanel = new JPanel();   //Top panel - holds the opLabel, UserInputLabels and submit button
    JPanel rightPanel = new JPanel(); //Right panel- holds the ipLabels and back button
    JPanel ICpanel = new JPanel();    //Left panel- holds the IC label

    String message; //Holds what gate button has been clicked in first frame
    ArrayList<String> prompts = new ArrayList<String>(); //Stores the opLabel contents
    Map<String, String> map = new HashMap<String, String>(); //To store gate names with their corresponding ICnos
    static int flag;  //To control no of times the pin buttons are clicked
    static int ypos;  //Stores y position of ipLabel
    static int prev;   //Stores pin button value previously clicked by the user 

    Gates<String> gatesObj; //Creating object for abstract Gates under package gates
    //Variables to be passed as arguments to corresponding derived class constructors of Gates
    int vcc, gnd, inputPin1, inputPin2, outputPin; 
    String inputVal1, inputVal2;
    
    public NewWindow(String msg) 
    {
        //Initialising values for static variables flag and ypos
        flag = 0;
        ypos = 80;

        //Storing gate names with their corresponding ICnos using maps
        map.put("AND", "IC7408");
        map.put("OR", "IC7432");
        map.put("NAND", "IC7400");
        map.put("NOR", "IC7402");
        map.put("EXOR", "IC7486");

        //Setting specifications for the window
        this.message = msg;
        this.setTitle("Logic Gate Simulator - " + message); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(false); 
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x123456)); 
        this.setSize(700, 500);
        this.setVisible(true);

        //Setting specifications for the top panel
        topPanel.setBackground(new Color(128, 128, 128));
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 700, 100);
        
        //Setting specifications for the right panel
        rightPanel.setLayout(null);
        rightPanel.setBounds(350, 100, 350, 400);
        rightPanel.setBackground(new Color(255, 255, 245));
        ICpanel.setOpaque(true);
        ICpanel.setVisible(true);

        //Setting specifications for the left panel
        ICpanel.setLayout(null);
        ICpanel.setBounds(0, 100, 350, 400);
        ICpanel.setBackground(new Color(0x123456));
        ICpanel.setOpaque(true);
        ICpanel.setVisible(true);


        //Setting specifications for the ICLabel 
        IC = new JLabel(map.get(message));
        IC.setVerticalAlignment(JLabel.CENTER);
        IC.setHorizontalAlignment(JLabel.CENTER);
        IC.setBounds(120, 80, 110, 205);
        IC.setBackground(new Color(0, 0, 0));
        IC.setForeground(new Color(255, 255, 255));
        IC.setOpaque(true);
        IC.setBorder(BorderFactory.createBevelBorder(ICONIFIED));
        ICpanel.add(IC, Alignment.CENTER);
        
        //Setting specifications and action listeners(action to be done when clicked) for the 14 pins
        int j = 80;
        for (int i = 0; i <= 7; i++) 
        {
            pins[i] = new Pin();
            pins[i].setBounds(90, j, 25, 25);
            pins[i].addActionListener(this);
            String str = Integer.toString(i + 1);
            pins[i].setText(str);
            j = j + 30;
        }
        j = j - 60;
        for (int i = 7; i < 14; i++) 
        {
            pins[i] = new Pin();
            pins[i].setBounds(235, j, 25, 25);
            pins[i].addActionListener(this);
            String str = Integer.toString(i + 1);
            pins[i].setText(str);
            j = j - 30;
        }
        //Adding pin buttons to ICPanel
        for (int i = 0; i < 14; i++) 
        {
            ICpanel.add(pins[i]);
        }

        //Setting prompt messages to be displayed in opLabel in top panel
        prompts.add("GND pin no.");
        prompts.add("VCC pin no.");
        prompts.add("Input pin 1");
        prompts.add("Input pin 2");
        prompts.add("Output pin");
        prompts.add("Input value 1");
        prompts.add("Input value 2");
        //Setting specifications for the opLabel 
        opLabel.setBounds(200, 10, 300, 30);
        opLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        opLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        opLabel.setBackground(Color.WHITE);
        opLabel.setOpaque(true);
        opLabel.setVerticalAlignment(JLabel.CENTER);
        opLabel.setHorizontalAlignment(JLabel.CENTER);

        //Setting specifications for submit button
        submit.setBounds(370, 45, 75, 25);
        submit.setText("SUBMIT");
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setVisible(false);

        //Adding opLabel, UserInputLabels and submit button to top panel
        topPanel.add(opLabel);
        topPanel.add(userip1);
        topPanel.add(userip2);
        topPanel.add(submit);

        //Setting specifications for the ipLabels and adding it to right panel
        for (int m = 0; m <= 7; m++) 
        {
            ipLabel[m] = new JLabel();
            ipLabel[m].setBounds(100, 80, 270, 20);
            ipLabel[m].setHorizontalAlignment(SwingConstants.CENTER);
            ipLabel[m].setVerticalAlignment(SwingConstants.CENTER);
            ipLabel[m].setBackground(new Color(135, 135, 135));
            ipLabel[m].setForeground(Color.WHITE);
            ipLabel[m].setOpaque(true);
            ipLabel[m].setVisible(false);
            rightPanel.add(ipLabel[m]);
        }

        //Setting specifications for back button and adding it to right panel
        back.setText("BACK");
        back.setBounds(220, 300, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.addActionListener(this);
        rightPanel.add(back);

        //Adding all the panels to the frame/window
        this.add(topPanel);
        this.add(ICpanel);
        this.add(rightPanel);

        times();  //Determines flow of control

    }

    //Function that changes flag, prev and determines flow of control
    public void times() 
    {
        //To input pins from user
        switch (flag) 
        {
            case 1:
                gnd = prev;
                break;
            case 2:
                vcc = prev;
                break;
            case 3:
                inputPin1 = prev;
                break;
            case 4:
                inputPin2 = prev;
                break;
            case 5:
                outputPin = prev;
                break;
        }
        //After user clicks all 5 pins
        if (flag == 5)  
        {
            //To disable all pin buttons
            for (int i = 0; i < 14; i++) 
            {
                pins[i].setEnabled(false);
            }
            //To get input values from user using text field
            opLabel.setText("Enter " + prompts.get(flag));
            userip1.setVisible(true);
            submit.setVisible(true);
            submit.addActionListener(this);
        } 
        //After user enters all values- To display output now
        else if (flag == 7) 
        {
            //Setting specifications for displaying output
            ipLabel[7].setBounds(90, ypos + 30, 170, 60);
            ipLabel[7].setBackground(new Color(135, 135, 135));
            ipLabel[7].setHorizontalAlignment(SwingConstants.CENTER);
            ipLabel[7].setVerticalAlignment(SwingConstants.CENTER);
            ipLabel[7].setBackground(Color.WHITE);
            ipLabel[7].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            
            //Invoking the corresponding derived class constructor depending on what button user had clicked in first frame
            //Invoking using base class reference
            if (this.message == "AND")
                gatesObj = new AND<String>(vcc, gnd, inputPin1, inputPin2, outputPin, inputVal1, inputVal2);
            else if (this.message == "OR")
                gatesObj = new OR<String>(vcc, gnd, inputPin1, inputPin2, outputPin, inputVal1, inputVal2);
            else if (this.message == "NAND")
                gatesObj = new NAND<String>(vcc, gnd, inputPin1, inputPin2, outputPin, inputVal1, inputVal2);
            else if (this.message == "NOR")
                gatesObj = new NOR<String>(vcc, gnd, inputPin1, inputPin2, outputPin, inputVal1, inputVal2);
            else if (this.message == "EXOR")
                gatesObj = new EXOR<String>(vcc, gnd, inputPin1, inputPin2, outputPin, inputVal1, inputVal2);
    
            int f_vccgnd = 1; //Flag variable to check if there is an error in VccGndException is thrown or not
            String error;  //To display error message as output if an exception is thrown
            
            //Checking vcc and ground pin numbers clicked by the user 
            try  
            {
                gatesObj.checkVcc_gnd();
            } 
            catch (VccGndException e) //Catching excpetion thrown from checkVcc_gnd()
            {
                String myString = "\n***ERROR***\n"+e.toString()+"\n";
                ipLabel[7].setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
                ipLabel[7].setForeground(Color.RED);
                ipLabel[7].setVisible(true);
                f_vccgnd = 0;
            }
            //If vcc and ground pin numbers are valid
            if (f_vccgnd == 1) 
            {
                error = gatesObj.checkInputPin();
                if (error != null)  //If input pin numbers are invalid
                {
                    String myString = "\n***ERROR***\n"+error+"\n";
                    ipLabel[7].setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
                    ipLabel[7].setForeground(Color.RED);
                    ipLabel[7].setVisible(true);
                } 
                else  //If input pin numbers are valid too
                {
                    error = gatesObj.checkOutputPin();
                    if (error != null)  //If output pin number is invalid
                    {
                        String myString = "\n***ERROR***\n"+error+"\n";
                        ipLabel[7].setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
                        ipLabel[7].setForeground(Color.RED);
                        ipLabel[7].setVisible(true);
                    } 
                    else  //If output pin number is valid too
                    {
                        error = gatesObj.checkInputValues();
                        if (error != null)  //If input values are invalid
                        {
                            String myString = "\n***ERROR***\n"+error+"\n";
                            ipLabel[7].setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
                            ipLabel[7].setForeground(Color.RED);
                            ipLabel[7].setVisible(true);
                        } 
                        else  //If all the inputs are valid- Output is displayed
                        {
                            ipLabel[7].setText("OUTPUT:-  " + gatesObj.assignOutput());
                            ipLabel[7].setForeground(Color.WHITE);
                            ipLabel[7].setForeground(Color.BLACK);
                            ipLabel[7].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                            ipLabel[7].setVisible(true);
                            assignColour(inputVal1, inputPin1);
                            assignColour(inputVal2, inputPin2);
                            assignColour(gatesObj.assignOutput(), outputPin);
                            pins[outputPin - 1].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                        }
                    }
                }
            }
        } 
        else 
        {
            opLabel.setText("Click " + prompts.get(flag));
            ipLabel[flag].setBounds(90, ypos, 170, 20);
            ypos = ypos + 20;
        }
    }

    //Function to change colours of corresponding input pin and output pin buttons if all inputs are valid
    public void assignColour(String x, int i) 
    {
        if (x.equals("1"))
            pins[i - 1].setBackground(Color.GREEN);
        else if (x.equals("X"))
            pins[i - 1].setBackground(Color.GRAY);
        else
            pins[i - 1].setBackground(Color.RED);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //If user clicks pin buttons
        for (int i = 0; i < 14; i++) 
        {
            if (e.getSource() == pins[i]) 
            {
                String str = prompts.get(flag);
                ipLabel[flag].setText(str + ": " + (i + 1));
                ipLabel[flag].setVisible(true);
                flag++;
                prev = (i + 1);
                times();

            }
        }

        //If user clicks submit button
        if (e.getSource() == submit) 
        {
            //If user clicks submit button for the first time- To enter input value 1
            if (flag == 5) 
            {
                inputVal1 = userip1.getText();
                userip1.setVisible(false);
                ipLabel[flag].setText(prompts.get(flag) + ": " + inputVal1);
                ipLabel[flag].setBounds(90, ypos, 170, 20);
                ipLabel[flag].setVisible(true);
                flag++;
                opLabel.setText("Enter " + prompts.get(flag));
                userip2.setVisible(true);
                submit.addActionListener(this);
            } 
            //If user clicks submit button for the first time- To enter input value 2
            else if (flag == 6) 
            {
                inputVal2 = userip2.getText();
                ipLabel[flag].setText(prompts.get(flag) + ": " + inputVal2);
                ipLabel[flag].setBounds(90, ypos, 170, 20);
                ipLabel[flag].setVisible(true);
                opLabel.setVisible(false);
                userip2.setVisible(false);
                submit.setVisible(false);
                flag++;
            }
            times();
        }
    
        //If user clicks back button
        if (e.getSource() == back) 
        {
            this.setVisible(false);
            new FirstFrame();
        }
    }
}
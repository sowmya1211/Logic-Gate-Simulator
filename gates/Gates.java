//Base class of all other gates- Abstract class
package gates;
import exceptions.*;
 
public abstract class Gates<T extends Comparable>
{
    T input1,input2;
    T output;
    int inputPinNo1,inputPinNo2;
    int outputPinNo;
    int VCC, gnd;
     
    //Constructor 1- For AND, OR, NAND, NOR, EX OR   

    public Gates(int VCC, int gnd, int inputPinNo1,int inputPinNo2, int outputPinNo, T input1, T input2)
    {
        this.VCC = VCC;
        this.gnd = gnd;
        this.inputPinNo1 = inputPinNo1;
        this.inputPinNo2 = inputPinNo2;
        this.outputPinNo = outputPinNo;
        this.input1 = input1;
        this.input2 = input2; 
    }
    //Constructor 2- For NOT
    public Gates(int VCC, int gnd, int inputPinNo1, int outputPinNo, T input1)
    {
        this.VCC = VCC;
        this.gnd = gnd;
        this.inputPinNo1 = inputPinNo1;
        this.outputPinNo = outputPinNo;
        this.input1 = input1;
    }

    //Checker Methods
    public void checkVcc_gnd() throws VccGndException 
    {
        try
        {   
            if( VCC != 14 && gnd == 7)
                throw new VccGndException("Wrong VccPin number\n");
            else if( VCC == 14 && gnd != 7)
                throw new VccGndException("Wrong GroundPin number\n");
            else if( VCC != 14 && gnd != 7)
                throw new VccGndException("Wrong GroundPin and VccPin number\n");            
        }
        //Catch block for this exception is in the function where we invoke it
        //As try cannot stand on its own we create an empty finally block
        finally
        {
        }
    }
    public abstract String checkInputPin();
    public abstract String checkOutputPin();

    public String checkInputValues()
    {
        try
        {   
            if( ( input1.compareTo("0")!=0 && input1.compareTo("1")!=0 && input1.compareTo("X")!=0 ) && 
                                 ( input2.compareTo("0")==0 || input2.compareTo("1")==0 || input2.compareTo("X")==0 ) )
                        throw new InputValueException("Wrong Input Value 1\n");
            else if( ( input2.compareTo("0")!=0 && input2.compareTo("1")!=0 && input2.compareTo("X")!=0 ) && 
                        ( input1.compareTo("0")==0 || input1.compareTo("1")==0 || input1.compareTo("X")==0 ) )
                        throw new InputValueException("Wrong Input Value 2\n");  
            else if( ( input1.compareTo("0")!=0 && input1.compareTo("1")!=0 && input1.compareTo("X")!=0 ) && 
                        ( input2.compareTo("0")!=0 && input2.compareTo("1")!=0 || input2.compareTo("X")!=0 ) )
                        throw new InputValueException("Wrong Input Values 1 and 2\n");     
        }  
        catch(InputValueException e)
        {
            return e.toString();
        }
        catch(Exception e) //Generic Exception Catch Handler
        {
            System.out.println("Wrong Input");
        }
        return null;
    }
    
    //Output method
    public abstract String assignOutput();

}

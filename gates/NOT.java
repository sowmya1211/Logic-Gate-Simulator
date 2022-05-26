//NOT gate- Derived class of Gate 
package gates;
import exceptions.*;

public class NOT<T extends Comparable> extends Gates
{
    //Arrays to check Input, Output Pin Combinations
    int inputCombos[] = {0,1,2,1,2,1,2,0,2,1,2,1,2,1,0};
    int outputCombos[] = {0,1,1,2,4,3,9,0,16,4,25,5,36,6,0};

    public NOT(int VCC, int gnd, int inputPinNo1, int outputPinNo, T input1)
    {
        super(VCC, gnd, inputPinNo1, outputPinNo, input1);
    }
    
    //Checker Methods    
    public String checkInputPin()
    {
        try
        {   
            if(inputCombos[inputPinNo1] != 1)
                throw new InputPinException("Wrong InputPin Number\n");    
        }
        catch(InputPinException e)
        {
            return e.toString();
        }
        catch(Exception e) //Generic Exception Catch Handler
        {
            System.out.println("Wrong Input");
        }
        return null;
    }
    public String checkOutputPin()
    {
        try
        {   
            if(inputCombos[outputPinNo]!=2)
                throw new OutputPinException("Wrong OutputPin Number\n");
            else if(outputCombos[outputPinNo]!=((outputCombos[inputPinNo1])*(outputCombos[inputPinNo1])))
                throw new OutputPinException("Wrong OutputPin Number for the given InputPin Number\n");
        }
        catch(OutputPinException e)
        {
            return e.toString();
        }
        catch(Exception e) //Generic Exception Catch Handler
        {
            System.out.println("Wrong Input");
        }
        return null;
    }

    //Method overriden from base class Gates
    public String checkInputValues()
    {
        try
        {   
            if( input1.compareTo("0")!=0 && input1.compareTo("1")!=0 && input1.compareTo("X")!=0 ) 
                throw new InputValueException("Wrong Input Value\n");  
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
    public String assignOutput()
    {
         if(input1.compareTo("X")==0) //Input is a dont care
            output="X"; //Output is a dont care
         else
         {
          if(input1.compareTo("0")==0)
             output=1;
          else if(input1.compareTo("1")==0)
             output=0;   
         }  
         return output.toString();
    }
}




//NAND gate- Derived class of Gate 
package gates;
import exceptions.*;

public class NAND<T extends Comparable> extends Gates
{
    //Arrays to check Input, Output Pin Combinations
    int inputCombos[] = {0,1,1,3,1,1,3,0,3,1,1,3,1,1,0};
    int outputCombos[] = {0,1,1,1,2,2,4,0,9,3,3,16,4,4,0};

    public NAND(int VCC, int gnd, int inputPinNo1,int inputPinNo2, int outputPinNo, T input1, T input2)
    {
        super(VCC, gnd, inputPinNo1, inputPinNo2, outputPinNo, input1, input2);
    }
    
    //Checker Methods    
    public String checkInputPin()
    {
        try
        {   
            if(inputCombos[inputPinNo1] != 1 && inputCombos[inputPinNo2] == 1)
                throw new InputPinException("Wrong InputPin Number 1\n");
            else if(inputCombos[inputPinNo2] != 1 && inputCombos[inputPinNo1] == 1)
                throw new InputPinException("Wrong InputPin Number 2\n");
            else if(inputCombos[inputPinNo1] != 1 && inputCombos[inputPinNo2] != 1)
                throw new InputPinException("Wrong InputPin Numbers 1 and 2\n");    
            else if( (inputCombos[inputPinNo1]==1) && inputPinNo2 != inputPinNo1+1 && inputPinNo2 != inputPinNo1-1) 
                throw new InputPinException("Wrong InputPin Number Combination\n");       
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
            if(inputCombos[outputPinNo]!=3)
                throw new OutputPinException("Wrong OutputPin Number\n");
            else if( outputCombos[outputPinNo]!=((outputCombos[inputPinNo1])*(outputCombos[inputPinNo1])) &&
                             outputCombos[outputPinNo]!=((outputCombos[inputPinNo2])*(outputCombos[inputPinNo2])) )
                throw new OutputPinException("Wrong OutputPin Number for the given InputPin Combination\n");
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
    
    //Output method
    public String assignOutput()
    {
        if(input1.compareTo("X")==0 && input2.compareTo("X")!=0) //Input 1 is alone a dont care
              output="X"; //Output is a dont care     
         else if(input2.compareTo("X")==0 && input1.compareTo("X")!=0) //Input 2 is alone a dont care
              output="X";  //Output is a dont care
         else if(input2.compareTo("X")==0 && input1.compareTo("X")==0) //Input 1,2 are dont cares
              output="X";  //Output is a dont care
         else
         {
          if ( input1.compareTo("1")==0 && input2.compareTo("1")==0 )
             output=0;
          else
             output=1;   
         }  
         return output.toString();
    }
}



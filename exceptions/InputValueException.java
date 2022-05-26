package exceptions;
//Exception class to check user entered input values
public class InputValueException extends Exception
{
    String message;
    public InputValueException(String message)
    {
        this.message = message;
    }   
    public String toString()
    {
      return message;
    }     
}


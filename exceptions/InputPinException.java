package exceptions;
//Exception class to check user entered input pin numbers
public class InputPinException extends Exception
{
    String message;
    public InputPinException(String message)
    {
        this.message = message;
    }    
    public String toString()
    {
      return message;
    }
}

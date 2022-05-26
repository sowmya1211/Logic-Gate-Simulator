package exceptions;
//Exception class to check user entered output pin number
public class OutputPinException extends Exception
{
  String message;
  public OutputPinException(String message)
    {
        this.message = message;
    }   
    public String toString()
    {
      return message;
    }    
}

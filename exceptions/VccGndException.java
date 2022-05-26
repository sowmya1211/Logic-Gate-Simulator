package exceptions;
//Exception class to check user entered Vcc and Gnd Numbers 
public class VccGndException extends Exception
{
    String message;
    public VccGndException(String message)
    {
        this.message = message;
    }
    public String toString()
    {
      return message;
    }
}
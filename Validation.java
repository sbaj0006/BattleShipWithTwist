/**
 * The Validation class will allow the system to validate all user 
 * inputs accepted via the keyboard
 * @author (Smarth Bajaj)
 * @Date (20/10/2018)
 */
public class Validation
{
    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {
        // initialise instance variables
    }

    //This method is responsible to check if user has entered anything or not.
    public Boolean StringisBlank(String s1)
    {
        if(s1.length() == 0 || s1.trim().length() ==0 )
        return true;
        else
        return false;
    }

    //This method is resposnible to check if the string entered by the user has
    //atleast 3 characters and a maximum of 15 characters or not
    public Boolean StringLengthWithInRange(String s1, int min, int max)
    {
        if(s1.length() >= min && s1.length() <= max)
        return true;
        else
        return false;
    }  
    
    //This method is responsible to check if the number entered by user is 
    //between 1 maximum size of the grid or not. 
    public Boolean PositionwithinRange(String poss, int pos)
    {
       try
        {
          int xposs = Integer.parseInt(poss);
          if(xposs > 0 && xposs <= pos)
          return true;
          else
          return false;
        } catch ( Exception e )
          {
           System.out.println("Number format Exception");  
           return false;
          }
    }
}

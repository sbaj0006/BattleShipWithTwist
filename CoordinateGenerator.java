/**
 * This class is responsible for generating a random number which can be used 
 * for deciding the X and Y coordinates for each ship 
 * and even for deciding the random hull strength of each ship within the game.
 * @author (Smarth Bajaj)
 * @Date (20/10/2018)
 */
public class CoordinateGenerator
{
    private int minimumValue;
    private int maximumValue;
    
    //A default constructor to initialise the private fields
    public CoordinateGenerator()
    {
        minimumValue = 0;
        maximumValue = 0;
    }
    
    //A non default contructor to initialise the private fields
    public CoordinateGenerator(int minimumValue, int maximumValue)
    {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }
    
    //An accessor method to return the value of minimum
    public int getMinimumValue()
    {
     return minimumValue;
    }
    
    //An accessor method to return the value of maximum
    public int getMaximumValue()
    {
     return maximumValue; 
    }
    
    //A mutator method to set the value of minimum number
    public void setMinimumValue(int minimumValue)
    {
     this.minimumValue = minimumValue;
    }
    
    //A mutator method to set the value of maximum number
    public void setMaximumValue(int maximumValue)
    {
     this.maximumValue = maximumValue;
    }
    
    //This method is resposible for generating the random number between specified range
    public int random_no(int min,int max)
    {
     return (int) (Math.random()*(max-min))+min; //Math.random() returns a number between zero and one.
                                                 //then multiply it with minimum and maximum number
    }
}
    
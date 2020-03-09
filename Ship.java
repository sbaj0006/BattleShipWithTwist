/**
 * This class is responsible for recording a new ship added to the grid.
 * @author (Smarth Bajaj)
 * @Date (20/10/2018)
 */
public class Ship
{
    private String shipName;
    private int xPos;
    private int yPos;
    private int noOfHitsMade;
    private int noOfHitsNeeded;
    
    //A default constructor to initialise all the private fields
    public Ship()
    {
        this.shipName = "";
        this.xPos = 0;
        this.yPos = 0;
        this.noOfHitsMade = 0;   
        this.noOfHitsNeeded = 0;   
    }
    
    //A non default constructor to intialise all the private fields.
    public Ship(String shipName, int xPos, int yPos, int noOfHitsMade, int noOfHitsNeeded)
    {
     this.shipName = shipName;
     this.xPos = xPos;
     this.yPos = yPos;
     this.noOfHitsMade = noOfHitsMade;
     this.noOfHitsNeeded = noOfHitsNeeded;   
    }
    
    //A mutator method to set the value of shipname
    public void setShipName(String shipName)
    {
        this.shipName = shipName;
    }
    
    //An accessor method to return the value of shipname
    public String getShipName()
    {
        return shipName;
    }
    
    //A mutator method to set the value of x position
    public void setXpos(int xPos)
    {
        this.xPos = xPos;
    }
    
    //An accessor method to return the value of x position
    public int getXpos()
    {
        return xPos;
    }
    
    //A mutator method to set the value of y position
    public void setYpos(int yPos)
    {
        this.yPos = yPos;
    }
    
    //An accessor method to return the value of y position 
    public int getYpos()
    {
        return yPos;
    }
    
    //A mutator method to set the value of no of hits made
    public void setNoOfHitsMade(int noOfHitsMade)
    {
        this.noOfHitsMade = noOfHitsMade;
    }
    
    //An accessor method to return the value no of hits made
    public int getNoOfHitsMade()
    {
        return noOfHitsMade;
    }
    
    //A mutator method to set the value of no of hits needed
    public void setnoOfHitsNeeded(int noOfHitsNeeded)
    {
        this.noOfHitsNeeded = noOfHitsNeeded;
    }
    
    //An accessor method to return the value of no of hits needed
    public int getnoOfHitsNeeded()
    {
        return noOfHitsNeeded;
    }
    
    //This method increments the value of no of hits made after every hit 
    public void madeIncrement()
    {
        noOfHitsMade++;
    }
    
    //This method displays the values of all the fields
    public void display()
    {
        System.out.println("Shipname: " + shipName);
        System.out.println("xPos: " + xPos);
        System.out.println("yPos: " + yPos);
        System.out.println("noOfHitsMade: " + noOfHitsMade);
        System.out.println("noOfHitsNeeded: " + noOfHitsNeeded);
    } 
}
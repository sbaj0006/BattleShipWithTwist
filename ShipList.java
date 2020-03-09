import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
/**
 * This class is responsible for creating an arraylist which stores each 
 * ship within the player grid for the respective player or computer
 * @author (Smarth Bajaj)
 * @Date (20/10/2018)
 */
public class ShipList
{
   private ArrayList<Ship> ships;
   
   //A default constructor to create an object of Ship class
   public ShipList()
    {
    ships = new ArrayList<Ship>();
    }
    
   //A non default constructor to create an object of Ship class
   public ShipList(ArrayList<Ship> ships)
    {
        this.ships = ships;
    }
    
   //An accessor method to return the ships. 
   public ArrayList<Ship> getShips()
    {
        return ships;
    }
    
   //A mutator method to set the values of ships 
   public void setShips(ArrayList<Ship> ships)
    {
        this.ships = ships;
    }
    
   //This method sets the values of shipname, x position and y position 
   //for the player ships 
   public void playerdetails(String name, String x, String y, int strength)
    {
        Ship s2 = new Ship();
        
        s2.setShipName(name);
        
        int xpos = Integer.parseInt(x);
        s2.setXpos(xpos);
        
        int ypos = Integer.parseInt(y);
        s2.setYpos(ypos);
        
        s2.setnoOfHitsNeeded(strength);
        ships.add(s2);     
    }
   
   //This method displays the player grid on the screen
   public void playergrid(int pos)
    {
        System.out.println("Displaying the player grid:");
        
        int i,j;
        boolean isShip = false;
        
        for(i=1; i<=pos; i++)
         {
            for(j=1; j<=pos; j++)
           { 
             for(Ship s1 : ships)
              {
                   if((i == s1.getYpos()) && (j == s1.getXpos()))
                    {      
                      if(s1.getNoOfHitsMade() == s1.getnoOfHitsNeeded())
                        {
                          System.out.print("X");
                          isShip = true;
                        }
                       else if(s1.getNoOfHitsMade() >= 1 && s1.getNoOfHitsMade() < s1.getnoOfHitsNeeded())
                        {
                          System.out.print("D");
                          isShip = true;
                        }
                       else if(s1.getNoOfHitsMade() == 0)
                        {
                         System.out.print("O");
                         isShip = true;
                        }
                    }
               }
               
            if(!isShip)
            System.out.print("~");
            isShip = false;  
           }
         System.out.println(" ");
        }
        
    }
      
   //This method sets the values of x position and y position 
   //for the computer ships  
   public void computerdetails(int xpos, int ypos, int strength)
    {
         Ship s3 = new Ship();
        
        s3.setXpos(xpos);
        System.out.println("x" + xpos);
        
        s3.setYpos(ypos);
        System.out.println("y" + ypos);
        
        s3.setnoOfHitsNeeded(strength);
        ships.add(s3);
    }
    
   //This method displays the player grid on the screen
   public void computergrid(int pos, Boolean shipsvisible)
    {
          Boolean isShip = false;
          System.out.println("Displaying the computer grid:");
          
           for(int i=1; i<=pos; i++)
           {
             for(int j=1; j<=pos; j++)
              { 
                  for(Ship s1 : ships)
                {
                     if((i == s1.getYpos()) && (j == s1.getXpos()))
                     {
                        if(s1.getNoOfHitsMade() == s1.getnoOfHitsNeeded())
                         {
                          System.out.print("X");
                          isShip = true;
                         }
                        else if(s1.getNoOfHitsMade() >= 1 && s1.getNoOfHitsMade() < s1.getnoOfHitsNeeded())
                         {
                          System.out.print("D");
                          isShip = true;
                         }
                        else if(s1.getNoOfHitsMade() == 0 && shipsvisible )
                         { 
                          System.out.print("O");
                          isShip = true;
                         }
                     }
                }
               if(!isShip)
               System.out.print("~");
               isShip = false;    
              }
            System.out.println(" ");
          }
    }
   
   //This method checks if the player ship is able to hit the computer ship or not
   public Boolean playershoot(ArrayList<Ship> ships, int pos)
     {
      int x = 0;
      int y = 0;
      int flag1 = 0;
      int flag = 0; 
   
      System.out.println();
      System.out.println("Player to make a guess");
      
      System.out.println("Ship X position (1-" + pos +")");  
      while(flag==0)
      {
            Scanner in = new Scanner(System. in);
            String s = in.nextLine();
            try
               {
                 x = Integer.parseInt(s);
                 if(x<1 || x>(pos))
                  {
                   System.out.println("Enter a Number between 1 and "+pos);
                   System.out.println("Ship X position (1-" + pos +")");
                  }
                 else
                  {
                    flag = 1;
                  }
               }catch (NumberFormatException ex) 
               {
                System.out.println("Enter a Number. Invalid number.");
                System.out.println("Ship X position (1-" + pos +")");
               }
      }
      
      System.out.println("Ship Y position (1-" + pos +")");
      while(flag1 == 0)
      {
            Scanner in = new Scanner(System. in);
            String s = in.nextLine();
            try
             {
                y = Integer.parseInt(s);
                if(y<1 || y>(pos))
                {
                 System.out.println("Enter a Number between 1 and "+pos);
                 System.out.println("Ship Y position (1-" + pos +")");
                }
                else
                {
                  flag1 =1;
                }
             } catch (NumberFormatException ex) 
             {
                System.out.println("Enter a Number. Invalid number.");
                System.out.println("Ship Y position (1-" + pos +")");
            }
      }
        
      for(Ship s3 : ships)
      { 
         if(x == s3.getXpos() && y == s3.getYpos() && s3.getNoOfHitsMade() < s3.getnoOfHitsNeeded())
           {
             System.out.println("Player HITTTTTTTTT !!!!!");
             s3.madeIncrement();
             return true;
           }
      }  
         
      System.out.println("Player MISSSSSSSSS !!!!!");
      return false;
    }
    
   //This method checks if the computer ship is able to hit the player ship or not
   public Boolean computershoot(int a, int b, ArrayList<Ship> ships1)
    {
      for(Ship s2 : ships1)
       {
         if(a == s2.getXpos() && b == s2.getYpos() && s2.getNoOfHitsMade() < s2.getnoOfHitsNeeded())
          {
            System.out.println("Computer HITTTTTTTTT !!!!!!");
            s2.madeIncrement();
            return true;
          }
       }
       
      System.out.println("Computer MISSSSSSSSS !!!!!");
      return false;   
    }
    
   //This method checks if all the ships are destroyed or not
   public boolean shipsDestroyed()
   {
     for(Ship s1 : ships)
       {
          if(s1.getNoOfHitsMade() != s1.getnoOfHitsNeeded())
          {
           return false;
          }
       }
     return true;
   }
    
   //This method checks if the two player ships are at same location or not. 
   public Boolean playercompare(String xpos , String ypos)
    {
     int x = Integer.parseInt(xpos);
     int y = Integer.parseInt(ypos);
     Boolean flag = true;
        
     for(Ship s1 : ships)
       {
         if(x == s1.getXpos() && y == s1.getYpos())
         {
          System.out.println("Ship already exists there. Please choose different location");
          return false;
         }
        }
     return true;
   }
    
   //This method checks if the two computerPositionwithinRange ships are at same location or not. 
   public Boolean computercompare(int xpos , int ypos)
   {
    Boolean flag = true;
    for(Ship s1 : ships)
      {
         if(xpos == s1.getXpos() && ypos == s1.getYpos())
         {
          System.out.println("Cannot place ship there");
          return false;
         }
       }
    return true;
   }
   
}
          
        


         




    


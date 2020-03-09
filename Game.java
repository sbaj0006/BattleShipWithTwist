import java.util.Scanner;
/**
 * This class is responsible for initiating the game, reading the file, 
 * loading the settings, interacting with the other classes, 
 * and writing to the file when the game ends. 
 * @author (Smarth Bajaj)
 * @Date (20/10/2018)
 */
public class Game
{
 private ShipList playerShips;
 private ShipList computerShips;
 
//A default constructor to create objects of shipList class 
public Game()
  {
   playerShips = new ShipList();
   computerShips = new ShipList();
  }
    
//A non default constructor to create objects of shipList class 
public Game(ShipList playerShips, ShipList computerShips)
  {
   this.playerShips = playerShips;
   this.computerShips = computerShips;
  }

//An accessor method to return player ships
public ShipList getPlayerShips()
  {
   return playerShips;
  }
  
//An accessor method to return computer ships 
public ShipList getComputerShips()
  {
   return computerShips;
  }

//A mutator method to set the player ships
public void setPlayerShips(ShipList playerShips)
  {
   this.playerShips = playerShips;
  }
 
//A mutator method to set the computer ships 
public void setComputerShips(ShipList computerShips)
  {
   this.computerShips = computerShips;
  }

//This method starts the game
public void start()
  {
   String poss = "";
   String hitss = "";
   String shipsvisiblee = "";
   String noOfshipss = ""; 
   
   CoordinateGenerator r1 = new CoordinateGenerator();
   FileIO IO = new FileIO();
   String data[] = IO.readFile();
   
   poss = data[0];
   hitss = data[1]; 
   shipsvisiblee = data[2];
   noOfshipss = data[3];
            
   System.out.println(poss + "\t" + hitss + "\t" + shipsvisiblee + "\t" + noOfshipss);
   
   int pos = Integer.parseInt(poss.trim());
   int noOfships = Integer.parseInt(noOfshipss.trim());
   Boolean shipsvisible = Boolean.parseBoolean(shipsvisiblee.trim());
   Boolean hits = Boolean.parseBoolean(hitss.trim());
           
   int strength = r1.random_no(1,5);
   System.out.println("Strength is" + strength);
  
   displaygame(pos, noOfships, hits, shipsvisible);
   settings();
   player(pos, noOfships, strength);
   computer(pos, noOfships, strength);        
   hit(pos, shipsvisible);   
  }
 
//This method just displays the line "loading player settings"  
public void settings()
 {
  System.out.println("Loading player settings:");
 }

//This method accepts player ship names and its corressponding x and y coordinates
public void player(int pos, int noOfships, int strength)
  {
   int i= 0;
   Boolean v = true;
   Boolean v1 = false;
   String name;
   String xpos = "";
   String ypos = "";
   Boolean isTrue = false;
   do
   {  
      System.out.println("Please enter the details for the" + " " + (i+1) + " " + " ship:");
      System.out.println("ShipName:");
      Input input = new Input();
      Validation valid = new Validation();
      do
        {
         name = input.acceptInput("Please enter your Ship Name:");
         v = valid.StringisBlank(name);
         if(v == true)
         System.out.println("Ship Name cannot be blank");
         v1 = valid.StringLengthWithInRange(name,3,15);
         if (v1 == false)
         System.out.println("Ship Name must be between 3 and 15 characters long");
        } while (v == true || v1 == false);       
       
     do
     {
         do
            {
             xpos = input.acceptInput("Ship x Position (1-" + pos +")");
             v1 = valid.PositionwithinRange(xpos, pos);
             if(v1 == false)
             System.out.println("Ship x position must be between 1 and " + pos + "");
            } while (v1 == false);
            
         do
            {
             ypos = input.acceptInput("Ship y Position (1-" + pos +")");
             v1 = valid.PositionwithinRange(ypos, pos);
             if(v1 == false)
             System.out.println("Ship y position must be between 1 and " + pos + "");
            } while (v1 == false);
      
       isTrue = playerShips.playercompare(xpos,ypos);

       if(isTrue == true)
       playerShips.playerdetails(name, xpos, ypos, strength);     
     } while (!isTrue);
    
    i++;
   } while(i < noOfships);  
}

//This method accepts computer ship names and its corressponding x and y coordinates
public void computer(int pos, int noOfships, int strength)
{
   CoordinateGenerator r1 = new CoordinateGenerator();
   int i =0;
   Boolean isShip = false;
   System.out.println("Loading computer settings:");
   do
   {
      do
        {
         int compx = r1.random_no(1,pos);
         int compy = r1.random_no(1,pos);
         isShip = computerShips.computercompare(compx,compy);
 
         if(isShip == true)
         computerShips.computerdetails(compx, compy, strength);
        } while (!isShip);
    i++;
   }while (i < noOfships);
   
   System.out.println("Computer settings generated!");
   System.out.println("Press Enter key to continue...");
   try
     {
      System.in.read();
      }  
   catch(Exception e)
     {
     }  
}
    
//This method asks the player and the computer to make a guess to check if 
//they hit the opponent ship or not. It also displays the winner of the game 
//along with their respective score.  
public void hit(int pos, Boolean shipsvisible)
 {
   int playerscore = 0;
   int computerscore = 0;
   CoordinateGenerator r1 = new CoordinateGenerator();
   int i=  0;
   int j = 0;
   Boolean flag = true;
   Boolean flag1 = true;
   do
   {
      System.out.println("Press Enter key to continue...");
      try
        {
         System.in.read();
        }  
      catch(Exception e)
        {
         } 
         
      System.out.println();
      System.out.println();
      System.out.println("Beginning Next Round :");
      System.out.println("Score of player :"  + playerscore);
      System.out.println("Score of computer :"  + computerscore);
       
      playerShips.playergrid(pos);
      System.out.println("----------------------------------------------------------------");
      computerShips.computergrid(pos, shipsvisible);   
      
      Boolean abc = playerShips.playershoot(computerShips.getShips(), pos);
      
      if(abc == true)
      {
      i++;
      playerscore = playerscore + 10;
      }
      
      int xguess = r1.random_no(1,pos);
      int yguess = r1.random_no(1,pos);
      System.out.println();
      System.out.println("Computer to make a guess");
      System.out.println("x guess:" + " " + xguess);
      System.out.println("y guess:" + " " + yguess);
      
      Boolean abcd  = computerShips.computershoot(xguess, yguess, playerShips.getShips());
      if(abcd == true)
      {
        j++;
        computerscore = computerscore + 10;
      }
      
      flag = playerShips.shipsDestroyed();
      flag1 = computerShips.shipsDestroyed();
   } while (!flag && !flag1);
     
   playerShips.playergrid(pos);
   computerShips.computergrid(pos, shipsvisible);
     
   String Fileplayerscore = Integer.toString(playerscore);
   String Filecomputerscore = Integer.toString(computerscore);
   StringBuilder sb = new StringBuilder();
     
   if(!flag)
    {
     System.out.println("Player Wins");
     sb.append("Player Wins");
     sb.append(" ");
     sb.append("Final Player Score:");
     sb.append(Fileplayerscore);
     sb.append(" ");
     sb.append("Final Computer Score:");
     sb.append(Filecomputerscore);
     }
   else
     {
     System.out.println("Computer Wins");
     sb.append("Computer Wins");
     sb.append(" ");
     sb.append("Final Player Score:");
     sb.append(Fileplayerscore);
     sb.append(" ");
     sb.append("Final Computer Score:");
     sb.append(Filecomputerscore);
     }
     
   System.out.println("Player final score is:" + playerscore);
   System.out.println("Computer final score is:" + computerscore);
   
   FileIO IO = new FileIO();
   IO.writeFile(sb);
  }
  
//This method displays the game formalitites  
public void displaygame(int pos, int noOfships, Boolean hits, Boolean shipsvisible)
{
   System.out.println("+========================================================+");
   System.out.println("|                                                        |"); 
   System.out.println("|  Welcome to the Battleship Game -- With a Twist!!      |");
   System.out.println("|                                                        |");
   System.out.println("+========================================================+");
   System.out.println("The game will use the grid size defined in the settings file");
   System.out.println("Player grid size set as: (" + pos + "X" + pos + ")");
   System.out.println("Maximum number of ships allowed as:" +  " " + noOfships);
   System.out.println("Multiple hits allowed per ships set as:" + " " +  hits);
   System.out.println("Computer Ships visible :" + " " + shipsvisible);
   System.out.println("Press Enter key to continue...");
   try
     {
       System.in.read();
     }  
   catch(Exception e)
     {
     }      
}
}


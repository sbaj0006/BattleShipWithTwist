import java.util.*;
import java.io.*;
/**
 * This class is responsible for reading and writing to a file only.
 * The FileIO class will specify the attributes and behaviours for reading 
 * and writing to a file.
 * @author (Smarth Bajaj)
 * @Date (20/10/2018)
 */
public class FileIO
{
   private String filename;
   
   //A default constructor to initialise filename
   public FileIO()
   {
   filename = "gamesettings.txt";    
   }
   
   //A non default constructor to intitialise the filename
   public FileIO(String filename)
   {
   this.filename = filename;    
   }
   
   //An accessor method that returns the private value of the field.
   public String getFilename()
   {
    return filename;   
   }
   
   //A mutator method to set the values of the private  field.
   public void setFilename(String filename)
   {
   this.filename = filename;    
   }
   
   //This method is responsible for reading the data from the file and then
   //splitting the data to store it in an array.
   public String[] readFile()
   {
     int i = 0;
     String data[] = new String[4];
       try
        {
           FileReader inputFile = new FileReader("gamesettings.txt");
           Scanner parser = new Scanner(inputFile);
           String contents = " ";
           
              while(parser.hasNextLine())
              {
               contents += parser.nextLine();
               i++;
              }
    
           data = contents.split(","); //split the data using ","
           inputFile.close();
    
        } catch (FileNotFoundException e)
           {
            System.out.println("File not exists");
           }
           catch(IOException e)
           {
            System.out.println("Unexpected IO Exception");
           }
           
     return data;
   }

   //This method is responsible for writing the data to the file.
   public void writeFile( StringBuilder contents)
   {
       try
       {
        PrintWriter outputfile = new PrintWriter("gameoutcome.txt");
        outputfile.println(contents);
        outputfile.close();
       } catch( IOException e )
          {
            System.out.println("Cannot write to the file");
          }
   }
    
}

import java.util.Scanner;

/**
 * The Input class will specify the attributes and behaviours for reading input 
 * from the user via the keyboard.
 * @author (Smarth Bajaj)
 * @Date (20/10/2018)
 */
public class Input
{
    /**
     * Constructor for objects of class Input
     */
    public Input()
    {
        
    }
    
    //This method is responsible for accepting the user's input from the keyboard. 
    public String acceptInput(String s1)
    {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println(s1);
        String abc = scanner1.nextLine();
        return abc;
    }
}

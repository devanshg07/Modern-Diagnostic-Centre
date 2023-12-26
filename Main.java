import java.io.IOException;
import hsa.Console;

public class Main {
    //declare console
    static Console c;

    //this is the main class and its use is to execute the code with the use of methods
    public static void main(String[] args) throws IOException {
        //declare new console object
        c = new Console();
    
        //create an object from the menu page class
        MenuPage intro = new MenuPage(c);
        //use the object to execute the welcome method
        intro.welcome();

        //close the console
        c.close();
        
    }//main
}//class


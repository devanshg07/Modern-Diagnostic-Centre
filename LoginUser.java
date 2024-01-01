import java.io.BufferedReader;
import java.io.FileReader;

import hsa.Console;

//the purpose of the class is to let the user login to the database
public class LoginUser {
    private Console c;//introduce the console

    //create a console object
    public LoginUser(Console console) {
        c = console;
    }//console

    private String username;//username string
    private char[] password;//password in character format all in an array
    private int currentUser = 0;//amount of users logged in
    private int countAttempt = 0;//amount of failed attempts when logging in
    private final String userName = "admin";
    private final String passWord = "12345";

    //getters and setters for the variables above
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(int currentUser) {
        this.currentUser = currentUser;
    }

    public int getCountAttempt() {
        return countAttempt;
    }

    public void setCountAttempt(int countAttempt) {
        this.countAttempt = countAttempt;
    }

    //this method will have the admin log in
    public void login(){

        //condition if the user tries to login more than 3 times
        if(countAttempt == 2){
            c.println("One last chance");
        }//if

        if(countAttempt == 3){
            System.exit(0);//exits the whole database
        }//if

        if(currentUser > 1){
            c.println("Already logged in. ");//if admin logs in more than once
            return;//returns value to the main class
        }//if

        c.println("Please enter your credentials to continue.");//gives user instructions
        c.println();
        c.print("Please enter username: ");
        username = c.readLine();//string value for a username
        c.print("Please enter password: ");
        password = readPassword(c);//read password through the character array through the console
        String passwString = new String(password);//converts the array to a string
   
        //this try statement will employ a buffered reader to check if the password is accurate.
            
                final String userName = "admin";
                final String passWord = "12345";
        
                    //this if statement will check if the user input is the same as the required one being "Admin" for the username and "12345" for password
                    if (userName.equals(username) && passWord.trim().equals(passwString.trim())) {
                        c.println("Login Successful");//lets the user know it went well
                        currentUser += 1;//adds 1 to the total amount of users
                        return;//returns to the main
                    }/*if */
                    //if the password or username is incorrect it will let the user know 
                    else{
                c.println("Login failed, please try again");
                countAttempt += 1;//adds 1 to the amount of attempts in logging in
                login();//implements the method once again
                }//else
    }//method

    //this method will convert the character array to a string and to keep the password confidential in the output screen
    private char[] readPassword(Console c2) {
        char[] password = new char[50];//max length of 50
        int index = 0;
        //this while loop will make ways incase the user presses incorrect buttons
        while (true){
            char key = c.getChar();//variable for the key pressed on the keyboard
            //this if statement checks if the user pressed tab or return
            if(key == '\n' || key == '\r'){
                break;
            }//if

            //this statement checks if user pressed backspace and decreases the index if true
            else if (key == '\b' && index == 0) {
                index -= 1;
                c.println( "\b \b");//erases the character                
            }
            
            //if none of those are pressed, it will replace the charcter with a start on the screen
            else{
                c.print("*");//prints a confidential value
                password[index++] = key;//does it for the remainder of the array
            }//else
        }//while loop
        password[index] = '\0';
        c.println();
        return password;//returns the password to main method
    }//method

    //this method logs out the user of the database
    public void logOut(){
        currentUser -= 1;///decreases user count by 1
        c.println("Logout successful!");//lets the user know
        login();//implements the login method once again
    }//method
}//class
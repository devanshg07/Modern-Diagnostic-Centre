import java.io.BufferedReader;
import java.io.FileReader;

import hsa.Console;

public class LoginUser {
    private Console c;

    public LoginUser(Console console) {
        c = console;
    }

    private String username;
    private char[] password;
    private int currentUser = 0;
    private int countAttempt = 0;
    

    public void login(){

        if(countAttempt >= 3){
            c.println("Womp womp womp, you failed 3 times. ");
            System.exit(0);
        }
        if(currentUser > 1){
            c.println("Already logged in. ");
            return;
        }

        c.println("Please enter your credentials to continue.");
        c.println();
        c.print("Please enter username: ");
        username = c.readLine();
        c.print("Please enter password: ");
        password = readPassword(c);
        String passwString = new String(password);
   

        try(BufferedReader reader3 = new BufferedReader(new FileReader("C:\\Users\\Devansh\\Downloads\\PasswordFile.txt"))){
            
                String fileUserName;
                String filePassword;
        
                while ((fileUserName = reader3.readLine()) != null && (filePassword = reader3.readLine()) != null) {
                    if (fileUserName.equals(username) && filePassword.trim().equals(passwString.trim())) {
                        c.println("Login Successful");
                        currentUser += 1;
                        return;
                    }
                }
    
                c.println("Login failed, please try again");
                countAttempt += 1;
                login();
            
        } catch (Exception e) {
            c.println(e.getMessage());
        }
    }

    private char[] readPassword(Console c2) {
        char[] password = new char[50];
        int index = 0;
        while (true){
            char key = c.getChar();
            if(key == '\n' || key == '\r'){
                break;
            }
            else if (key == '\b' && index == 0) {
                index -= 1;
                c.println( "\b \b");                
            }
            else{
                c.print("*");
                password[index++] = key;
            }
        }
        password[index] = '\0';
        c.println();
        return password;
    }

    public void logOut(){
        currentUser -= 1;
        c.println("Logout successful!");
        login();
    }
}

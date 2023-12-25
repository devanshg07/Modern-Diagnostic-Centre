import java.io.BufferedReader;
import java.io.FileReader;

import hsa.Console;

public class LoginUser {
    private Console c;

    public LoginUser(Console console) {
        c = console;
    }

    private String username;
    private String password;
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
        password = c.readLine();

        try(BufferedReader reader3 = new BufferedReader(new FileReader("C:\\Users\\Devansh\\Downloads\\PasswordFile.txt"))){
            
                String fileUserName;
                String filePassword;
        
                fileUserName = reader3.readLine();
                filePassword = reader3.readLine();
              
                if(fileUserName.equals(username) && filePassword.equals(password)){
                    
                    c.println("Login Successful");
                    currentUser += 1;
                }
                else{
                    c.println("Login failed, please try again");
                    countAttempt += 1;
                    login();
                  
                }
                reader3.close();
            
        } catch (Exception e) {
            c.println(e.getMessage());
        }
    }

    public void logOut(){
        currentUser -= 1;
        c.println("Logout successful!");
        login();
    }
}

import hsa.Console;
import java.io.*;
import java.nio.charset.StandardCharsets;

//the purpose of this class is to conduct all methods related to doctors
public class Doctor {

    private Console c;//introduce console variable

    private String docName;//variable for doctor's name
    private char docGender;//variable for doctor's gender
    private String docQualifications;//variable for doctor's field
    private int licNum;//variable for doctor's license number
    private char status;//variable for doctor's status

    //employ the console in this class
    public Doctor(Console console) {
        this.c = console;
    }//console

    //the purpose of this method is for the admin to add a new doctor to their database which is a txt file in this context
    public void addDoctor() {
        c.print("Enter Doctor's name: ");
        this.docName = c.readLine();//recieves the doctor's name

        c.print("Enter doctor's gender (M or F): ");
        this.docGender = c.readChar();//recieves the doctor's gender

        //the purpose of this if statement is incase there's a typo in terms of character input
        if(!(this.docGender == 'M' || this.docGender == 'F')){
            c.println("That didn't work, try again.");
            c.print("Enter doctor's gender (M or F): ");//asks again
            this.docGender = c.readChar();//valuates another time
        }//if

        c.print("Enter Doctor's qualifications: ");
        this.docQualifications = c.readLine();//recieves doctor's qualifications

        c.print("Enter doctor's license number: ");
        this.licNum = c.readInt();//recieves the doctor's license number

        c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");//the doctor status in terms of their availability
        this.status = c.readChar();//recieves the status

        //the purpose of this if statement is incase if there's a typo in terms of character input
        if(!(this.status == 'A' || this.status == 'W' || this.status == 'N')){
            c.println("That didn't work, try again. ");
            c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");//asks again
            this.status = c.readChar();//valuates another time
        }//if
     
       
        final String filePath = "C:\\Users\\Devansh\\Downloads\\Doctor.txt";//a string for the file location and the value cant change
        
        //this try catch statement will use the buffered writer but will throw an except if it fails
        try (BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Devansh\\Downloads\\Doctor.txt", true), StandardCharsets.UTF_8))){//uses boolean value and charset details to consistently add data to the txt file

            //this if statement will check if its a blank file and in a table format will add categories
            if(new File(filePath).length() == 0){
                writer1.write("Name \t" + "Gender \t" + "Qualifications \t" + "License Number \t" + "Status");//adds all categories
                writer1.newLine();
                writer1.write("--------------------");//adds a line of highphens to seperate categories and information
            }//if
  
            // Append the doctor's info into the file
              writer1.write("\n" + docName + "\t" + this.docGender + "\t" + this.docQualifications + "\t\t" + this.licNum + "\t\t" + this.status);
              writer1.newLine();//newline for new doctors for necesary spacing
             

            c.println("Doctor's information written to file successfully.");//will print to let the admin know
            writer1.close();
            
        }/*try*/ catch (IOException e) {
            c.println(e.getMessage());//will print what the problem is, if present
    }//catch
    }//method

    //this method will read the file, and will then print the information into the console
    public void showDoctor() {
        // this try catch statement will use bufferedreader and if it fails it will throw an exception 
        try (BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Devansh\\Downloads\\Doctor.txt"))) {//introduce bufferedreader object to the file location
            String docInfo;//string for the doctor information present in the file
    
            //this while loop will read every single line in the file and write in the console until there are none left
            while ((docInfo = reader1.readLine()) != null) {
                c.println(docInfo);//writes the line
            }//while
            reader1.close();//close the buffered reader
        }/*try*/ catch (IOException e) {
            c.println(e.getMessage());//will tell the user if there's a problem
        }//catch
    }//method
}//class

        
    


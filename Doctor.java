import hsa.Console;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Doctor {

    private Console c;

    private String docName;
    private char docGender;
    private String docQualifications;
    private int licNum;
    private char status;

    public Doctor(Console console) {
        this.c = console;
    }

    public void addDoctor() {
        c.print("Enter Doctor's name: ");
        this.docName = c.readLine();
        c.print("Enter doctor's gender (M or F): ");
        this.docGender = c.readChar();
        if(!(this.docGender == 'M' || this.docGender == 'F')){
            c.println("Has to be male of female, try again.");
            c.print("Enter doctor's gender (M or F): ");
            this.docGender = c.readChar();
        }
        c.print("Enter Doctor's qualifications: ");
        this.docQualifications = c.readLine();
        c.print("Enter doctor's license number: ");
        this.licNum = c.readInt();
        c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");
        this.status = c.readChar();
     
       
        final String filePath = "C:\\Users\\Devansh\\Downloads\\Doctor.txt";
        
        try (BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Devansh\\Downloads\\Doctor.txt", true), StandardCharsets.UTF_8))){

            if(new File(filePath).length() == 0){
                writer1.write("Name \t" + "Gender \t" + "Qualifications \t" + "License Number \t" + "Status");
                writer1.newLine();
                writer1.write("--------------------");
            }
  
            // Append the patient information to the file
              writer1.write("\n" + docName + "\t" + this.docGender + "\t" + this.docQualifications + "\t\t" + this.licNum + "\t\t" + this.status);
              writer1.newLine();
             

            c.println("Doctor's information written to file successfully.");
        } catch (IOException e) {
            c.println(e.getMessage());
    }
    }

    public void showDoctor() {
        try (BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Devansh\\Downloads\\Doctor.txt"))) {
            String docInfo;
    
            while ((docInfo = reader1.readLine()) != null) {
                c.println(docInfo);
            }
            reader1.close();
        } catch (IOException e) {
            c.println(e.getMessage());
        }
    }
}

        
    


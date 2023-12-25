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
        c.print("Enter Doctor's qualifications: ");
        this.docQualifications = c.readLine();
        c.print("Enter doctor's license number: ");
        this.licNum = c.readInt();
        c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");
        this.status = c.readChar();
     
         try (BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Devansh\\Downloads\\Doctor.txt", true), StandardCharsets.UTF_8))){
  
            // Append the patient information to the file
              writer1.write("Doctor Name: " + docName + "\n" +  "Doctor Gender: " + this.docGender + "\n" + "Doctor Qualiications: " + this.docQualifications + "\n" + "Doctor's License Number: " + this.licNum + "\n" + "Doctor Status: " + this.status);
              writer1.newLine();
              writer1.write("--------------------");
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
            c.println("There was a problem reading the information.");
        }
    }
}

        
    


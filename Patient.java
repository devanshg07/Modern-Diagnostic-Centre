import hsa.Console;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Patient {
    static Console c; // Declare the console

    // Constructor to initialize the console
    public Patient(Console console) {
        this.c = console;
    }

    private String pName;
    private int pAge;
    private char pGender;
    private String pBloodGroup;
    private String pContactNumber;
    private String pLocation;

    public void addPatient(){
        c.print("Enter the patient name: ");
        pName = c.readLine();
        c.print("Enter the patient age: ");
        pAge = c.readInt();
        c.print("Enter patient gender (M or F): ");
        pGender = c.readChar();
        c.print("Enter patient's blood group: ");
        pBloodGroup = c.readLine();
        c.print("Enter patient's phone number: ");
        pContactNumber = c.readLine();
        c.print("Enter patient's location: ");
        pLocation = c.readLine();

        final String filePath = "C:\\Users\\Devansh\\Downloads\\Doctor.txt";

        try(BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Devansh\\Downloads\\Patient.txt"), StandardCharsets.UTF_8))){

            if(new File(filePath).length() == 0){
                writer2.write(("Name \t" + "Age \t" + "Gender \t" + "Blood Group \t" + "Contact Number \t" + "Location "));
                writer2.newLine();
                writer2.write("--------------------");
            }
            writer2.write("\n" + pName + "\t" + pAge + "\t" + pGender + "\t" + pBloodGroup + "\t" + pContactNumber + "\t" + pLocation);
            writer2.newLine();

            c.println("Doctor's information written to file successfully.");
             writer2.close();

        } catch (Exception e) {
            c.println(e.getMessage());
        }
    }

    public void showPatient(){
        try (BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Devansh\\Downloads\\Patient.txt"))){
            String pInfo;

            while ((pInfo = reader2.readLine()) != null) {
                c.println(pInfo);
            }
            reader2.close();   
        } catch (Exception e) {
            c.println(e.getMessage());
        }
    }
}

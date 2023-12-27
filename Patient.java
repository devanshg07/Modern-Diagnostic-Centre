import hsa.Console;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

//the purpose of this class is to conduct all methods related to patients
public class Patient {
    static Console c; // Declare the console

    // Constructor to initialize the console
    public Patient(Console console) {
        this.c = console;
    }//console

    private String pName;//patient name
    private int pAge;//patient age
    private char pGender;//patient gender
    private String pBloodGroup;//patient blood group
    private String pContactNumber;//patient phone number
    private String pLocation;//patient location
    private String condition;//patients condition (critical stable normal)

    private final String nameLabel = "Name";
    private final String ageNameLabel = "Age";
    private final String genderNameLabel = "Gender";
    private final String bloodGroupNameLabel = "Blood Group";
    private final String contactNumberNameLabel = "Phone Number";
    private final String conditionNameLabel = "Condition";

    

    public Patient(String pName, int pAge, char pGender, String pBloodGroup, String pContactNumber, String pLocation,
            String condition) {
        this.pName = pName;
        this.pAge = pAge;
        this.pGender = pGender;
        this.pBloodGroup = pBloodGroup;
        this.pContactNumber = pContactNumber;
        this.pLocation = pLocation;
        this.condition = condition;
    }

    //getter and setter for the variables above
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public char getpGender() {
        return pGender;
    }

    public void setpGender(char pGender) {
        this.pGender = pGender;
    }

    public String getpBloodGroup() {
        return pBloodGroup;
    }

    public void setpBloodGroup(String pBloodGroup) {
        this.pBloodGroup = pBloodGroup;
    }

    public String getpContactNumber() {
        return pContactNumber;
    }

    public void setpContactNumber(String pContactNumber) {
        this.pContactNumber = pContactNumber;
    }

    public String getpLocation() {
        return pLocation;
    }

    public void setpLocation(String pLocation) {
        this.pLocation = pLocation;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    //this method will ask for information, and will write it on a txt file
    public ArrayList<Patient> addPatient(){
        c.print("Enter the patient name: ");
        this.pName = c.readLine();//recieve name

        c.print("Enter the patient age: ");
        this.pAge = c.readInt();//recieve age

        c.print("Enter patient gender (M or F): ");
        this.pGender = c.readChar();//recieve gender

         //the purpose of this if statement is incase there's a typo in terms of character input
         if(!(this.pGender == 'M' || this.pGender == 'F')){
            c.println("That didn't work, try again.");
            c.print("Enter doctor's gender (M or F): ");//asks again
            this.pGender = c.readChar();//valuates another time
        }//if


        c.print("Enter patient's blood group: ");
        this.pBloodGroup = c.readLine();//recieve blood group

        c.print("Enter patient's phone number: ");
        this.pContactNumber = c.readLine();//recieve phone nuber

        c.print("Enter patient's location: ");
        this.pLocation = c.readLine();//recieve location

        c.print("Enter patient's desired care (1. Heart, 2. Image Testing(Xray, etc), 3. Eye, 4. Brain, 5. Skin, 6. General)");
        int conditionID = c.readInt();

        if(conditionID == 1){
            condition = "Heart";
        } 
        else if(conditionID == 2){
            condition = "Image Testing";
        }
        else if(conditionID == 3){
            condition = "Eye";
        }
        else if(conditionID == 4){
            condition = "Brain";
        }
        else if(conditionID == 5){
            condition = "Skin";
        }
        else{
            condition = "General";
        }

        ArrayList<Patient> patientList = new ArrayList<>();



        Patient patient = new Patient(pName, pAge, pGender, pBloodGroup, pContactNumber, pLocation, condition);
        patientList.add(patient);



        final String filePath = "C:\\Users\\Devansh\\Downloads\\Patient.txt";//variable for the filepath in the computer with unchanging value
        //final String filePath = "Doctor.txt";

        //this try catch statement will use bufferedreader and will throw an error if an exception is rpesent
        try(BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Devansh\\Downloads\\Patient.txt"), StandardCharsets.UTF_8))){

            //this if statement will write the categories to file if the file turns out to be empty
            if(new File(filePath).length() == 0){
                writer2.write(("Name \t" + "Age \t" + "Gender \t" + "Blood Group \t" + "Contact Number \t" + "Location \t" + "Condition"));
                writer2.newLine();//gap
                writer2.write("--------------------");//hiphen line
            }//if

            writer2.write("\n" + pName + "\t" + pAge + "\t" + pGender + "\t" + pBloodGroup + "\t" + pContactNumber + "\t" + pLocation + "\t" + condition);//writes all information about the patients
            writer2.newLine();//gap line

            c.println("Doctor's information written to file successfully.");//writes if all goes well in this step
    
        }/*try*/ catch (Exception e) {
            c.println(e.getMessage());//will tell the admin what the probem is if present
        }//catch
        return patientList;
    }//method

    //this method will read from text file and will show admin the info
    public void showPatient(){

        //this try catch statement will use buffered reader and show the problems if present
        try (BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Devansh\\Downloads\\Patient.txt"))){
            String pInfo;//string for the patients info

            //this while loop will write the info from the file to the console as long its not null
            while ((pInfo = reader2.readLine()) != null) {
                c.println(pInfo);
            }//while

            reader2.close();//close the buffered read   

        }/*try*/catch (Exception e) {
            c.println(e.getMessage());//tells user what the problem is, if there is one
        }//catch
    }//method
}//class
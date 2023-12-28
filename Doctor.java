import hsa.Console;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Doctor {

    private Console c;
    String filePath = "Doctor.txt";

    private String docName;
    private char docGender;
    private String docQualifications;
    private int licNum;
    private char status;

    String[] label = {"Name", "Gender", "Quals", "License Num", "Status"};
    String[] docInfo = new String[5];

    ArrayList<Patient> doctorPatientList= new ArrayList<>();

    public ArrayList<Patient> getDoctorPatientList() {
        return doctorPatientList;
    }

    public void setDoctorPatientList(ArrayList<Patient> doctorPatientList) {
        this.doctorPatientList = doctorPatientList;
    }

    public Doctor(Console console) {
        this.c = console;
    }

    public Doctor(String docName, String docQualifications, char status) {
        this.docName = docName;
        this.docQualifications = docQualifications;
        this.status = status;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocQualifications() {
        return docQualifications;
    }

    public void setDocQualifications(String docQualifications) {
        this.docQualifications = docQualifications;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public ArrayList<Doctor> addDoctor() {

        c.print("Enter Doctor's name: ");
        this.docName = c.readLine();
        docInfo[0] = this.docName;

        c.print("Enter doctor's gender (M or F): ");
        this.docGender = c.readChar();

        if (!(this.docGender == 'M' || this.docGender == 'F')) {
            this.docInfo = null;
            c.println("That didn't work, try again.");
            c.print("Enter doctor's gender (M or F): ");
            this.docGender = c.readChar();
        }
        docInfo[1] = String.valueOf(this.docGender);


        c.print("Enter Doctor's qualifications (1.Cardiologist, 2.Radiologist, 3.Optometrist, 4.Neurologist, 5.Dermatologist, 6.Physician): ");
        int docQualificationsID = c.readInt();
        switch (docQualificationsID) {

            case 1:
            this.docQualifications = "Cardiologist";
            break;

            case 2:
            this.docQualifications = "Radiologist";
            break;

            case 3:
            this.docQualifications = "Optometrist";
            break;

            case 4:
            this.docQualifications = "Neurologist";
            break;

            case 5:
            this.docQualifications = "Dermatologist";
            break;

            case 6:
            this.docQualifications = "Physician";
            break;
        
            default:
            c.println("There was an error");
            break;
        }

        docInfo[2] = this.docQualifications;


        c.print("Enter doctor's license number: ");
        this.licNum = c.readInt();
        docInfo[3] = String.valueOf(this.licNum);

        c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");
        this.status = c.readChar();

        if (!(this.status == 'A' || this.status == 'W' || this.status == 'N')) {
            this.status = (Character) null;
            c.println("That didn't work, try again. ");
            c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");
            this.status = c.readChar();
        }
        docInfo[4] = String.valueOf(this.status);

        ArrayList<Doctor> doctorList = new ArrayList<>();
        Doctor doctor = new Doctor(docName, docQualifications, status);
        doctorList.add(doctor);

        try (BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath, true), StandardCharsets.UTF_8))) {

            if (new File(filePath).length() == 0) {
                
                for(int i = 0; i < label.length; i++){
                writer1.write(String.format("%-15s", label[i]));
            }
                writer1.newLine();
                writer1.write("--------------------");
                writer1.newLine();
            }

            for(int j = 0; j < docInfo.length; j++){
                writer1.write(String.format("%-15s",docInfo[j]));
            }

            writer1.newLine();
            c.println("Doctor's information written to file successfully.");
            
        } catch (IOException e) {
            c.println(e.getMessage());
        }
        return doctorList;
    }

    public void showDoctor() {
        try (BufferedReader reader1 = new BufferedReader(
                new FileReader(filePath))) {

            String docInfo;
            while ((docInfo = reader1.readLine()) != null) {
                c.println(docInfo);
            }
        } catch (IOException e) {
            c.println(e.getMessage());
        }
    }

    public void addPatientsToDoctor(Patient patient)
    {
        doctorPatientList.add(patient);
    }

    
}
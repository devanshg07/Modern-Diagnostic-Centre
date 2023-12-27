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

    String nameLABEL = "Name";
    String genderNameLABEL = "Gender";
    String qualificationsNameLABEL = "Qualifs";
    String licenseNumNameLabel = "License Num";
    String statusNameLABEL = "Status";

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

        c.print("Enter doctor's gender (M or F): ");
        this.docGender = c.readChar();

        if (!(this.docGender == 'M' || this.docGender == 'F')) {
            c.println("That didn't work, try again.");
            c.print("Enter doctor's gender (M or F): ");
            this.docGender = c.readChar();
        }

        c.print("Enter Doctor's qualifications (1.Cardiologist, 2.Radiologist, 3.Ophthalmologist, 4.Neurologist, 5.Dermatologist, 6.General Physician): ");
        int docQualificationsID = c.readInt();
        if(docQualificationsID == 1){
            docQualifications = "Cardiologist";
        } 
        else if(docQualificationsID == 2){
            docQualifications = "Radiologist";
        }
        else if(docQualificationsID == 3){
            docQualifications = "Ophthalmologist";
        }
        else if(docQualificationsID == 4){
            docQualifications = "Neurologist";
        }
        else if(docQualificationsID == 5){
            docQualifications = "Dermatologist";
        }
        else{
            docQualifications = "General Physician";
        }


        c.print("Enter doctor's license number: ");
        this.licNum = c.readInt();

        c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");
        this.status = c.readChar();

        if (!(this.status == 'A' || this.status == 'W' || this.status == 'N')) {
            c.println("That didn't work, try again. ");
            c.print("Enter Doctor's status (A for available, W for waiting, N for not available): ");
            this.status = c.readChar();
        }

        ArrayList<Doctor> doctorList = new ArrayList<>();
        Doctor doctor = new Doctor(docName, docQualifications, status);
        doctorList.add(doctor);

        try (BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath, true), StandardCharsets.UTF_8))) {

            if (new File(filePath).length() == 0) {
                writer1.write(String.format("%-15s", nameLABEL));
                writer1.write(String.format("%-15s", genderNameLABEL));
                writer1.write(String.format("%-15s", qualificationsNameLABEL));
                writer1.write(String.format("%-15s", licenseNumNameLabel));
                writer1.write(String.format("%-15s", statusNameLABEL));
                writer1.newLine();
                writer1.write("--------------------");
                writer1.newLine();
            }

            writer1.write(String.format("%-15s%-15s%-15s%-15s%-15s", this.docName, this.docGender,
                    this.docQualifications, this.licNum , this.status));
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

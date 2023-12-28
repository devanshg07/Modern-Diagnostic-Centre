import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import hsa.Console;

public class Appointment {

    private Console c; // introduce the console

    // employ the console in this class
    public Appointment(Console console) {
        this.c = console;
    }// console

    private String time; // string for appointment's time
    private String pName; // string for patient's name
    private String docName; // string for doctor name

    // getters and setters for all of the necessary variables
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void assignDoctor(String condition) {
        String[][] doctors = {{"Heart", "Cardiologist"},
                              {"Image Testing", "Radiologist"},
                              {"Eyes", "Optometrist"},
                              {"Brain", "Neurologist"},
                              {"Skin", "Dermatologist"},
                              {"General", "Physician"}
        };

        for (String[] doctor : doctors) {
            if (doctor[0].equalsIgnoreCase(condition)) {
                c.println(doctor[1] + " assigned to " + condition + " patient");
                setDocName(doctor[1]); // Assuming you want to set docName based on condition
                return;
            }
        }

        c.println("No matching doctor found for condition: " + condition);
    }

    public void generateReport() {
        // Assuming you have a method like getPatientList in your Patient class
        List<Patient> patientList = Patient.getPatientList();
        Patient patientName = new Patient(c);

        // Assuming you have a method like showPatient that prints patient information
        patientName.showPatient();

        String pName;
        c.print("Which patient's report to generate? ");
        pName = c.readLine();

        for (Patient patient : patientList) {
            if (patient.getpName().equals(pName)) {
                String filePath = pName + ".txt";
                assignDoctor(patient.getCondition());

                // Use try-with-resources to ensure the BufferedWriter is closed
                try (BufferedWriter writer3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), StandardCharsets.UTF_8))) {
                    writer3.write("Report for " + pName);
                    writer3.newLine();
                    writer3.write("Doctor Appointed: " + getDocName());
                    writer3.newLine();
                    writer3.write("Date: " + LocalDateTime.now());
                    writer3.newLine();
                    writer3.write("Patient Name: " + patient.getpName() + "\n" + "Patient Age: " + patient.getpAge() + "\n" + "Patient Gender: " + patient.getpGender() + "\n" + "Patient's Blood Group: " + patient.getpBloodGroup() + "\n" + "Patient's Phone Number: " + patient.getpContactNumber() + "\n" + "Patient's Location: " + patient.getpLocation() + "Patient Disease: " + patient.getCondition());
                } catch (Exception e) {
                    // Handle exceptions appropriately
                    e.printStackTrace();
                }
            }
        }

        // This line will print the name of the first patient in the list, adjust as needed
        c.println(patientList.get(0).getpName());
    }
}

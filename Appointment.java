import hsa.Console;
import java.io.*;
import java.util.List;
public class Appointment{

    private Console c;//introduce the console

    //employ the console in this class
    public Appointment(Console console) {
        this.c = console;
    }//console

    private String time;//string for appointment's time
    private String pName;//string for patient's name
    private String docName;//string for doctor name

    //getters and setters for all of the nessecary variables
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

    public void assignDoctor(List<Patient> patientsList, List<Doctor> doctorList){
        for(Patient patient: patientsList){
            for(Doctor doctor: doctorList){
                c.println(patient.getCondition());
                c.println(doctor.getDocQualifications());
                if(patient.getCondition().equals("Heart")){
                    if(doctor.getDocQualifications().equals("Cardiologist")){
                        doctor.addPatientsToDoctor(patient);
                        c.println("cardiologist assigned to Heart patient");
                    }
                }
                else if(patient.getCondition().equals("Image Testing")){
                    if(doctor.getDocQualifications().equals("Radiologist")){
                        doctor.addPatientsToDoctor(patient);
                        c.println("Radiologist assigned to image testing patient");
                    }
                }
                else if(patient.getCondition().equals("Eye")){
                    if(doctor.getDocQualifications().equals("Ophthalmologist")){
                        doctor.addPatientsToDoctor(patient);
                        c.println("Ophthalmologist assigned to eye patient");
                    }
                }
                else if(patient.getCondition().equals("Brain")){
                    if(doctor.getDocQualifications().equals("Neurologist")){
                        doctor.addPatientsToDoctor(patient);
                        c.println("Neurologist assigned to brain patient");
                    }
                }
                else if(patient.getCondition().equals("Skin")){
                    if(doctor.getDocQualifications().equals("Dermatologist")){
                        doctor.addPatientsToDoctor(patient);
                        c.println("Dermatologist assigned to skin patient");
                    }
                }
                else if(patient.getCondition().equals("General")){
                    if(doctor.getDocQualifications().equals("General Physician")){
                        doctor.addPatientsToDoctor(patient);
                        c.println("General Physician assigned to general patient");
                    }
                }

                
                
            }
        }
    }
}

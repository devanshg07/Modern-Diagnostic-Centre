import hsa.Console;
import java.io.*;
public class Appointment {

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
    public Appointment(String time, String pName, String docName) {
        this.time = time;
        this.pName = pName;
        this.docName = docName;
    }
}

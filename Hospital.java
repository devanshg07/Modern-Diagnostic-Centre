import hsa.Console;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hospital extends LoginUser{

    private Console c;//introduce console variable

    //employ the console in this class
    public Hospital(Console console) {
        super(console);
        this.c = console;
    }//console

    public void allAppointments(){
        List<Appointment> appointments = new ArrayList<>(); 
        if(getCurrentUser() == 0){
            c.println("Please login");
            return;
        }

        c.println("Available Appointments: ");

        for(Appointment appointment: appointments){
            c.println("Doctor: " + appointment.getDocName());
            c.println("Patient: " + appointment.getpName());
            c.println("Time: " + appointment.getTime());
        }
        
    }



}

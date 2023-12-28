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
}

import java.util.ArrayList;
import java.util.List;
import hsa.Console;

//this class introduces the user to the website and gives them further instructions for the use.
class MenuPage {
    private Console c;//consolse

    //new console object
    public MenuPage(Console console) {
        c = console;
    }//console

    //this method will introduces the user then gives instructions
    public void welcome() {

        ArrayList<Doctor> doctorList = new ArrayList<>();
        ArrayList <Patient> patientsList = new ArrayList<>();

        int option = 0;//integer for the user's input for the switch case

        //moves the text twice
        c.print("\t\t");
        // This for loop will add intriguing highphens 40 times
        for (int i = 1; i <= 40; i++) {
            c.print("-");
        }//for
        c.println();
        c.println("\t\t"+ "Welcome to the Modern Diagnostic Centre");//tells user where they are

        //moves the text twice
        c.print("\t\t");
        //this forloop will add another row 40 highphens 
        for (int j = 1; j <= 40; j++) {
            c.print("-");
        }//for
        c.println();//a gap line

        LoginUser loginUser = new LoginUser(c);//object to employ the login method
        loginUser.login();//employs the method from the other class after the introduction

        //create object to implement method
        Doctor doctor = new Doctor(c);

        //create object to implement method
        Patient patient = new Patient(c);

        //create object to implement method
        Appointment appointment = new Appointment(c);

        //this while loop will instruct the user
        while(true){
            //set of options for user input
            c.println("1: Add Doctors");
            c.println("2: Show Doctors");
            c.println("3: Add Patients");
            c.println("4: Show Patients");
            c.println("5: Show all available appointments");
            c.println("6: Generate Report");
            c.println("7: Logout");
            c.println("0: Exit");

            option = c.readInt();//variable for the switch case statement
            
            //this switch case statement will conduct a variety of methods through the user's input
            switch (option) {

                //exit the program
                case 0:
                System.exit(0);
                break; 

                //add a doctor to the text file
                case 1:
                doctorList = doctor.addDoctor();//add information to the file    
                break;
            
                //show the admin doctor's information
                case 2:                
                doctor.showDoctor();//read the file and then show everything to the user
                break;

                //add a patient to the text file
                case 3: 
                patientsList = patient.addPatient();//add information the the file
                break;

                //show admin information about the patients
                case 4: 
                patient.showPatient();//read the file and then show everything to the user
                break;

                //if the user wishes to return to the menu
                case 5:
                patient.setConditionID();
                String condition = patient.getCondition();
                appointment.assignDoctor(condition);
                break;

                //if the user wants to log out
                case 6:
                appointment.generateReport();
                break;
              
       
                case 7:
                 //use the object to implement the moethod
                loginUser.logOut();
                break;
                       
                //if the input is not between numbers 0-6
                default:
                c.println("Invalid please try again");
            }//switch
        
        }//while loop
    }//method
    }//class
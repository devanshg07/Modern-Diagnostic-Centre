import hsa.Console;

class MenuPage {
    private Console c;

    public MenuPage(Console console) {
        c = console;
    }

    public void welcome() {

        int option = 0;

        // This for loop will introduce the user to the website
        c.print("\t\t");
        for (int i = 1; i <= 40; i++) {
            c.print("-");
        }
        c.println();
        c.println("\t\t"+ "Welcome to the Modern Diagnostic Centre");

        c.print("\t\t");
        for (int j = 1; j <= 40; j++) {
            c.print("-");
        }
        c.println();

        LoginUser loginUser = new LoginUser(c);
        loginUser.login();

        while(true){
            c.println("1: Add Doctors");
            c.println("2: Show Doctors");
            c.println("3: Add Patients");
            c.println("4: Show Patients");
            c.println("5: Return to Menu");
            c.println("6: Logout");
            c.println("0: Exit");

            option = c.readInt();

            switch (option) {

                
                case 0:
                System.exit(0);
                break; 

                case 1:
                Doctor doctor1 = new Doctor(c);
                doctor1.addDoctor();    
                break;
            
                case 2:
                Doctor doctor2 = new Doctor(c);
                doctor2.showDoctor();
                    break;

                case 3: 
                Patient patient1 = new Patient(c);
                patient1.addPatient();
                break;

                case 4:
                Patient patient2 = new Patient(c);
                patient2.showPatient();
                break;

                case 5:
                break;

                case 6:
                loginUser.logOut();
                break;

                default:
                c.println("Invalid please try again");
            }
        
        }
    }
    }


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int check = 0;
        String email;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        email = sc.nextLine();
        System.out.println("Enter your password: ");
        password = sc.nextLine();
        Login session = new Login(email, password);
        check = session.authenticateUser();
        while (check == 1) {
            System.out.println("Invalid email or password, please enter email again: ");
            email = sc.nextLine();
            System.out.println("Enter your password: ");
            password = sc.nextLine();
            session.setEmail(email);
            session.setPassword(password);
            check = session.authenticateUser();
            // while check == 1 indicates invalid input, which should ask the user for valid inputs 2 more times
        }
        if (check == 2) {
            System.out.println("Too many failed attempts, please try again later.");
            // if check == 2, session times out and user must try again later
        } else {
            boolean check2 = false;
            if (check == 0) {
                check2 = session.verifyCredentials();
                // if check == 0, system verifies if credentials are in database
                if (check2 == true) {
                    String id = session.generateSessionID();
                    Dashboard current = new Dashboard(id);
                    current.openDashboard();
                    System.out.println("Enter route: "); 
                    String routeID = sc.nextLine(); 
                    current.showDashboard(routeID);
                    // if check2 is true, user accesses dashboard and enters route
                } else {
                    // rollback to authenticate user
                }
            }
        }
    sc.close();
    }
}
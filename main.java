import Login.java;

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
    }
    if (check == 2) {
        System.out.println("Too many failed attempts, please try again later.");
        boolean check2 = false;
        if (check == 0) {
            check2 = session.verifyCredentials();
            if (check2 == true) {
                String id = session.generateSessionID();
                openDashboard(id);
            }
        }
    }
    sc.close();
    
}
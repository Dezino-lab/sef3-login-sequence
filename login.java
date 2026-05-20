public class Login {
    private String email;
    private String password;
    private int counter = 0;

    public Login(String email, String password) {
        this.email = email;
        this.password  = password;
    }

    public int authenticateUser() {
        if (email == "") {
            counter += 1;
            if (counter == 3) {
                return 2;
            }
            return 0;
        }
        if (password == "") {
            counter += 1;
            if (counter == 3) {
                return 2;
            }
            return 0;
        }
        return 1;
        // if invalid email or password, return 0. if valid, return 1. if 0 has been returned 3 times, return 2.
    }
    
    public boolean verifyCredentials() {
        for (int i = 0; i < loginDatabase.length(); ++i) {
            if (email == loginDatabase[i][0]) {
                if (password == loginDatabase[i][1]) {
                    return true;
                }
            }
        }
        return false;
        // if login details in database, return true to allow access
    }

    public String generateSessionID() {
        return "17399388fdcffe9";
        // generate random hexadecimal session id
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
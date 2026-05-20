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
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
public class login {
    private String email;
    private String password;
    private int counter = 0;

    public login(String email, String password) {
        this.email = email;
        this.password  = password;
    }
    public int loginattempt() {
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
    
    public boolean authentication() {
        if (email == "") {
            return false;
        }
        if (password == "") {
            return false;
        }
        return true;
    }
}
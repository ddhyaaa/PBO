package posstest2;
public abstract class Akun {
    protected String Username;
    protected String Password;

    public Akun(String Usernames, String Passwords) {
        this.Username = Usernames;
        this.Password = Passwords;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public abstract void displayUserInfo();
}

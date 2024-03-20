package posstest2;

public class Akun {
    protected String Username;
    protected String Password;

    public Akun (String Usernames, String Passwords){
        this.Username = Usernames;
        this.Password = Passwords;
    }

    public String getUsername(){
        return Username;
    }

    public String getPassword(){
        return Password;
    }
}



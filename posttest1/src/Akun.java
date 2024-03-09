public class Akun {
    String Username;
    String Password;

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



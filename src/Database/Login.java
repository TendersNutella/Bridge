package Database;

public class Login {
    private int id;
    private String username;
    private String passwordHash;

    public Login(int id, String username){
        this(username);
        this.id = id;
    }

    public Login(String username){
        this.username = username;
    }

    public int GetId(){
        return id;
    }
    public void SetId(int id){
        this.id = id;
    }

    public String GetUsername(){
        return username;
    }
    public void SetUsername(String username){
        this.username = username;
    }

    public String GetPassword(){
        return passwordHash;
    }
    public void SetPassword(String password){
        this.passwordHash = password;
    }

    // Overwrite the toString method that already exist
    @Override
    public String toString(){
        return "Login{" +
                "id =" + id +
                ", username ='" + username + '\'' +
                // ", password =" + passwordHash +
                '}';
    }
}

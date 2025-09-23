package Database;

public class Login {
    private int id;
    private String username;
    private String password;

    public Login(int id, String username, String password){
        this(username, password);
        this.id = id;
    }

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public int GetId(){
        return id;
    }

    public String GetUsername(){
        return username;
    }

    public String GetPassword(){
        return password;
    }

    public void SetId(int id){
        this.id = id;
    }

    public void SetUsername(String username){
        this.username = username;
    }

    public void SetPassword(String password){
        this.password = password;
    }

    // Overwrite the toString method that already exist
    @Override
    public String toString(){
        return "Login{" +
                "id =" + id +
                ", username ='" + username + '\'' +
                ", password =" + password +
                '}';
    }
}

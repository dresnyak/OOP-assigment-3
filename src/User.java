public class User {
    private int age;
    private String pass;
    private String email;
    private String name;
    private String surname;
    public int getAge(){
        return this.age;
    }
    public String getPass(){
        return this.pass;
    }
    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setEmail(String mail){
        this.email = mail;
    }
    public void setName(String x){
        this.name = x;
    }
    public void setSurname(String x){
        this.surname = x;
    }
    public void setAge(int x){
        this.age = x;
    }
    public void setPass(String x){
        this.pass = x;
    }
    public User(String email, String name, String surname, int age, String pass){
        setEmail(email);
        setName(name);
        setSurname(surname);
        setAge(age);
        setPass(pass);
    }
    public User(){

    }
    public String toString(){
        return this.getEmail() + ' ' + this.getSurname() + ' ' + this.getName() + ' ' + this.getAge() + ' ' + this.getPass();
    }
}

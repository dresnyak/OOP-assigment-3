import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
public class DBWork {
    public Statement getCon() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/java3";
            Properties authorization = new Properties();
            authorization.put("user", "postgres");
            authorization.put("password", "123123");
            Connection conn = DriverManager.getConnection(url, authorization);
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            //System.out.println("asdasdasd");
            return statement;

        }
        catch(Exception e){
            System.out.println("Connection lost");
        }
        return null;
    }
    public void InsertUser(User user){
        Statement statement = getCon();
        try{
            String query = "INSERT INTO users VALUES('" + user.getEmail() + "', '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getPass() + "', '" + user.getAge() + "'" + ")";
            ResultSet table = statement.executeQuery(query);
            //System.out.println("djbh");
        }catch(Exception e){

        }
    }
    public User CurrUser(String email){
        Statement statement = getCon();
        try{
            String query = "SELECT * FROM users WHERE email = " + "'" + email + "'";
            ResultSet table = statement.executeQuery(query);
            User currUser = new User();
            table.beforeFirst();
            while(table.next()){
                currUser.setEmail(table.getString(1));
                currUser.setName(table.getString(2));
                currUser.setSurname(table.getString(3));
                currUser.setPass(table.getString(4));
                currUser.setAge(Integer.parseInt(table.getString(5)));
                return currUser;
            }
        }catch(Exception e){
            //System.out.println(e);
        }
        return null;
    }
    public void ChangePass(User user, String currPass, String newPass) {
        Statement statement = getCon();
        System.out.println("asdasdasd");
        try{
            //System.out.println(user.getPass().equals(currPass) + "  asdasd");
            if(user.getPass().equals(currPass)){
                String query = "UPDATE users SET pass = '" + newPass + "' WHERE email = '" + user.getEmail() + "'";
                statement.executeQuery(query);
                user.setPass(newPass);
                System.out.println("Пароль успешно изменен!");
            }
            else{
                System.out.println("Неправильный пароль");
            }
        } catch (Exception e){
            //System.out.println(e);
        }
    }
    public void delUser(User user){
        Statement statement = getCon();
        try{
            String query = "DELETE FROM users WHERE email = " + "'" + user.getEmail() + "'";
            //System.out.println(query);
            ResultSet a = statement.executeQuery(query);
        }
        catch(Exception e){
            //System.out.println(e);
        }
    }
    public boolean checkPass(User user, String pass){
        Statement statement = getCon();
        try{
            String query = "SELECT pass FROM users WHERE email = " + "'" + user.getEmail() + "'";
            ResultSet table = statement.executeQuery(query);
            String RealPass = "";
            while (table.next()) {
                RealPass = table.getString(1);
                break;
            }
            System.out.println(RealPass);
            if (RealPass.equals(pass)){
                return true;
            } else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}

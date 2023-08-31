import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root","");
            System.out.println(con);
        }catch (Exception e){
            System.out.println("NO Connection Was made");
        }
    }
}
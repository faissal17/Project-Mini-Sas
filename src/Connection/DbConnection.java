package Connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection con;
    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("NO Connection Was made");
        }
    }
    public static Connection getConnection() {
        return con;
    }
}

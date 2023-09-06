package Connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection con;
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("NO Connection Was made");
        }
        return con;
    }
}

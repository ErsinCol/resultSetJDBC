import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String userName="root";
    private String password="Ersin1905.";
    private String dbUrl="jdbc:mysql://localhost:3306/world";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }

    public void showError(SQLException sqlException){
        System.out.println("error: "+sqlException.getMessage());
        System.out.println("error code: "+sqlException.getErrorCode());
    }

}

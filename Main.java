import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException{
        Connection connection=null;
        DBHelper dbHelper=new DBHelper();
        // SELECT İFADESİNİ JAVADA KULLANMA
        // STATEMENT İFADE DEMEKTİR
        // RESULTSET SONUÇ TOPLULUĞU DEMEKTİR
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection=dbHelper.getConnection();
            statement=connection.createStatement(); // yeni bir ifade yarat
            resultSet=statement.executeQuery("select Code,Name,Region,Population from world.country"); // sorguyu çalıştır
            ArrayList<Country> countries=new ArrayList<Country>();// nesnelere veritabanındaki verilerin aktarılması
            while (resultSet.next()){
                countries.add(new Country(resultSet.getString("Code"),resultSet.getString("Name"),resultSet.getString("Region"),resultSet.getString("Population")));
            }
           System.out.println(countries.size());
        } catch (SQLException e) {
            dbHelper.showError(e);
        }
        finally {
            connection.close();
        }
    }
}

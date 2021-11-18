import java.sql.*;
import com.mysql.jdbc.Driver;
public class Main {
    public static void main(String[] args) throws SQLException {
        try{
           // Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database?"+ "user=root&password=1234");
          Connection con = Database.getInstance().getConnection();
            PreparedStatement stmt=con.prepareStatement("insert into users values(?,?)");
            stmt.setInt(1,1);
            stmt.setInt(2,123);

            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}

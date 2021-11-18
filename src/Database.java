import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static Database dbIsntance;
    private static Connection con;
    private static Statement stmt;


    private Database() {
        // private constructor //
    }

    public static Database getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new Database();
        }
        return dbIsntance;
    }

    public Connection getConnection() throws SQLException {
        if (con == null) {
            if (con.isClosed()) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String host = "jdbc:mysql://localhost:3306/database";
                    String username = "root";
                    String password = "1234";
                    con = DriverManager.getConnection(host, username, password);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return con;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();

        } catch (SQLException e) {

        }
    }
}
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into users values(?)");
            stmt.setInt(1, 1);

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }
}

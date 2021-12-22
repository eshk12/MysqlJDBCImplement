import java.sql.*;

public class Main {

    public static void createUser(String username, String password) throws SQLException{
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection(); // get connection
            PreparedStatement myQuery = con.prepareStatement("insert into users (`username`,`password`) values (?,?)");
            myQuery.setString(1, username);
            myQuery.setString(2, password);

            int i = myQuery.executeUpdate();
            System.out.println(i + " records inserted");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    public static void getAllUsers() throws SQLException {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement myQuery = con.createStatement();
            String QUERY = "select * from `users`";
            ResultSet rs = myQuery.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(rs.getInt("userid") + ":" + rs.getString("username") + ":" + rs.getString("password"));
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(con != null){
                con.close();
            }
        }
    }

    public static void getUser(int id) throws SQLException {
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            Statement myQuery = con.createStatement();
            String QUERY = String.format("select * from `users` where `userid` = '%d'", id);
            ResultSet rs = myQuery.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(rs.getInt("userid") + ":" + rs.getString("username") + ":" + rs.getString("password"));
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(con != null){
                con.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        /*createUser("snir","1234567");
        createUser("snir","1234567");
        createUser("snir","1234567");*/
        //getAllUsers();
        getUser(3);

    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Insert {
    public static void main(String[] args) {
       
        
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:axizdb", "axizuser", "axiz");

            // SQL query string
            String sql = "UPDATE products SET price = ? where product_id = ?";

            // create statement
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, 60);
            stmt.setInt(2, 101);
            // execute
            stmt.executeUpdate();
            // output
            System.out.println("更新しました");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

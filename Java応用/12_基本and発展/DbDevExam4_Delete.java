import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Delete {
    public static void main(String[] args) {
       
        
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:axizdb", "axizuser", "axiz");

            // SQL query string
            String sql = "delete from products where product_name = ?";

            // create statement
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, "ボールペン");
            // execute
            stmt.executeUpdate();
            // output
            System.out.println("削除しました");
            
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

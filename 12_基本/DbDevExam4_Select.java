import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDevExam4_Select {
    public static void main(String[] args) {
       
        
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:axizdb", "axizuser", "axiz");

            // SQL query string
            String sql = "SELECT *  FROM products";

            // create statement
            stmt = con.prepareStatement(sql);
      
            // execute
            ResultSet rs = stmt.executeQuery();
            int a = 0;;
            // output
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int price = rs.getInt("price");

                System.out.print("product_id:" + id);
                System.out.print(",product_name:" + name);
                System.out.println(", price:" + price);
                a += price;
            }
            System.out.println("合計金額:" + a);
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

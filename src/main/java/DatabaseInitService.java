import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        try (PreparedStatement pStmt = Database.getInstance().getConnection().prepareStatement(reader.sqlQueryFromFileReader("init_db.sql"))) {
            pStmt.executeUpdate();
            System.out.println("Table creation successful");
            Database.getInstance().disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to create tables, SQL error: " + e.getMessage());
        }
    }
}

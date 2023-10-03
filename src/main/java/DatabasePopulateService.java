import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        try (PreparedStatement pStmt = Database.getInstance().getConnection().prepareStatement(reader.sqlQueryFromFileReader("populate_db.sql"))) {
            pStmt.executeUpdate();
            System.out.println("Filling of the table is successful");
            Database.getInstance().disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to fill tables, SQL error: " + e.getMessage());
        }
    }
}

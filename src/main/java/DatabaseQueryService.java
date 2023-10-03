import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class DatabaseQueryService {
    FileReader reader = new FileReader();
    private final Connection conn;

    {
        try {
            conn = Database.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public record MaxSalaryWorker(String name, int salary) {
    }

    public record MaxProjectsClient(String name, int projectCount) {
    }

    public record LongestProject(String name, int monthCount) {
    }

    public record YoungestEldestWorkers(String type, String name, LocalDate birthday) {
    }

    public record ProjectPrices(String name, int price) {
    }
    public List<YoungestEldestWorkers>  findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> list = new ArrayList<>();
        try (PreparedStatement pStmt = conn.prepareStatement(reader.sqlQueryFromFileReader("find_youngest_eldest_workers.sql"));
             ResultSet resultSet = pStmt.executeQuery()) {

            while (resultSet.next()) {
                list.add(new YoungestEldestWorkers(resultSet.getString("TYPE"),
                        resultSet.getString("NAME"),
                        LocalDate.parse(resultSet.getString("birthday"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        return list;
    }
    public List<MaxSalaryWorker>  findMaxSalaryWorker() {
        List<MaxSalaryWorker> list = new ArrayList<>();
        try (PreparedStatement pStmt = conn.prepareStatement(reader.sqlQueryFromFileReader("find_max_salary_worker.sql"));
             ResultSet resultSet = pStmt.executeQuery()) {

            while (resultSet.next()) {
                list.add(new MaxSalaryWorker(resultSet.getString("NAME"), resultSet.getInt("SALARY")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        return list;
    }
    public List<MaxProjectsClient>  findMaxProjectsClient() {
        List<MaxProjectsClient> list = new ArrayList<>();
        try (PreparedStatement pStmt = conn.prepareStatement(reader.sqlQueryFromFileReader("find_max_projects_client.sql"));
             ResultSet resultSet = pStmt.executeQuery()) {

            while (resultSet.next()) {
                list.add(new MaxProjectsClient(resultSet.getString("NAME"), resultSet.getInt("PROJECT_COUNT")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        return list;
    }
    public List<LongestProject>  findLongestProject() {
        List<LongestProject> list = new ArrayList<>();
        try (PreparedStatement pStmt = conn.prepareStatement(reader.sqlQueryFromFileReader("find_longest_project.sql"));
             ResultSet resultSet = pStmt.executeQuery()) {

            while (resultSet.next()) {
                list.add(new LongestProject(resultSet.getString("NAME"), resultSet.getInt("MONTH_COUNT")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        return list;
    }
    public List<ProjectPrices> findProjectPrices() {
        List<ProjectPrices> list = new ArrayList<>();
        try (PreparedStatement pStmt = conn.prepareStatement(reader.sqlQueryFromFileReader("print_project_prices.sql"));
             ResultSet resultSet = pStmt.executeQuery()) {

            while (resultSet.next()) {
                list.add(new ProjectPrices(resultSet.getString("NAME"), resultSet.getInt("PRICE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        return list;
    }
}

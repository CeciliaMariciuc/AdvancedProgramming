import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController implements ArtistDAO {
    public void create(String name, String country) {
        Connection connection = Database.getConnection();
        String query = "insert into artists values (DEFAULT, '" + name + "','" + country + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void findByName(String name) {
        Connection connection = Database.getConnection();
        String query = "select * from artists where name='" + name + "';";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " -> " + resultSet.getString(3));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

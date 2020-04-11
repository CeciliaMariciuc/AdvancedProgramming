import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController implements AlbumDAO {

    public void create(String name, int artistId, int releaseYear) {
        Connection connection = Database.getConnection();
        String query = "insert into albums values (DEFAULT, '" + name + "','" + releaseYear + "','" + artistId + "');";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void findByArtist(int artistId) {
        Connection connection = Database.getConnection();
        String query = "select * from albums where artist_id='" + artistId + "';";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " - an: " + resultSet.getString(3));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

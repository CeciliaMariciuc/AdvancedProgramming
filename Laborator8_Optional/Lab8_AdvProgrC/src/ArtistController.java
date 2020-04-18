import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistController {
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

    public Artist findById(int id){
        Connection connection = Database.getConnection();
        String query = "select * from artists where id='" + id + "';";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                return new Artist(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2), resultSet.getString(3));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public List<Artist> findByName(String name) {
        Connection connection = Database.getConnection();
        String query = "select * from artists where name='" + name + "';";
        List<Artist> artistList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Artist artist = new Artist(Integer.parseInt(resultSet.getString(1)),resultSet.getString(2), resultSet.getString(3));
                artistList.add(artist);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return artistList;
    }
}

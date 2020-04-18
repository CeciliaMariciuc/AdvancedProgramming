import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumController  {

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

    public Album findById(int id){
        Connection connection = Database.getConnection();
        String query = "select * from albums where id='" + id + "';";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                return new Album(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
                        Integer.parseInt(resultSet.getString(4)), Integer.parseInt(resultSet.getString(3)));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public List<Album> findByArtist(int artistId) {
        Connection connection = Database.getConnection();
        String query = "select * from albums where artist_id='" + artistId + "';";
        List<Album> albumList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Album album = new Album(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
                        Integer.parseInt(resultSet.getString(3)), Integer.parseInt(resultSet.getString(4)));
                albumList.add(album);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return albumList;
    }
}

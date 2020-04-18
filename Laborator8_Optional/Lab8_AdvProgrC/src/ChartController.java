import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class ChartController {

    public void create(Chart chart, Album album, int rank) {
        Connection connection = Database.getConnection();
        String query = "insert into charts values (DEFAULT, '" + album.getId() + "','" + rank + "','" + chart.getId() + "');";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            chart.addAlbum(album, rank);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public void displayRanking(Chart chart) {
        Map<Album, Integer> albumsChart = chart.getAlbums();
        List<Integer> artistList = new ArrayList<>();
        ArtistController artistController = new ArtistController();
        Set<Map.Entry<Album, Integer>> set = albumsChart.entrySet();

        //sumele rankurilor albumelor pt fiecare artist care are cel putin un album in chart
        Map<Integer, Integer> scoreArtists = new HashMap<>();
        //nr de albume ale artistilor din chart
        Map<Integer, Integer> nrAlbumsPerArtist = new HashMap<>();

        for (Map.Entry<Album, Integer> albumEntry : set) {
            Album album = albumEntry.getKey();
            Integer rank = albumEntry.getValue();
            Artist artist = artistController.findById(album.getArtistId());
            if (!artistList.contains(artist.getId())) {
                artistList.add(artist.getId());
                scoreArtists.put(artist.getId(), rank);
                nrAlbumsPerArtist.put(artist.getId(), 1);
            } else {
                Integer score = scoreArtists.get(artist.getId());
                Integer nrAlbums = nrAlbumsPerArtist.get(artist.getId());
                scoreArtists.replace(artist.getId(), score, score + rank);
                nrAlbumsPerArtist.replace(artist.getId(), nrAlbums, nrAlbums + 1);
            }
        }
        //calculez rank-urile medii pt artisti
        Map<Integer, Integer> mediumRanks = new HashMap<>();
        for (Integer artist_id : scoreArtists.keySet()) {
            Integer medium_rank = scoreArtists.get(artist_id) / nrAlbumsPerArtist.get(artist_id);
            mediumRanks.put(artist_id, medium_rank);

        }
        Map<Integer, Integer> top =
                mediumRanks.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Integer artist_id : top.keySet()) {
            System.out.println(artistController.findById(artist_id));
        }
    }
}

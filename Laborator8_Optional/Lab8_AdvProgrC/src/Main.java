import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

public class Main {
    public static List<Chart> generateFakeData(int nrArtists, int nrAlbums, int nrCharts) {
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();
        ChartController chartController = new ChartController();
        Faker faker = new Faker();
        //Random Artists
        for (int i = 0; i < nrArtists; i++) {
            artistController.create(faker.name().firstName(), faker.address().country());
        }
        //Random Albums
        for (int i = 0; i < nrAlbums; i++) {
            Random randomArtist = new Random();
            Random randomYear = new Random();
            albumController.create(faker.funnyName().name(), randomArtist.nextInt(nrArtists) + 1, randomYear.nextInt(121) + 1900);
        }
        //Random Charts
        List<Chart> charts = new ArrayList<>();
        for (int i = 0; i < nrCharts; i++) {
            List<Integer> ranks = IntStream.rangeClosed(1, nrAlbums).boxed().collect(Collectors.toList());
            List<Integer> availableAlbums = IntStream.rangeClosed(1, nrAlbums).boxed().collect(Collectors.toList());
            Random random = new Random();
            Chart chart = new Chart(i);
            //nr. de albume dintr-un chart:
            int nrAlbumsInChart = random.nextInt(nrAlbums) + 1;
            for (int nr = 0; nr < nrAlbumsInChart; nr++) {
                Random randomA = new Random();
                //rank-ul albumului
                int posRank = randomA.nextInt(ranks.size());
                int rank = ranks.get(posRank);
                ranks.remove(posRank);
                //alegerea random a albumului
                int posAlbum = randomA.nextInt(availableAlbums.size());
                int albumId = availableAlbums.get(posAlbum);
                availableAlbums.remove(posAlbum);

                chartController.create(chart, albumController.findById(albumId), rank);
            }
            charts.add(chart);
        }
        return charts;
    }

    public static void main(String[] args) {
        /* COMPULSORY
        ArtistController artistController = new ArtistController();
        artistController.create("Michael Jackson", "SUA");
        artistController.create("Adele", "UK");
        artistController.findByName("Michael Jackson");

        AlbumController albumController = new AlbumController();
        System.out.println("Albume:");
        albumController.create("Thriller", 8, 1982);
        albumController.create("Bad", 8, 1987);
        albumController.create("Album", 9, 2011);
        albumController.create("Dangerous", 8, 1991);
         */
        //OPTIONAL

        ChartController chartController = new ChartController();
        List<Chart> charts = Main.generateFakeData(5, 10, 2);
        // System.out.println(charts.get(0));
        // System.out.println(charts.get(1));
        System.out.println("Clasamentul conform chart-ului 0 este:");
        chartController.displayRanking(charts.get(0));
        System.out.println("Clasamentul conform chart-ului 1 este:");
        chartController.displayRanking(charts.get(1));
    }
}

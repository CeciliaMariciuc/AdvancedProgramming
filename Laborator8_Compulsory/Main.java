import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ArtistController artistController = new ArtistController();
        // artistController.create("Michael Jackson", "SUA");
        // artistController.create("Adele", "UK");
        artistController.findByName("Michael Jackson");

        AlbumController albumController = new AlbumController();
        System.out.println("Albume:");
        //albumController.create("Thriller", 8, 1982);
        //albumController.create("Bad",8,1987);
        //albumController.create("Album",9,2011);
        //albumController.create("Dangerous",8,1991);
        albumController.findByArtist(8);

        artistController.create("Test", "Romania");
        albumController.create("AlbumTest",9,2020);
        Database.closeConnection();
    }
}

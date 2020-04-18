import java.util.HashMap;
import java.util.Map;

public class Chart {
    private Integer id;
    private Map<Album, Integer> albums = new HashMap<>();

    public Chart(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Album, Integer> getAlbums() {
        return albums;
    }

    public void setAlbums(Map<Album, Integer> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album, Integer rank){
        albums.put(album,rank);
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", albums=" + albums +
                '}';
    }
}

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private void testCreateSave() {
        Catalog catalog =
                new Catalog("Java Resources", "C:\\Users\\cecil\\OneDrive\\Desktop\\An_2\\Adv_Progr\\TestLab5\\catalog.ser");
        Document document = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addTag("type", "Slides");
        catalog.addDocument(document);

        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testLoadView() {
        Catalog catalog = null;
        try {
            catalog = CatalogUtil.load("C:\\Users\\cecil\\OneDrive\\Desktop\\An_2\\Adv_Progr\\TestLab5\\catalog.ser");
        } catch (InvalidCatalogException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        Document document = null;
        if (catalog != null) {
            document = catalog.findById("java1");
        }
        try {
            CatalogUtil.view(document);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }
}

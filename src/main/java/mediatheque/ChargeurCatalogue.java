package mediatheque;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class ChargeurCatalogue {
    /** Lit un fichier contenant un titre par ligne. */
    public static List<String> chargerTitres(Path chemin) throws CatalogueCorrompuException {
        Objects.requireNonNull(chemin, "Le chemin ne peut pas être null");
        try (var lecteur = Files.newBufferedReader(chemin)) { // fermeture garantie
            return lecteur.lines().toList();
        } catch (IOException e) {
            throw new CatalogueCorrompuException("Échec du chargement : " + chemin, e); // message + cause
        }
    }
}

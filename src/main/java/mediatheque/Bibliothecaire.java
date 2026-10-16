package mediatheque;

import java.util.Optional;
import java.util.Objects;

public class Bibliothecaire {
    private final String nom;
    private final Catalogue<Document> catalogue; // COMPOSITION

    public Bibliothecaire(String nom, Catalogue<Document> catalogue) {
        this.nom = Objects.requireNonNull(nom, "Le nom ne peut pas être null");
        if (nom.isBlank()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        this.catalogue = Objects.requireNonNull(catalogue, "Le catalogue ne peut pas être null");
    }

    public void accueillir() { System.out.println("Bonjour, " + nom); }

    // DELEGATION : on n'expose que ce qui a du sens pour un bibliothecaire
    public Optional<Document> chercher(String titre) {
        return catalogue.rechercherParTitre(titre);
    }
}

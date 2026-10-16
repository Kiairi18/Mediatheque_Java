package mediatheque;

import java.util.Objects;

public abstract class Document implements Comparable<Document> {
    protected final String titre;
    protected final int annee;

    protected Document(String titre, int annee) {
        this.titre = Objects.requireNonNull(titre, "Le titre ne peut pas être null");
        if (titre.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
        if (annee <= 0) {
            throw new IllegalArgumentException("L'année doit être positive");
        }
        this.annee = annee;
    }

    public String getTitre() { return titre; }

    public abstract String descriptionCourte();

    @Override
    public int compareTo(Document autre) {
        return titre.compareToIgnoreCase(autre.titre);
    }
}

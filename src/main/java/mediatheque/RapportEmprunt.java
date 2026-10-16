package mediatheque;

import java.util.ArrayList;
import java.util.List;

public class RapportEmprunt implements AutoCloseable {
    private final List<String> titres = new ArrayList<>();
    private boolean ferme = false;

    public void enregistrer(String titre) {
        if (ferme) {
            throw new IllegalStateException("Le rapport est déjà fermé");
        }
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
        titres.add(titre);
    }
    public List<String> getTitres() { return List.copyOf(titres); }
    public boolean estFerme() { return ferme; }

    @Override
    public void close() {
        ferme = true;
        System.out.println("Rapport fermé : " + titres.size() + " emprunt(s)");
    }
}

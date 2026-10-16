package mediatheque;

import java.util.Objects;

public class Livre extends Document implements Empruntable {
    private final String auteur;
    private final int nbPages;
    private boolean disponible = true;

    public Livre(String titre, int annee, String auteur, int nbPages) {
        super(titre, annee);
        this.auteur = Objects.requireNonNull(auteur, "L'auteur ne peut pas être null");
        if (auteur.isBlank()) {
            throw new IllegalArgumentException("L'auteur ne peut pas être vide");
        }
        if (nbPages <= 0) {
            throw new IllegalArgumentException("Le nombre de pages doit être positif");
        }
        this.nbPages = nbPages;
    }

    @Override
    public String descriptionCourte() {
        return "[Livre] " + titre + " (" + annee + "), " + auteur + ", " + nbPages + " p.";
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (!disponible) throw new DocumentIndisponibleException(titre);
        disponible = false;
    }

    @Override public void rendre() { 
        disponible = true; 
    }
    @Override public boolean estDisponible() { 
        return disponible; 
    }
}

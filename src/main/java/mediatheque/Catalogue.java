package mediatheque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Catalogue<T extends Document> implements Iterable<T> {
    private final List<T> documents = new ArrayList<>();

    public void ajouter(T doc) {
        documents.add(Objects.requireNonNull(doc, "Le document ne peut pas être null"));
    }

    public int taille() {
        return documents.size();
    }

    public Optional<T> rechercherParTitre(String titre) {
        if (titre == null || titre.isBlank()) {
            return Optional.empty();
        }

        String titreRecherche = titre.trim();
        if (titreRecherche.isEmpty()) {
            return Optional.empty();
        }

        return documents.stream()
                .filter(d -> d.getTitre().equalsIgnoreCase(titreRecherche))
                .findFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return Collections.unmodifiableList(documents).iterator();
    }

    /* public void afficherTout() {
        documents.forEach(d -> System.out.println(d.descriptionCourte()));
    } */

    public static <T extends Comparable<T>> T max(List<T> liste) {
        if (liste == null || liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne peut pas être vide");
        }

        T max = liste.get(0);
        for (T element : liste) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
}

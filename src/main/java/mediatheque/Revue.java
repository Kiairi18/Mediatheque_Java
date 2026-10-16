package mediatheque;

public class Revue extends Document {
    private final int numero;

    public Revue(String titre, int annee, int numero) {
        super(titre, annee);
        if (numero <= 0) {
            throw new IllegalArgumentException("Le numéro doit être positif");
        }
        this.numero = numero;
    }

    @Override
    public String descriptionCourte() {
        return "[Revue] " + titre + " (" + annee + "), n°" + numero;
    }
}

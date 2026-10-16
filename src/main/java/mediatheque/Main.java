package mediatheque;

public class Main {
    public static void main(String[] args) {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre("Clean Code", 2008, "R. Martin", 464));
        c.ajouter(new Revue("Science", 2026, 412));
        System.out.println("Documents au catalogue : " + c.taille());
        for (Document document : c) {
            System.out.println(document.descriptionCourte());
        }

        EmpruntManager m = new EmpruntManager(c);
        try {
            m.emprunter("Clean Code");
            System.out.println("Emprunt réussi");
            m.emprunter("Clean Code"); // lève l'exception
        } catch (MediathequeException e) {
            System.out.println("Erreur métier : " + e.getMessage());
        }
    }
}

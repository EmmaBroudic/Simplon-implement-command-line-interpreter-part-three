import java.util.Scanner;

public class CommandLine {

    // Déclaration de deux champs de type String
    private String fieldOne;
    private String fieldTwo;

    // Constructeur de la classe
    public CommandLine() {
        // Initialisation des champs
        fieldOne = "Première chaîne";
        fieldTwo = "Deuxième chaîne";
    }

    // Méthode pour afficher les valeurs des champs
    public void printFields() {
        System.out.println("Champ 1 : " + fieldOne);
        System.out.println("Champ 2 : " + fieldTwo);
    }

    public static void main(String[] args) {
        // Création d'une instance de la classe CommandLine
        CommandLine field = new CommandLine();

        // Création d'un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de saisir une nouvelle valeur
        System.out.print("Entrez une nouvelle valeur pour Champ 1 et Champ 2 : ");
        String input = scanner.nextLine();

        // Divise l'entrée en mots
        String[] words = input.split(" ");

        // Vérifie s'il y a au moins deux mots dans l'entrée
        if (words.length >= 2) {
            // Met à jour la valeur de fieldOne avec le premier mot
            field.fieldOne = words[0];

            // Met à jour la valeur de fieldTwo avec le deuxième mot
            field.fieldTwo = words[1];
        } else {
            System.out.println("L'entrée doit contenir au moins deux mots pour mettre à jour Champ 1 et Champ 2.");
        }

        // Ferme le scanner
        scanner.close();

        // Appel de la méthode pour afficher les champs mis à jour
        field.printFields();
    }
}
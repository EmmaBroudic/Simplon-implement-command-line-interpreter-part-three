import java.util.Scanner;

public class CommandLine {

    // Déclaration de deux champs de type String
    private String fieldOne;
    private String fieldTwo;

    // Constructeur de la classe
    public CommandLine(String input) {

        String[] words = input.split(" ");

        if (words.length >= 2) {
            // Met à jour la valeur de fieldOne avec le premier mot
            fieldOne = words[0];

            // Met à jour la valeur de fieldTwo avec le deuxième mot
            fieldTwo = words[1];
        } else if (words.length == 1) {
            // Met à jour la valeur de fieldOne avec le premier mot
            fieldOne = words[0];

            // Met à jour la valeur de fieldTwo avec le deuxième mot
            fieldTwo = null;
	}
    }

    // Méthodes requêtes
    public String getCommand() {
        return fieldOne;
    }

    public String getArgument() {
        return fieldTwo;
    }

    // Lecture de l'input
    public static void main(String[] args) {
        // Création d'un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de saisir une nouvelle valeur
        System.out.print("Entrez une nouvelle valeur pour Champ 1 et Champ 2 : ");
        String input = scanner.nextLine();

        // Création d'une instance de la classe CommandLine avec l'entrée utilisateur
        CommandLine field = new CommandLine(input);

        // Ferme le scanner
        scanner.close();
	}
}
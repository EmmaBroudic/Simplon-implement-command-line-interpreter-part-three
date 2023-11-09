import java.util.Scanner; // Importe la classe Scanner du package java.util

public class CommandLine {

    private String command; // Stocke la commande saisie
    private String argument; // Stocke l'argument associé à la commande

    // Constructeur prenant en entrée une chaîne de caractères
    public CommandLine(String input) {
        String[] words = input.split(" ", 2); // Divise la chaîne en mots en utilisant l'espace comme séparateur, limité à 2 éléments

        // Vérifie le nombre de mots extraits
        if (words.length >= 2) {
            command = words[0];
            argument = words[1];
        } else if (words.length == 1) {
            command = words[0];
            argument = null;
        }
    }

    // Méthode pour obtenir la commande
    public String getCommand() {
        return command;
    }

    // Méthode pour obtenir l'argument
    public String getArgument() {
        return argument;
    }

    // Méthode pour vérifier s'il y a un argument
    public boolean hasArgument() {
        if (argument == null) {
            return false;
        } else {
            return true;
        }
    }
}
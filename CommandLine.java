import java.util.Scanner;

class CommandLine {

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

        // Appel de la méthode pour afficher les champs
        field.printFields();
    }
}
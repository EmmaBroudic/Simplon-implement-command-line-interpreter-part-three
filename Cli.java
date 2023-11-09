import java.util.Scanner;

public class Cli {
    public static void main(String[] args) {
        // Crée un Scanner pour lire l'entrée utilisateur depuis la console
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Affiche un prompt pour l'utilisateur

        // Boucle principale pour l'interaction avec l'utilisateur
        while (true) {
            String userInput = scanner.nextLine(); // Récupère la saisie de l'utilisateur

            // Crée une instance de la classe CommandLine en utilisant l'entrée utilisateur
            CommandLine commandLineInput = new CommandLine(userInput);

            // Récupère la commande à partir de l'instance CommandLine
            String command = commandLineInput.getCommand();

            StringBuilder output = new StringBuilder(); // Initialise un objet pour stocker la sortie

            // Vérifie les différentes commandes saisies par l'utilisateur
            if (command.equals("exit") || command.equals("logout")) {
                // Si la commande est "exit" ou "logout", quitte la boucle
                break;
            } else {
                // Traite les différentes commandes disponibles
                if (command.equals("date")) {
                    output.append(Commands.date()); // Appelle la méthode pour afficher la date
                } else if (command.equals("time")) {
                    output.append(Commands.time()); // Appelle la méthode pour afficher l'heure
                } else if (command.equals("datetime")) {
                    output.append(Commands.dateTime()); // Appelle la méthode pour afficher la date et l'heure
                } else if (command.equals("useraccount")) {
                    output.append(Commands.userAccount()); // Appelle la méthode pour afficher le nom de l'utilisateur du système
                } else if (command.equals("userhome")) {
                    output.append(Commands.userHome()); // Appelle la méthode pour afficher le répertoire personnel de l'utilisateur
                } else if (command.equals("os")) {
                    output.append(Commands.os()); // Appelle la méthode pour afficher des informations sur le système d'exploitation
                } else if (command.equals("printenv")) {
                    output.append(Commands.printenv(commandLineInput)); // Appelle la méthode pour afficher les variables d'environnement
                } else if (command.equals("echo") || command.equals("print")) {
                    output.append(Commands.echo(commandLineInput)); // Appelle la méthode pour afficher du texte spécifié
                } else if (command.equals("ls")) {
                    output.append(Commands.ls(commandLineInput)); // Appelle la méthode pour lister le contenu d'un répertoire
                } else if (command.equals("cat")) {
                    output.append(Commands.cat(commandLineInput)); // Appelle la méthode pour afficher le contenu d'un fichier texte
                } else {
                    output.append("Command '").append(command).append("' not found."); // Message si la commande n'est pas reconnue
                }
            }

            // Affiche la sortie résultante dans la console
            System.out.println(output);
            System.out.print("> "); // Affiche à nouveau le prompt pour une nouvelle saisie
        }

        scanner.close(); // Ferme le Scanner
        System.out.println("Bye !"); // Annonce la fin du programme
    }
}


import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;
import java.util.Arrays;
import java.util.List;
// Ajouts pour la commande cat
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Commands {

    // Méthode renvoyant la date actuelle au format String
    public static String date() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.toString();
    }

    // Méthode renvoyant l'heure actuelle au format String
    public static String time() {
        LocalTime currentTime = LocalTime.now();
        return currentTime.toString();
    }

    // Méthode renvoyant la date et l'heure actuelles au format String
    public static String dateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.toString();
    }

    // Méthode renvoyant le nom de l'utilisateur du système
    public static String userAccount() {
        return System.getProperty("user.name");
    }

    // Méthode renvoyant le répertoire personnel de l'utilisateur
    public static String userHome() {
        return System.getProperty("user.home");
    }

    // Méthode renvoyant des informations sur le système d'exploitation
    public static String os() {
        return System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
    }

    // Méthode pour afficher les variables d'environnement du système
    public static String printenv(CommandLine userInput) {
        String command = userInput.getCommand();
        String argument = userInput.getArgument();
        boolean hasArgu = userInput.hasArgument();
        StringBuilder output = new StringBuilder();

        if (!hasArgu) {
            // Récupère toutes les variables d'environnement et les concatène dans une chaîne
            Map<String, String> variables = System.getenv();
            for (Map.Entry<String, String> entry : variables.entrySet()) {
                output.append(entry.getKey()).append("=").append(entry.getValue()).append(System.lineSeparator());
            }
            return output.toString();
        } else {
            // Récupère la valeur de la variable d'environnement spécifiée en argument
            String envValue = System.getenv(argument);
            if (envValue == null) {
                return "";
            } else {
                return envValue;
            }
        }
    }

    // Méthode pour afficher le texte spécifié en argument
    public static String echo(CommandLine userInput) {
        String command = userInput.getCommand();
        String argument = userInput.getArgument();
        boolean hasArgu = userInput.hasArgument();

        if (!hasArgu) {
            // S'il n'y a pas d'argument, retourne une chaîne vide
            return "";
        } else {
            // Renvoie l'argument saisi
            return argument;
        }
    }

    // Méthode pour lister le contenu d'un répertoire spécifié
    public static String ls(CommandLine userInput) {
        // Récupère la commande et l'argument de l'utilisateur
        String command = userInput.getCommand();
        String argument = userInput.getArgument();
        // Vérifie si un argument a été fourni
        boolean hasArgu = userInput.hasArgument();
        // Initialise un objet pour stocker la sortie
        StringBuilder output = new StringBuilder();

        // Vérifie si un argument a été fourni
        if (!hasArgu) {
            // Retourne un message indiquant qu'aucun répertoire n'a été spécifié
            return "Not a directory";
        } else {
            // Récupère le chemin du répertoire depuis l'argument
            String filePath = argument;
            // Crée un objet File avec le chemin spécifié
            File path = new File(filePath);

            // Vérifie si le répertoire spécifié existe
            if (!path.exists()) {
                // Retourne un message indiquant que le répertoire n'existe pas
                return "Not a directory";
            } else if (path.isDirectory()) {
                // Vérifie si le chemin spécifié est un répertoire
                File[] list = path.listFiles(); // Récupère la liste des fichiers dans le répertoire

                // Parcourt la liste des fichiers dans le répertoire et les ajoute à la sortie
                for (File item : list) {
                    output.append(String.format("%s%n", item.getName())); // Ajoute le nom du fichier ou du répertoire
                }
            } else {
                // Si le chemin spécifié n'est pas un répertoire, retourne un message approprié
                return "Not a directory";
            }
        }
        
        // Retourne la liste des fichiers du répertoire sous forme de chaîne
        return output.toString();
    }
    
    // Méthode pour afficher le contenu d'un fichier texte
    public static String cat(CommandLine userInput) {
        // Récupère l'argument de la commande
        String argument = userInput.getArgument();
        // Vérifie si un argument a été fourni
        boolean hasArgu = userInput.hasArgument();
        // Initialise un objet pour stocker le contenu du fichier
        StringBuilder output = new StringBuilder();

        // Vérifie si un argument a été fourni
        if (!hasArgu) {
            // Retourne un message demandant de spécifier le chemin vers un fichier texte
            return "Please specify a path to a text file to read";
        } else {
            // Récupère le chemin du fichier depuis l'argument
            String filePath = argument;
            // Crée un objet File avec le chemin spécifié
            File file = new File(filePath);

            // Vérifie si le fichier existe et n'est pas un répertoire
            if (!file.exists() || file.isDirectory()) {
                // Retourne un message indiquant que le fichier n'a pas été trouvé ou est un répertoire
                return "File not found or is a directory";
            } try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 1;

                // Lit le fichier ligne par ligne et les ajoute au StringBuilder
                while ((line = reader.readLine()) != null) {
                    // Ajoute le numéro de ligne suivi du contenu de la ligne
                    output.append(lineNumber).append(". ").append(line).append("\n");
                    lineNumber++;
                }

                // Retourne le contenu du fichier sous forme de chaîne
                return output.toString();
            } catch (IOException e) {
                // Retourne un message d'erreur en cas de problème lors de la lecture du fichier
                return "Error reading file";
            }
        }
    }
}
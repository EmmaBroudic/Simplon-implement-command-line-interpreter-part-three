import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;
import java.util.Arrays;
import java.util.List;
// ajouts pour commande cat
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Commands {
    public static String date() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.toString();
    }

    public static String time() {
        LocalTime currentTime = LocalTime.now();
        return currentTime.toString();
    }

    public static String dateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.toString();
    }

    public static String userAccount() {
        return System.getProperty("user.name");
    }

    public static String userHome() {
        return System.getProperty("user.home");
    }

    public static String os() {
        return System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
    }

    public static String printenv(CommandLine userInput) {

        String command = userInput.getCommand();
        String argument = userInput.getArgument();
        int nbrElems = userInput.queryArg();

        StringBuilder output = new StringBuilder();

        if (nbrElems == 0) {
            Map<String, String> variables = System.getenv();
            for (Map.Entry<String, String> entry : variables.entrySet()) {
                output.append(entry.getKey()).append("=").append(entry.getValue()).append(System.lineSeparator());
            }
            return output.toString();
        } else {
            String homeValue = System.getenv(argument);
            if (homeValue == null) {
                return "";
            } else {
                return homeValue;
            }
        }
    }

    public static String echo(CommandLine userInput) {

        String command = userInput.getCommand();
        String argument = userInput.getArgument();
        int nbrElems = userInput.queryArg();

        //StringBuilder output = new StringBuilder();

        if (nbrElems == 0) {
            return "";
        } else {
            return argument;
    	}
    }

	public static String ls(CommandLine userInput) {	
		
        String command = userInput.getCommand();
        String argument = userInput.getArgument();
        int nbrElems = userInput.queryArg();

        StringBuilder output = new StringBuilder();

    	if (nbrElems == 0) {
        	return "Not a directory";
    	} else {
        	String filePath = argument;
        
        	File path = new File(filePath);

        	if (!path.exists()) {
            	return "Not a directory";
        	} else if (path.isDirectory()) {
            	File[] liste = path.listFiles();

      			for(File item : liste) {
        			if(item.isFile()) {
						output.append(String.format("%s%n", item.getName()));
        			} else if(item.isDirectory()) {
						output.append(String.format("%s%n", item.getName()));
            		}
				}
			} else {
                return "Not a directory";
            }
        }
    
    	return output.toString();
	}

    public static String cat(CommandLine userInput) {
        String command = userInput.getCommand();
        String argument = userInput.getArgument();
        int nbrElems = userInput.queryArg();

        // créer un nouveau nom de fichier
        int indexDuPoint = argument.indexOf('.');
        String newFileName = argument.substring(0, indexDuPoint);

        if (nbrElems == 0) {
            return "Please specify a path to a text file to read";
        } else {
            String filePath = argument;
            File file = new File(filePath);

            if (!file.exists() || file.isDirectory()) {
                return "File not found or is a directory";
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String outputFilePath = newFileName + "-me.txt"; // nom du nouveau fichier
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

                String line;
                
                int i = 1;

                while ((line = reader.readLine()) != null) {
                    String modifiedLine = i + ". " + line; // Ajoutez votre nouvel élément à chaque ligne
                    writer.write(modifiedLine);
                    writer.newLine(); // Écriture d'une nouvelle ligne dans le fichier de sortie
                    i++;
                }

                writer.close(); // Fermer le BufferedWriter après avoir fini l'écriture
                return "New file created";
            } catch (IOException e) {
                return "Error reading file";
            }
        }
    }
}
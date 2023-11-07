import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Cli {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt

		while (true) { // Infinite loop
			String userInput = scanner.nextLine();

			// Créer une instance de la classe CommandLine en utilisant l'entrée utilisateur
            		CommandLine field = new CommandLine(userInput);

            		// Obtenir la commande à partir de l'instance CommandLine
            		String command = field.getCommand();

            		// Obtenir l'argument à partir de l'instance CommandLine
            		String argument = field.getArgument();

			// Obtenir l'intégralité de la ligne de commande dans un tableau
			String[] parts = field.getWords();

			// Si la ligne de commande contient un argument, renvoie 1, sinon renvoie 0
			int query = field.queryArg();

			System.out.println(query);

			StringBuilder output = new StringBuilder();
			int nbrElems = parts.length;

			if (command.equals("exit") || command.equals("logout")) {
				break; // Forces exit of the while loop
			} else {
				if (command.equals("date")) {
					output.append(Commands.date());
				} else if (command.equals("time")) {
					output.append(Commands.time());
				} else if (command.equals("datetime")) {
					output.append(Commands.dateTime());
				} else if (command.equals("useraccount")) {
					output.append(Commands.userAccount()); // print name
				} else if (command.equals("userhome")) {
					output.append(Commands.userHome()); // print home
				} else if (command.equals("os")) {
					output.append(Commands.os()); // print OS
				} else if (command.equals("printenv")) {

					output.append(Commands.printenv(userInput));

					/*if (query < 2) {
        					Map<String, String> variables = System.getenv();
        					for (String key : variables.keySet()) {
            						output.append(key).append("=").append(variables.get(key)).append(System.lineSeparator());
      						}
					} else {
						String homeValue = System.getenv(argument);
						if (homeValue == null) {
							output.append("");
						} else {
							output.append(homeValue);
						}
					}*/
        			} else if (command.equals("echo") || command.equals("print")) {

					output.append(Commands.echo(userInput));

					/*if (nbrElems < 2) {
						output.append("");
					} else {						
						for (int i = 1; i < nbrElems; i++) {
							output.append(parts[i]).append(" ");
						}
					}*/
				} else if (command.equals("ls")) {
					output.append(Commands.ls(userInput));
					/*if (nbrElems < 2) {
						output.append("Not a directory");
					} else {
						String filePath = argument;
						
        					File path = new File(filePath);

						if (!path.exists()) {
							output.append("Not a directory");
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
							output.append("Not a directory");
						}
					}*/
				} else {
					output.append("Command '").append(parts[0]).append("' not found.");
				}
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye !");
    }

}


import java.util.Scanner;

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

			// Obtenir l'intégralité de la ligne de commande dans un tableau
			String[] parts = field.getWords();

			StringBuilder output = new StringBuilder();

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
        			} else if (command.equals("echo") || command.equals("print")) {
					output.append(Commands.echo(userInput));
				} else if (command.equals("ls")) {
					output.append(Commands.ls(userInput));
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


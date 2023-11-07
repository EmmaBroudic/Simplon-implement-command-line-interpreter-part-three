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
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;

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
    //public static String printenv(CommandLine commandLineInput)
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

        StringBuilder output = new StringBuilder();

        if (nbrElems == 0) {
            return "";
        } else {
            return argument;
        
	    //return output.toString();
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

    /*public static String cat(String userInput) {
        CommandLine field = new CommandLine(userInput);
    	String command = field.getCommand();
    	String argument = field.getArgument();
    	String[] parts = field.getWords();
    	int nbrElems = parts.length;
    	StringBuilder output = new StringBuilder();
    
        if (nbrElems < 2) {
        	return "Please specify a path to a text file to read";
    	} else {
        }
    
    }*/
}
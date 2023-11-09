import java.util.Scanner;

public class CommandLine {

    private String command;
    private String argument;
    

    public CommandLine(String input) {
        String[] words = input.split(" ", 2);

        if (words.length >= 2) {
            command = words[0];
            argument = words[1];
        } else if (words.length == 1) {
            command = words[0];
            argument = null;
        }
    }

    public String getCommand() {
        return command;
    }

    public String getArgument() {
        return argument;
    }

    public boolean hasArgument() {
        if (argument == null) {
            return false;
        } else {
            return true;
        }
    }
}
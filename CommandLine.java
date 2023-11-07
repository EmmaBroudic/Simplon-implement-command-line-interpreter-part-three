import java.util.Scanner;

public class CommandLine {

    private String command;
    private String argument;
    private String[] words;

    public CommandLine(String input) {
        words = input.split(" ", 2);

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

    public int queryArg() {
        if (argument == null) {
            return 0;
        } else {
            return 1;
        }
    }
}
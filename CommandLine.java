import java.util.Scanner;

public class CommandLine {

    private String fieldOne;
    private String fieldTwo;
    private String[] words;

    public CommandLine(String input) {
        words = input.split(" "); // Modifier la méthode split

        if (words.length >= 2) {
            fieldOne = words[0];
            fieldTwo = words[1];
        } else if (words.length == 1) {
            fieldOne = words[0];
            fieldTwo = null;
        }
    }

    public String getCommand() {
        return fieldOne;
    }

    public String getArgument() {
        return fieldTwo;
    }

    public String getWords() {
        return fieldOne + " " + fieldTwo;
    }

    public int queryArg() {
        if (fieldTwo == null) {
            return 0;
        } else {
            return 1;
        }
    }
}